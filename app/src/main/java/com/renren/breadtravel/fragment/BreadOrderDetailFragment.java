package com.renren.breadtravel.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.renren.breadtravel.R;
import com.renren.breadtravel.base.BaseFragment;
import com.renren.breadtravel.constant.Constants;
import com.renren.breadtravel.constant.HttpUrlPath;

import static android.R.attr.fragment;


public class BreadOrderDetailFragment extends BaseFragment {


    /**
     * 用于传递一些数据信息
     *
     * @param cityId   cityId  用于拼接请求网址的
     * @param cityName 城市名字
     * @return BreadOrderDetailFragment对象
     */
    public static BreadOrderDetailFragment newInstance(String cityId, String cityName) {
        // Required empty public constructor
        Bundle bundle = new Bundle();
        bundle.putString(Constants.HOT_CITY_INDEX, cityId);
        bundle.putString(Constants.HOT_CITY_NAME, cityName);
        BreadOrderDetailFragment fragment = new BreadOrderDetailFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    private String mCityId, mCityName;

    private int start = 0;
    private int count = 10;
    private String url;

    private TextView mTvTitle;


    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        initViews(view);
        mCityId = getArguments().getString(Constants.HOT_CITY_INDEX);
        mCityName = getArguments().getString(Constants.HOT_CITY_NAME);
        if (!TextUtils.isEmpty(mCityId)) {
            url = HttpUrlPath.getBreadOrder(start, count, mCityId);
        }
        mTvTitle = (TextView) view.findViewById(R.id.tv_title);
        if (!TextUtils.isEmpty(mCityName)) {
            mTvTitle.setText(mCityName);
        }
        return view;
    }

    private void initViews(View view) {

    }

    @Override
    protected void initData() {

    }

}
