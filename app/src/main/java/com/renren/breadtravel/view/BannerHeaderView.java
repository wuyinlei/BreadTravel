package com.renren.breadtravel.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.renren.breadtravel.R;
import com.renren.breadtravel.constant.Constants;

/**
 * Created by wuyinlei on 2016/12/15.
 */

public class BannerHeaderView extends RelativeLayout {
    public BannerHeaderView(Context context) {
        super(context);
        init(context);
    }

    public BannerHeaderView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public BannerHeaderView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public void init(Context context){
        inflate(context, R.layout.hot_fragment_banner_layout,this);
    }
}
