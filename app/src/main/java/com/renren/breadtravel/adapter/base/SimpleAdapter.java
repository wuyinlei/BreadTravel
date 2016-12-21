package com.renren.breadtravel.adapter.base;

import android.content.Context;

import java.util.List;

/**
 * Created by wuyinlei on 2016/12/21.
 */

public abstract class SimpleAdapter <T> extends BaseAdapter<T,BaseViewHolder> {

    public SimpleAdapter(Context context, int layoutResId) {
        super(context, layoutResId);
    }

    public SimpleAdapter(Context context, int layoutResId, List<T> datas) {
        super(context, layoutResId, datas);
    }
}
