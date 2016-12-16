package com.renren.breadtravel.fragment;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.avos.avoscloud.AVCloudQueryResult;
import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.CloudQueryCallback;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.renren.breadtravel.R;
import com.renren.breadtravel.adapter.ViewPagerAdapter;
import com.renren.breadtravel.base.BaseLeftFragment;
import com.renren.breadtravel.constant.Constants;
import com.renren.breadtravel.entity.HotCity;
import com.renren.breadtravel.ui.DragItemActivity;
import com.renren.breadtravel.utils.PreferencesUtils;
import com.renren.breadtravel.widget.CustomViewPager;

import java.util.ArrayList;
import java.util.List;


public class BreadOrderFragment extends BaseLeftFragment {

    private TabLayout mTabLayout;
    private CustomViewPager mCustomViewPager;

    private List<String> mTitles;
    private List<Fragment> mFragmentList = new ArrayList<>();

    private List<HotCity> mHotCities = new ArrayList<>();
    private ViewPagerAdapter mPagerAdapter;
    private List<String> countryName = new ArrayList<>();

    private ImageView mIvArrow;


    public BreadOrderFragment() {
        // Required empty public constructor
    }


    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_bread_order, container, false);
        initViews(view);
        // initFragments();
        return view;
    }

    @Override
    public void initData() {
        super.initData();

        String string = PreferencesUtils.getString(getActivity(), Constants.HOT_CITY_ITEM_DRAG);
        if (!TextUtils.isEmpty(string)) {
            List<HotCity> hotCities = new ArrayList<>();
            hotCities = new Gson().fromJson(string, new TypeToken<List<HotCity>>() {
            }.getType());
            if (hotCities != null) {
                mHotCities.addAll(hotCities);

                for (HotCity city : mHotCities) {
                    countryName.add(city.ciryName);
                }
                initFragments();

                //请求数据之后再设置  也就是第一次进行请求,之后都保存到本地
                initTabs();
            }
        } else {
            String sql = "select * from City";
            AVQuery.doCloudQueryInBackground(sql, new CloudQueryCallback<AVCloudQueryResult>() {
                @Override
                public void done(AVCloudQueryResult avCloudQueryResult, AVException e) {
                    List<? extends AVObject> results = avCloudQueryResult.getResults();
                    for (int i = 0; i < results.size(); i++) {
                        HotCity hotCity = new HotCity();
                        hotCity.ciryName = (String) results.get(i).get("city_name");
                        hotCity.cityId = (String) results.get(i).get("city_id");
                        mHotCities.add(hotCity);
                    }

                    Gson gson = new Gson();
                    String hotCityJson = gson.toJson(mHotCities);
                    PreferencesUtils.putString(getActivity(), Constants.HOT_CITY_ITEM_DRAG, hotCityJson);

                    for (HotCity city : mHotCities) {
                        countryName.add(city.ciryName);
                    }
                    initFragments();

                    //请求数据之后再设置  也就是第一次进行请求,之后都保存到本地
                    initTabs();
                }
            });
        }


    }

    private void initTabs() {
        mPagerAdapter = new ViewPagerAdapter(getChildFragmentManager(), mFragmentList, countryName);
        mCustomViewPager.setAdapter(mPagerAdapter);
        mTabLayout.setupWithViewPager(mCustomViewPager);
        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        //mTabLayout.setTabGravity(TabLayout.MODE_FIXED);
    }


    private void initFragments() {
        //mFragmentList = new ArrayList<>();
        for (int i = 0; i < mHotCities.size(); i++) {
            mFragmentList.add(BreadOrderDetailFragment.newInstance(mHotCities.get(i).cityId));
        }

    }

    private void initViews(View view) {
        mTabLayout = (TabLayout) view.findViewById(R.id.tab_layout);
        mCustomViewPager = (CustomViewPager) view.findViewById(R.id.container);
        mIvArrow = (ImageView) view.findViewById(R.id.img_arrow);
    }

    public static final int REQUEST_CODE = 100;
    public static final int RESULT_CODE = 101;
    public static final int RESULT_CODE_INDEX = 102;

    @Override
    protected void initListener() {
        if (mHotCities != null) {
            mIvArrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Toast.makeText(getActivity(), "点击我饿", Toast.LENGTH_SHORT).show();
                    startActivityForResult(new Intent(getActivity(), DragItemActivity.class), REQUEST_CODE);
                    //  intent.putExtra(Constants.HOT_CITY_ITEM_DRAG,mHotCities);
                }
            });
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_CODE) {
                // String cityName = PreferencesUtils.getCityName(this);
                // mSettingCity.setText(cityName);
                String string = PreferencesUtils.getString(getActivity(), Constants.HOT_CITY_ITEM_DRAG);
                List<HotCity> hotCities = new ArrayList<>();
                List<HotCity> lastHotCities = new ArrayList<>();
                hotCities = new Gson().fromJson(string, new TypeToken<List<HotCity>>() {
                }.getType());
                //清空以下数据  防止数据重复
                countryName.clear();
                mHotCities.clear();
                mFragmentList.clear();
                mHotCities = hotCities;
                for (HotCity city : hotCities) {
                    countryName.add(city.ciryName);
                }
                initFragments();

                //请求数据之后再设置  也就是第一次进行请求,之后都保存到本地
                initTabs();

                // TODO: 2016/12/15  在这里可以进行回调  然后对fragment的标题栏重新生成
            } else if (resultCode == RESULT_CODE_INDEX) {
                int position = PreferencesUtils.getInt(getActivity(), Constants.CURRENT_INDEX, 0);
                mCustomViewPager.setCurrentItem(position);
            }
        }
        super.onActivityResult(requestCode, resultCode, data);

    }


}
