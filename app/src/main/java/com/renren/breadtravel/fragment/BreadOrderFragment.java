package com.renren.breadtravel.fragment;


import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.avos.avoscloud.AVCloudQueryResult;
import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.CloudQueryCallback;
import com.renren.breadtravel.R;
import com.renren.breadtravel.adapter.ViewPagerAdapter;
import com.renren.breadtravel.base.BaseLeftFragment;
import com.renren.breadtravel.entity.HotCity;
import com.renren.breadtravel.widget.CustomViewPager;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
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

                Toast.makeText(getActivity(), "mHotCities.size():" + mHotCities.size(), Toast.LENGTH_SHORT).show();
                for (HotCity city : mHotCities) {
                    countryName.add(city.ciryName);
                }
                initFragments();

                //请求数据之后再设置  也就是第一次进行请求,之后都保存到本地
                initTabs();
            }
        });



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


    @Override
    protected void initListener() {
        mIvArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "点击我饿", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
