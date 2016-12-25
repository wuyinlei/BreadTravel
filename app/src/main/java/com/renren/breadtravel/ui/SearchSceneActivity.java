package com.renren.breadtravel.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.renren.breadtravel.R;
import com.renren.breadtravel.adapter.trip_search.SearchSceneMoreAdapter;
import com.renren.breadtravel.base.BaseSwipeActivity;
import com.renren.breadtravel.constant.HttpUrlPath;
import com.renren.breadtravel.entity.SearchScene;
import com.renren.breadtravel.entity.SearchScene.DataBean.TripsBean;
import com.renren.breadtravel.widget.recycler.adapter.LRecyclerViewAdapter;
import com.renren.breadtravel.widget.recycler.view.LRecyclerView;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

/**
 * 搜索界面trip更多
 */
public class SearchSceneActivity extends BaseSwipeActivity {

    private ImageView mIvBack;
    private LRecyclerView mLRecyclerView;
    private List<TripsBean> mTripsBeen = new ArrayList<>();
    private SearchSceneMoreAdapter mSceneMoreAdapter;
    private LRecyclerViewAdapter mRecyclerViewAdapter;
    private String mSearchKey;


    @Override
    protected int getResultId() {
        return R.layout.activity_search_scene;
    }

    @Override
    protected void initListener() {
        mIvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SearchSceneActivity.this.finish();
            }
        });
    }

    @Override
    public void initData() {
        super.initData();
        if (!TextUtils.isEmpty(mSearchKey))
            OkGo.get(HttpUrlPath.getSearchTripResultType(mSearchKey, "trip"))
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(String s, Call call, Response response) {
                            SearchScene scene = new Gson().fromJson(s, new TypeToken<SearchScene>() {
                            }.getType());
                            if (scene != null) {
                                mTripsBeen = scene.data.trips;
                                if (mTripsBeen.size() > 0) {
                                    mSceneMoreAdapter.setDatas(mTripsBeen);
                                }
                            }
                        }
                    });

    }

    @Override
    public void initView() {
        mSearchKey = getIntent().getStringExtra("key");
        mIvBack = (ImageView) findViewById(R.id.img_back);
        mLRecyclerView = (LRecyclerView) findViewById(R.id.recycler_view);
        mSceneMoreAdapter = new SearchSceneMoreAdapter(this, mTripsBeen);
        mRecyclerViewAdapter = new LRecyclerViewAdapter(mSceneMoreAdapter);
        mLRecyclerView.setAdapter(mRecyclerViewAdapter);
        mLRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        //设置图片(下拉刷新的时候出现的箭头)
        mLRecyclerView.setArrowImageView(R.drawable.ic_pulltorefresh_arrow);
    }
}
