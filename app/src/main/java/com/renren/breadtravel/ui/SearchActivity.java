package com.renren.breadtravel.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.renren.breadtravel.R;
import com.renren.breadtravel.base.BaseSwipeActivity;
import com.renren.breadtravel.constant.Constants;
import com.renren.breadtravel.entity.HotInnerCity;
import com.renren.breadtravel.entity.HotOuterCity;
import com.renren.breadtravel.widget.flowlayout.TagBaseAdapter;
import com.renren.breadtravel.widget.flowlayout.TagCloudLayout;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends BaseSwipeActivity {

    //国内热门城市
    List<HotInnerCity> mHotInnerCity = new ArrayList<>();
    //国外热门城市
    List<HotOuterCity> mHotOuterCity = new ArrayList<>();
    private boolean is_from_hot_trip;
    private EditText mEditText;
    private TextView mTvCancel;
    private RelativeLayout mActivitySearch;
    private RelativeLayout mTitle;
    private RelativeLayout mReItemOne;
    private TextView mFlowLayoutOne;
    private TagCloudLayout mFlowLayoutOneItem;
    private RelativeLayout mReItemTwo;
    private TextView mFlowLayoutTwo;
    private TagCloudLayout mFlowLayoutTwoItem;
    private TextView mFlowLayoutThree;
    private TagCloudLayout mFlowLayoutThreeItem;

    private List<String> mHotOuterCityName = new ArrayList<>();
    private List<String> mHotInnerCityName = new ArrayList<>();


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
    }

    @Override
    public void initData() {
        super.initData();
        is_from_hot_trip = getIntent().getBooleanExtra(Constants.IS_SEARCH_COME_FROM_HOT_TRIP, false);
        if (is_from_hot_trip) {
            mHotInnerCity = (List<HotInnerCity>) getIntent().getSerializableExtra("hot_inner_city");
            mHotOuterCity = (List<HotOuterCity>) getIntent().getSerializableExtra("hot_out_city");
            if (mHotOuterCity.size() > 0 && mHotInnerCity.size() > 0) {
                mReItemTwo.setVisibility(View.VISIBLE);
               // Toast.makeText(this, "I am Here", Toast.LENGTH_SHORT).show();
                mFlowLayoutTwo.setText(getResources().getString(R.string.hot_trip_outer));
                mFlowLayoutThree.setText(getResources().getString(R.string.hot_trip_inner));
                int innerSize = mHotInnerCity.size();
                for (int i = 0; i < innerSize; i++) {
                    mHotInnerCityName.add(mHotInnerCity.get(i).getName());
                }
                int outterSize = mHotOuterCity.size();
                for (int i = 0; i < outterSize; i++) {
                    mHotOuterCityName.add(mHotOuterCity.get(i).getName());
                }

                if (mHotOuterCityName.size() > 0){
                    TagBaseAdapter tagBaseAdapter = new TagBaseAdapter(SearchActivity.this, mHotOuterCityName);
                    mFlowLayoutTwoItem.setAdapter(tagBaseAdapter);
                    mFlowLayoutTwoItem.setItemClickListener(new TagCloudLayout.TagItemClickListener() {
                        @Override
                        public void itemClick(int position) {
                            Toast.makeText(SearchActivity.this, mHotOuterCityName.get(position).toString(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }

                if (mHotInnerCityName.size() > 0){
                    TagBaseAdapter tagBaseAdapter = new TagBaseAdapter(SearchActivity.this,mHotInnerCityName);
                    mFlowLayoutThreeItem.setAdapter(tagBaseAdapter);
                    mFlowLayoutThreeItem.setItemClickListener(new TagCloudLayout.TagItemClickListener() {
                        @Override
                        public void itemClick(int position) {
                            Toast.makeText(SearchActivity.this, mHotInnerCityName.get(position).toString(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
            mEditText.setHint(getResources().getString(R.string.is_come_from_hot_trip_tip));
        } else {
            Toast.makeText(this, "I am from bread order fragment", Toast.LENGTH_SHORT).show();
            mEditText.setHint(getResources().getString(R.string.is_come_from_bread_trip_tip));
            mFlowLayoutThree.setText(getResources().getString(R.string.hot_search));
            mReItemTwo.setVisibility(View.GONE);
        }
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
        mFlowLayoutOneItem = (TagCloudLayout) findViewById(R.id.flow_layout_one_item);
        mFlowLayoutTwo = (TextView) findViewById(R.id.flow_layout_two);
        mFlowLayoutTwoItem = (TagCloudLayout) findViewById(R.id.flow_layout_two_item);
        mFlowLayoutThree = (TextView) findViewById(R.id.flow_layout_three);
        mFlowLayoutThreeItem = (TagCloudLayout) findViewById(R.id.flow_layout_three_item);
    }
}
