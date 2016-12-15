package com.renren.breadtravel.adapter;


import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v13.app.FragmentStatePagerAdapter;

import com.renren.breadtravel.fragment.BreadOrderDetailFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wuyinlei on 2016/12/14.
 */

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> mFragments = new ArrayList<>();
    private  List<String> mFragmentTitles = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager fm, List<Fragment> fragments, List<String> strings) {
        super(fm);
        this.mFragments = fragments;
        this.mFragmentTitles = strings;
    }

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }


    /**
     *
     * @param fragment   添加的fragment
     * @param fragmentTitle   fragment的标题
     */
    public void addFragment(BreadOrderDetailFragment fragment, String fragmentTitle){
        mFragments.add(fragment);
        mFragmentTitles.add(fragmentTitle);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitles.get(position);
    }
}