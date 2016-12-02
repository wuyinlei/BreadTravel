package com.renren.breadtravel.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * activity基类,用于一般的初始化控件,设置监听,请求数据
 */

public abstract class BaseActivity extends BaseSwipeBackActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getResultId());

        initView();
        initListener();
        initData();
    }

    /**
     * 子类用于传入布局id
     *
     * @return 布局id
     */
    protected abstract int getResultId();

    /**
     * 留着子类需要的时候去实现,并不是所有的activity都需要加载数据 比如引导页面
     */
    public void initData() {

    }

    /**
     * 子类用于设置监听器
     */
    protected abstract void initListener();

    /**
     * 子类用于查找控件
     */
    public abstract void initView();
}
