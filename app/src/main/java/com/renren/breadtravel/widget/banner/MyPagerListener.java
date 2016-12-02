package com.renren.breadtravel.widget.banner;

import android.graphics.Color;
import android.icu.util.ValueIterator;
import android.support.v4.view.ViewPager;

/**
 * Created by wuyinlei on 2016/12/2.
 */

public class MyPagerListener implements ViewPager.OnPageChangeListener {

    private ViewPagerIndicator mIndicator;

    private int count;

    /**
     * 构造器
     *
     * @param indicator 指示器
     * @param count     轮播数据集合长度
     */
    public MyPagerListener(ViewPagerIndicator indicator, int count) {
        mIndicator = indicator;
        this.count = count;
        mIndicator.setNumbers(count);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        position = position % count; //这里count  是传入的图片集合的长度,取余是为了指示器能够循环往复
        int index = count; //这里定义一个变量,用来记录是否是最后一个指示器
        if (position + 1 == count){ //如果是最后一个指示器
            index = ViewPagerIndicator.INDEX_TAG;
        }
        mIndicator.setOfX(position,positionOffset,index);
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
