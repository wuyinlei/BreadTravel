package com.renren.breadtravel.fragment;


import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.renren.breadtravel.R;
import com.renren.breadtravel.base.BaseLeftFragment;
import com.renren.breadtravel.constant.HttpUrlPath;
import com.renren.breadtravel.widget.banner.BannerPagerAdapter;
import com.renren.breadtravel.widget.banner.MyPagerListener;
import com.renren.breadtravel.widget.banner.ViewPagerIndicator;
import com.renren.breadtravel.widget.recycler.view.LRecyclerView;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class HotTripFragment extends BaseLeftFragment {


    private LRecyclerView mLRecyclerView;

    private ViewPagerIndicator mIndicator;
    private ViewPager mViewPager;
    private List<String> imgUrls = new ArrayList<>();
    private BannerPagerAdapter mBannerPagerAdapter;


    @Override
    protected void initListener() {

    }

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hot_trip, container, false);

        return view;
    }

    @Override
    public void initData() {
        super.initData();

        OkGo.get(HttpUrlPath.HOME_POPULAR_TRAVEL)
                .execute(new StringCallback(){
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        parseJson(s);
                    }
                });

       // initHeaderView(imgUrls);
    }

    /**
     * 解析数据
     * @param s  result
     */
    private void parseJson(String s) {
        Type type = new TypeToken<PropularTravelData>(){}.getType();
        PropularTravelData data = new Gson().fromJson(s,type);
        Log.d("HotTripFragment", "data.data:" + data.data);
    }

    private void initHeaderView(List<String> imgUrls) {
        View headerView= LayoutInflater.from(getActivity())
                .inflate(R.layout.hot_fragment_banner_layout,null);
        mViewPager = (ViewPager) headerView.findViewById(R.id.view_pager);
        mIndicator = (ViewPagerIndicator) headerView.findViewById(R.id.indicator);
        mBannerPagerAdapter = new BannerPagerAdapter(getChildFragmentManager(), imgUrls);
        mViewPager.setAdapter(mBannerPagerAdapter);
        mViewPager.setOnPageChangeListener(new MyPagerListener(mIndicator,imgUrls.size()));
        autoScorll();
    }


    private Handler mHandler = new Handler();

    /**
     * 自动滚动
     */
    private void autoScorll(){
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                int currentItem = mViewPager.getCurrentItem();
                mViewPager.setCurrentItem(currentItem + 1);
                mHandler.postDelayed(this,50000);
            }
        },5000);
    }

}
