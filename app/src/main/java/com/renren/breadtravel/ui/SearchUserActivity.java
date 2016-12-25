package com.renren.breadtravel.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.renren.breadtravel.R;
import com.renren.breadtravel.adapter.trip_search.SearchSceneMoreAdapter;
import com.renren.breadtravel.adapter.trip_search.SearchUserMoreAdapter;
import com.renren.breadtravel.base.BaseSwipeActivity;
import com.renren.breadtravel.constant.HttpUrlPath;
import com.renren.breadtravel.entity.SearchUser;
import com.renren.breadtravel.entity.SearchUser.DataBean.UsersBean;
import com.renren.breadtravel.widget.recycler.adapter.LRecyclerViewAdapter;
import com.renren.breadtravel.widget.recycler.view.LRecyclerView;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

/**
 * 相关面友更多界面
 */
public class SearchUserActivity extends BaseSwipeActivity {

    private ImageView mIvBack;
    private LRecyclerView mLRecyclerView;

    private List<UsersBean> mUsersBeen = new ArrayList<>();
    private SearchUserMoreAdapter mUserMoreAdapter;
    private LRecyclerViewAdapter mRecyclerViewAdapter;
    private String mSearchKey;


    @Override
    protected int getResultId() {
        return R.layout.activity_search_user;
    }

    @Override
    protected void initListener() {
        mIvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SearchUserActivity.this.finish();
            }
        });
    }


    @Override
    public void initData() {
        super.initData();
        if (!TextUtils.isEmpty(mSearchKey))
            OkGo.get(HttpUrlPath.getSearchTripResultType(mSearchKey, "user"))
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(String s, Call call, Response response) {
                            SearchUser user = new Gson().fromJson(s, new TypeToken<SearchUser>() {
                            }.getType());
                            if (user != null) {
                                mUsersBeen = user.data.users;
                                if (mUsersBeen.size() > 0) {
                                    mUserMoreAdapter.setDatas(mUsersBeen);
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
        mUserMoreAdapter = new SearchUserMoreAdapter(this, mUsersBeen);
        mRecyclerViewAdapter = new LRecyclerViewAdapter(mUserMoreAdapter);
        mLRecyclerView.setAdapter(mRecyclerViewAdapter);
        mLRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        //设置图片(下拉刷新的时候出现的箭头)
        mLRecyclerView.setArrowImageView(R.drawable.ic_pulltorefresh_arrow);
    }

}
