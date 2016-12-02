package com.renren.breadtravel.widget.banner;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wuyinlei on 2016/12/2.
 */

public class BannerPagerAdapter extends FragmentPagerAdapter {


    private List<String> imageUrls = new ArrayList<>();

    public BannerPagerAdapter(FragmentManager fm, List<String> imageUrls) {
        super(fm);
        this.imageUrls = imageUrls;
    }


    @Override
    public Fragment getItem(int position) {
        position%=imageUrls.size();
        BannerFragment fragment = new BannerFragment();
        fragment.setImgRes(imageUrls.get(position));
        int finalPosition = position;
        fragment.setOnClickListener(new BannerFragment.OnClickListener() {
           @Override
           public void onClick(View v) {
               if (mOnClickListener !=null){
                   mOnClickListener.onClick(v, finalPosition);
               }
           }
       });
        return fragment;
    }

    @Override
    public int getCount() {
        return 1000000;
    }


    private OnClickListener mOnClickListener;

    public interface OnClickListener {
        void  onClick(View v,int position);
    }

    public void setOnClickListener(OnClickListener onClickListener){
        this.mOnClickListener = onClickListener;
    }
}
