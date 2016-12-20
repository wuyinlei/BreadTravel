package com.renren.breadtravel.ui;

import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.renren.breadtravel.R;
import com.renren.breadtravel.base.BaseSwipeActivity;
import com.renren.breadtravel.constant.Constants;
import com.renren.breadtravel.constant.HttpUrlPath;
import com.renren.breadtravel.db.SearchDbHelper;
import com.renren.breadtravel.entity.HotInnerCity;
import com.renren.breadtravel.entity.HotOuterCity;
import com.renren.breadtravel.entity.HotRecomment;
import com.renren.breadtravel.widget.flow.FlowLayout;
import com.renren.breadtravel.widget.flow.MyTextView;
import com.renren.breadtravel.widget.flowlayout.TagBaseAdapter;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

public class SearchActivity extends BaseSwipeActivity {

    //国内热门城市
    List<HotInnerCity> mHotInnerCity = new ArrayList<>();
    //国外热门城市
    List<HotOuterCity> mHotOuterCity = new ArrayList<>();

    //热门推荐   城市  酒店   旅店
    List<HotRecomment.DataBean> mHotRecomments = new ArrayList<>();
    private boolean is_from_hot_trip;
    private EditText mEditText;
    private TextView mTvCancel;
    private RelativeLayout mActivitySearch;
    private RelativeLayout mTitle;
    private RelativeLayout mReItemOne;
    private TextView mFlowLayoutOne;
    private FlowLayout mFlowLayoutOneItem;
    private RelativeLayout mReItemTwo;
    private TextView mFlowLayoutTwo;
    private FlowLayout mFlowLayoutTwoItem;
    private TextView mFlowLayoutThree;
    private FlowLayout mFlowLayoutThreeItem;

    private List<String> mHotOuterCityName = new ArrayList<>();
    private List<String> mHotInnerCityName = new ArrayList<>();
    private List<String> mHotCityName = new ArrayList<>();

    private SearchDbHelper mSearchDbHelper;
    private MyTextView mMyTextView;

    private List<String> mHistoryKey = new ArrayList<>();


    @Override
    protected int getResultId() {
        return R.layout.activity_search;
    }

    @Override
    protected void initListener() {
        mTvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SearchActivity.this.finish();
            }
        });


        mEditText.setOnKeyListener((v, keyCode, event) -> {
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN) {// 修改回车键功能
                // 先隐藏键盘
                ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(
                        getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                // 按完搜索键后将当前查询的关键字保存起来,如果该关键字已经存在就不执行保存
                String trim = mEditText.getText().toString().trim();
                if (is_from_hot_trip) {
                    if (!mSearchDbHelper.hasTripData(trim))
                        mSearchDbHelper.insertTripData(trim);
                } else {
                    if (!mSearchDbHelper.hasHotData(trim))
                        mSearchDbHelper.insertHotData(trim);
                }
//                SearchHistory history = new SearchHistory();
//                history.searchKey = trim;
//                history.save(new SaveListener<String>() {
//                    @Override
//                    public void done(String s1, BmobException e) {
//
//
//                    }
//                });

                Intent intent = new Intent(SearchActivity.this, SearchResultActivity.class);
                intent.putExtra("key", trim);
                //发现他们跳转不是同一个结果
                intent.putExtra(Constants.IS_SEARCH_COME_FROM_HOT_TRIP,is_from_hot_trip);
                startActivity(intent);

            }
            return false;
        });

        mEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().trim().length() == 0) {
                    requestHistoryData();
                } else {
                }
            }
        });
    }

    private void requestHistoryData() {
        mHistoryKey.clear();
        if (is_from_hot_trip) {
            List<String> strings = mSearchDbHelper.queryTripData();
            if (strings.size() > 0) {
                mHistoryKey = strings;
                for (int i = 0; i < mHistoryKey.size(); i++) {
                    mReItemOne.setVisibility(View.VISIBLE);
                    TextView label = mMyTextView.getLabel(mHistoryKey.get(i), SearchActivity.this, i);
                    mFlowLayoutOneItem.addView(label,
                            mFlowLayoutOneItem.getChildCount(), new ViewGroup
                                    .MarginLayoutParams(ViewGroup.MarginLayoutParams.WRAP_CONTENT,
                                    ViewGroup.MarginLayoutParams.WRAP_CONTENT));
                }
            }
        } else {
            List<String> strings = mSearchDbHelper.queryHotData();
            if (strings.size() > 0) {
                mHistoryKey = strings;
                for (int i = 0; i < mHistoryKey.size(); i++) {
                    mReItemOne.setVisibility(View.VISIBLE);
                    TextView label = mMyTextView.getLabel(mHistoryKey.get(i), SearchActivity.this, i);
                    mFlowLayoutOneItem.addView(label,
                            mFlowLayoutThreeItem.getChildCount(), new ViewGroup
                                    .MarginLayoutParams(ViewGroup.MarginLayoutParams.WRAP_CONTENT,
                                    ViewGroup.MarginLayoutParams.WRAP_CONTENT));
                }
            }
        }
    }

    @Override
    public void initData() {
        super.initData();
        is_from_hot_trip = getIntent()
                .getBooleanExtra(Constants.IS_SEARCH_COME_FROM_HOT_TRIP, false);
        requestHistoryData();
        if (is_from_hot_trip) {
            initFromTripSearch();
        } else {
            initHotCitySearch();
        }
    }

    /**
     * 来自热门城市的搜索
     */
    private void initHotCitySearch() {


        mEditText.setHint(getResources().getString(R.string.is_come_from_bread_trip_tip));
        mFlowLayoutThree.setText(getResources().getString(R.string.hot_search));
        mReItemTwo.setVisibility(View.GONE);
        OkGo.get(HttpUrlPath.IS_HOT_CITY_LIST_URL)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        HotRecomment recomment = new Gson().fromJson(s,
                                new TypeToken<HotRecomment>() {
                                }.getType());
                        if (recomment != null) {
                            mHotRecomments = recomment.getData();
                            if (mHotRecomments.size() > 0) {
                                for (HotRecomment.DataBean dataBean : mHotRecomments) {
                                    mHotCityName.add(dataBean.getName());
                                }
                            }
                            if (mHotCityName.size() > 0) {
                                for (int i = 0; i < mHotCityName.size(); i++) {
                                    //  final int pos = i;
                                    MyTextView myTextView1 = new MyTextView();
                                    TextView textView = myTextView1.getLabel(mHotCityName.get(i),
                                            SearchActivity.this, i);
                                    mFlowLayoutThreeItem.addView(textView,
                                            mFlowLayoutThreeItem.getChildCount(), new ViewGroup
                                                    .MarginLayoutParams(ViewGroup.MarginLayoutParams.WRAP_CONTENT,
                                                    ViewGroup.MarginLayoutParams.WRAP_CONTENT));
                                    //textView.setOnItemClickListener

                                }
                            }

//                            mFlowLayoutThreeItem.setAdapter(
//                                    new TagBaseAdapter(SearchActivity.this,
//                                            mHotCityName)
//                            );
//                            mFlowLayoutThreeItem.setItemClickListener(
//                                    new TagCloudLayout.TagItemClickListener() {
//                                        @Override
//                                        public void itemClick(int position) {
//                                            Toast.makeText(SearchActivity.this,
//                                                    mHotCityName.get(position),
//                                                    Toast.LENGTH_SHORT).show();
//                                        }
//                                    });
                        }
                    }
                });
    }

    /**
     * 来自热门游记的搜索
     */
    private void initFromTripSearch() {

        mHotInnerCity = (List<HotInnerCity>) getIntent()
                .getSerializableExtra("hot_inner_city");
        mHotOuterCity = (List<HotOuterCity>) getIntent()
                .getSerializableExtra("hot_out_city");
        if (mHotOuterCity.size() > 0 && mHotInnerCity.size() > 0) {
            mReItemTwo.setVisibility(View.VISIBLE);
            // Toast.makeText(this, "I am Here", Toast.LENGTH_SHORT).show();
            mFlowLayoutTwo.setText(getResources().getString(R.string.hot_trip_outer));
            mFlowLayoutThree.setText(getResources().getString(R.string.hot_trip_inner));
            final int innerSize = mHotInnerCity.size();
            for (int i = 0; i < innerSize; i++) {
                mHotInnerCityName.add(mHotInnerCity.get(i).getName());
            }
            final int outterSize = mHotOuterCity.size();
            for (int i = 0; i < outterSize; i++) {
                mHotOuterCityName.add(mHotOuterCity.get(i).getName());
            }

            if (mHotInnerCityName.size() > 0) {
                TagBaseAdapter tagBaseAdapter = new TagBaseAdapter(
                        SearchActivity.this, mHotInnerCityName);
//                mFlowLayoutThreeItem.setAdapter(tagBaseAdapter);
//                mFlowLayoutThreeItem.setItemClickListener(new TagCloudLayout
//                        .TagItemClickListener() {
//                    @Override
//                    public void itemClick(int position) {
//                        Toast.makeText(SearchActivity.this,
//                                mHotInnerCityName.get(position).toString(), Toast.LENGTH_SHORT).show();
//                    }
//                });
                // int innerSize = mHotInnerCityName.size();

                for (int i = 0; i < innerSize; i++) {

                    TextView textView = mMyTextView.getLabel(mHotInnerCityName.get(i),
                            SearchActivity.this, i);
                    mFlowLayoutThreeItem.addView(textView,
                            mFlowLayoutThreeItem.getChildCount(), new ViewGroup
                                    .MarginLayoutParams(ViewGroup.MarginLayoutParams.WRAP_CONTENT,
                                    ViewGroup.MarginLayoutParams.WRAP_CONTENT));
                    mFlowLayoutThreeItem.setOnItemClickListener(new FlowLayout.OnItemClickListener() {
                        @Override
                        public void OnItemClick(View view, int position) {
                            //position = getRealPosition(innerSize,position);

                           // Toast.makeText(SearchActivity.this, mHotInnerCityName.get(position), Toast.LENGTH_SHORT).show();

                            Intent intent = new Intent(SearchActivity.this,SerachResultItemActivity.class);
                            intent.putExtra("id",mHotInnerCity.get(position).getId());
                            intent.putExtra("city",mHotInnerCity.get(position).getName());
                            startActivity(intent);
                        }
                    });
                }


            }

            if (mHotOuterCityName.size() > 0) {
//                TagBaseAdapter tagBaseAdapter = new TagBaseAdapter(SearchActivity.this,
//                        mHotOuterCityName);
//                mFlowLayoutTwoItem.setAdapter(tagBaseAdapter);
//                mFlowLayoutTwoItem.setItemClickListener(new TagCloudLayout
//                        .TagItemClickListener() {
//                    @Override
//                    public void itemClick(int position) {
//                        Toast.makeText(SearchActivity.this,
//                                mHotOuterCityName.get(position).toString(),
//                                Toast.LENGTH_SHORT).show();
//                    }
//                });

                final int size = mHotOuterCityName.size();
                // MyTextView myTextView2 = new MyTextView();
                for (int i = 0; i < outterSize; i++) {

                    TextView textView = mMyTextView.getLabel(mHotOuterCityName.get(i),
                            SearchActivity.this, i);
                    mFlowLayoutTwoItem.addView(textView,
                            mFlowLayoutTwoItem.getChildCount(), new ViewGroup
                                    .MarginLayoutParams(ViewGroup.MarginLayoutParams.WRAP_CONTENT,
                                    ViewGroup.MarginLayoutParams.WRAP_CONTENT));
                    mFlowLayoutTwoItem.setOnItemClickListener(new FlowLayout.OnItemClickListener() {
                        @Override
                        public void OnItemClick(View view, int position) {
                            // position = getRealPosition(outterSize,position);
                            //Toast.makeText(SearchActivity.this, mHotOuterCityName.get(position), Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(SearchActivity.this,SerachResultItemActivity.class);
                            intent.putExtra("id",mHotOuterCity.get(position).getId());
                            intent.putExtra("city",mHotOuterCity.get(position).getName());
                            startActivity(intent);
                        }
                    });
                }

            }


        }
        mEditText.setHint(getResources().getString(R.string.is_come_from_hot_trip_tip));
    }

    @Override
    public void initView() {
        mEditText = (EditText) findViewById(R.id.edit_text);
        mTvCancel = (TextView) findViewById(R.id.tv_cancel);
        mActivitySearch = (RelativeLayout) findViewById(R.id.activity_search);
        mTitle = (RelativeLayout) findViewById(R.id.title);
        mReItemOne = (RelativeLayout) findViewById(R.id.re_item_one);
        mFlowLayoutOne = (TextView) findViewById(R.id.flow_layout_one);
        mReItemTwo = (RelativeLayout) findViewById(R.id.re_item_two);
        mFlowLayoutOneItem = (FlowLayout) findViewById(R.id.flow_layout_one_item);
        mFlowLayoutTwo = (TextView) findViewById(R.id.flow_layout_two);
        mFlowLayoutTwoItem = (FlowLayout) findViewById(R.id.flow_layout_two_item);
        mFlowLayoutThree = (TextView) findViewById(R.id.flow_layout_three);
        mFlowLayoutThreeItem = (FlowLayout) findViewById(R.id.flow_layout_three_item);
        mSearchDbHelper = SearchDbHelper.getSearchDbHelper(this);
        mMyTextView = new MyTextView();

    }

    private int getRealPosition(int size, int position) {
        if (position == 0) {
            return size - 1;
        }
        return position - 1;

    }

//    private TextView getLabel(String text) {
//        TextView label = new TextView(this);
//        label.setTextColor(Color.WHITE);
//        label.setBackgroundResource(R.drawable.flow_view_bg_corner);
//        label.setGravity(Gravity.CENTER);
//        label.setSingleLine(true);
//        label.setEllipsize(TextUtils.TruncateAt.END);
//        int padding = FlowLayout.dp2px(this, 5);
//        label.setPadding(padding, padding, padding, padding);
//        label.setText(text);
//        //在这里设置点击事件
//        label.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(SearchActivity.this, text.toString(), Toast.LENGTH_SHORT).show();
//            }
//        });
//        return label;
//    }


}
