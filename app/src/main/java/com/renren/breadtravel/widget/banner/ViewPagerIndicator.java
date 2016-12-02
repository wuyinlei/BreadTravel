package com.renren.breadtravel.widget.banner;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.renren.breadtravel.R;

/**
 * Created by wuyinlei on 2016/12/2.
 */

public class ViewPagerIndicator extends View {

    public static final int INDEX_TAG = -1;

    private Paint mForcePaint;  //前置画笔
    private Paint mBackgroundPaint; //背景画笔

    //圆圈半径
    private int radius = 12;

    //前景* 坐标
    private float foreOffx;

    //小圆圈的数量
    private int mNumbers;

    private float mGapWidth;
    private int mFroceColor;
    private int mBackgroundColor;


    public ViewPagerIndicator(Context context) {
        super(context);
    }

    public ViewPagerIndicator(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray attributes = context
                .obtainStyledAttributes(attrs, R.styleable.ViewPagerIndicator);

        mFroceColor = attributes.getColor(R.styleable.ViewPagerIndicator_foreColor, Color.BLUE);
        mBackgroundColor = attributes.getColor(R.styleable.ViewPagerIndicator_backgroundColor, Color.GRAY);
        mNumbers = attributes.getInt(R.styleable.ViewPagerIndicator_numbers, 4);


        //初始化画笔
        initPaint();
    }

    /**
     * 初始化画笔
     */
    private void initPaint() {
        //前景
        mForcePaint = new Paint();
        mForcePaint.setColor(mFroceColor);
        mForcePaint.setStyle(Paint.Style.FILL);

        //背景
        mBackgroundPaint = new Paint();
        mBackgroundPaint.setColor(mBackgroundColor);
        mBackgroundPaint.setStyle(Paint.Style.FILL);

        //间距
        mGapWidth = (float) (4.0 * radius);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0; i < mNumbers; i++) {
            //起始坐标+i*间距
            canvas.drawCircle(16 + i * mGapWidth, 16, radius, mBackgroundPaint);
        }
        canvas.drawCircle(16 + foreOffx, 16, radius, mForcePaint);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSpecSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSpecSize = MeasureSpec.getSize(heightMeasureSpec);
        //这里就是对wrap_content的支持
        if (widthSpecMode == MeasureSpec.AT_MOST && heightSpecMode == MeasureSpec.AT_MOST) {
            //这里设定的根据自己自定义的view的情况而定
            setMeasuredDimension(2 * radius + 16 + (mNumbers) * 3 * radius, 16 + 2 * radius);
        } else if (widthSpecMode == MeasureSpec.AT_MOST){
            setMeasuredDimension(2 * radius + 16 + (mNumbers) * 3 * radius,heightSpecSize);
        } else if (heightSpecMode == MeasureSpec.AT_MOST){
            setMeasuredDimension(widthSpecSize, 16 + 2 * radius);

        }

    }

    /**
     *
     * @param position  当前指示器位置
     * @param pec  偏移量百分比
     * @param index   约定的标志位
     */
    public void setOfX(int position, float pec, int index) {
        if(index == INDEX_TAG)
            pec = 0.0f;  //如果和约定好的数值对应,证明是最后一个,把这个百分比清零,如果不清零,会有一个向➡滑动的趋势和距离
        float pagerX =(float) position * mGapWidth;
        //计算出偏移
        foreOffx = pagerX + mGapWidth * pec;
        //重新绘制
        invalidate();
    }

    public void setNumbers(int numbers) {
       this.mNumbers = numbers;
    }
}
