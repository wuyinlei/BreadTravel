package com.renren.breadtravel.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by wuyinlei on 2016/12/17.
 */

public class Drawer extends View {
    public Drawer(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }


    public Drawer(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public Drawer(Context context) {
        super(context);
        init();
    }

    Paint mPaint;

    private void init() {

        mPaint = new Paint();
        mPaint.setColor(Color.RED);                      //设置画笔颜色
        //mPaint.setAlpha(100);                            //设置画笔的透明度
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

    }
}
