package com.renren.breadtravel.fragment;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.renren.breadtravel.R;
import com.renren.breadtravel.base.BaseLeftFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class HotTripFragment extends BaseLeftFragment {


    public HotTripFragment() {
        // Required empty public constructor
    }



    @Override
    protected void initListener() {

    }

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_hot_trip, container, false);
    }

}
