package com.renren.breadtravel.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.renren.breadtravel.R;
import com.renren.breadtravel.base.BaseFragment;
import com.renren.breadtravel.cn.sharesdk.onekeyshare.CustomerLogo;
import com.renren.breadtravel.constant.Constants;
import com.renren.breadtravel.constant.HttpUrlPath;

/**
 * A simple {@link Fragment} subclass.
 */
public class BreadOrderDetailFragment extends BaseFragment {


    public static BreadOrderDetailFragment newInstance(String cityId) {
        // Required empty public constructor
        Bundle bundle = new Bundle();
        bundle.putString(Constants.HOT_CITY_INDEX, cityId);
        BreadOrderDetailFragment fragment = new BreadOrderDetailFragment();
        fragment.setArguments(bundle);
        return  fragment;
    }

    private String cityId;

    private int start = 0;
    private int count = 10;
    private String url;


    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        initViews(view);
        cityId = getArguments().getString(Constants.HOT_CITY_INDEX);
        if (!TextUtils.isEmpty(cityId)){
            url = HttpUrlPath.getBreadOrder(start, count,cityId);
        }
        return view;
    }

    private void initViews(View view) {

    }

    @Override
    protected void initData() {

    }

}
