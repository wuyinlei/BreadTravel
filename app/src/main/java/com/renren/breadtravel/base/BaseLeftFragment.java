package com.renren.breadtravel.base;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 用于左侧菜单栏的几个fragment的基类 因为这三个不需要什么懒加载数据  就写了一般的常用的方法
 */
public abstract class BaseLeftFragment extends Fragment {

    protected LayoutInflater inflater;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.inflater = inflater;
        View view = initView(inflater, container, savedInstanceState);
        initListener();
        initData();
        return view;
    }

    public void initData() {

    }

    /**
     * 控件点击事件设置
     */
    protected abstract void initListener();

    /**
     * view的初始化
     * @param inflater  布局加载器
     * @param container  布局容器
     * @param savedInstanceState  可以用于保存数据
     * @return  view
     */
    protected abstract View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);


}
