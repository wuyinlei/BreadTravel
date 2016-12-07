package com.renren.breadtravel.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.renren.breadtravel.R;
import com.renren.breadtravel.base.BaseSwipeActivity;

public class ScenicDetailActivity extends BaseSwipeActivity {

    private RelativeLayout mActivityScenicDetail;
    private RelativeLayout mReLl;
    private ImageView mImgBack;
    private ImageView mImgShare;
    private ImageView mImgReport;
    private ImageView mImgLove;
    private ImageView mImgDownload;
    private RecyclerView mRecyclerView;



    @Override
    protected int getResultId() {
        return R.layout.activity_scenic_detail;
    }

    @Override
    protected void initListener() {

    }

    @Override
    public void initView() {
        mActivityScenicDetail = (RelativeLayout) findViewById(R.id.activity_scenic_detail);
        mReLl = (RelativeLayout) findViewById(R.id.re_ll);
        mImgBack = (ImageView) findViewById(R.id.img_back);
        mImgShare = (ImageView) findViewById(R.id.img_share);
        mImgReport = (ImageView) findViewById(R.id.img_report);
        mImgLove = (ImageView) findViewById(R.id.img_love);
        mImgDownload = (ImageView) findViewById(R.id.img_download);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
    }
}
