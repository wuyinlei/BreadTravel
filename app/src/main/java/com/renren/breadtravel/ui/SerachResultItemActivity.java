package com.renren.breadtravel.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.renren.breadtravel.R;
import com.renren.breadtravel.base.BaseSwipeActivity;

public class SerachResultItemActivity extends BaseSwipeActivity {

    private RelativeLayout mActivitySerachResultItem;
    private RelativeLayout mTitle;
    private ImageView mImgBack;
    private EditText mEditText;
    private RelativeLayout mReDestination;
    private TextView mTvDestination;
    private RecyclerView mRecyclerViewDestination;
    private RelativeLayout mReTripStory;
    private TextView mTvStory;
    private RecyclerView mRecyclerViewStory;
    private RelativeLayout mReUser;
    private TextView mTvUser;
    private RecyclerView mRecyclerViewUser;


    @Override
    protected int getResultId() {
        return R.layout.activity_serach_result_item;
    }

    @Override
    protected void initListener() {

    }

    @Override
    public void initView() {
        mActivitySerachResultItem = (RelativeLayout) findViewById(R.id.activity_serach_result_item);
        mTitle = (RelativeLayout) findViewById(R.id.title);
        mImgBack = (ImageView) findViewById(R.id.img_back);
        mEditText = (EditText) findViewById(R.id.edit_text);
        mReDestination = (RelativeLayout) findViewById(R.id.re_destination);
        mTvDestination = (TextView) findViewById(R.id.tv_destination);
        mRecyclerViewDestination = (RecyclerView) findViewById(R.id.recycler_view_destination);
        mReTripStory = (RelativeLayout) findViewById(R.id.re_trip_story);
        mTvStory = (TextView) findViewById(R.id.tv_story);
        mRecyclerViewStory = (RecyclerView) findViewById(R.id.recycler_view_story);
        mReUser = (RelativeLayout) findViewById(R.id.re_user);
        mTvUser = (TextView) findViewById(R.id.tv_user);
        mRecyclerViewUser = (RecyclerView) findViewById(R.id.recycler_view_user);
    }
}
