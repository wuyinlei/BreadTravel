package com.renren.breadtravel.widget.flow;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.renren.breadtravel.R;

/**
 * Created by wuyinlei on 2016/12/20.
 */

public class MyTextView {

    /**
     * 获取textview
     *
     * @param text     传入的字符串
     * @param context  上下文
     * @param position 位置
     * @return TextView
     */
    public  TextView getLabel(String text, Context context, int position) {
        TextView label = new TextView(context);
        label.setTextColor(Color.WHITE);
        label.setBackgroundResource(R.drawable.flow_view_bg_corner);
        label.setGravity(Gravity.CENTER);
        label.setSingleLine(true);
        label.setEllipsize(TextUtils.TruncateAt.END);
        int padding = FlowLayout.dp2px(context, 5);
        label.setPadding(padding, padding, padding, padding);
        label.setText(text);

        return label;
    }



}
