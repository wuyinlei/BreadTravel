package com.renren.breadtravel.ui;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.renren.breadtravel.R;
import com.renren.breadtravel.adapter.trip_search.SearchCityAdapter;
import com.renren.breadtravel.adapter.trip_search.SearchTripAdapter;
import com.renren.breadtravel.adapter.trip_search.SearchUserAdapter;
import com.renren.breadtravel.base.BaseSwipeActivity;
import com.renren.breadtravel.constant.HttpUrlPath;
import com.renren.breadtravel.entity.TripSearchData;
import com.renren.breadtravel.entity.TripSearchData.DataBean;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

public class SearchKeyActivity extends BaseSwipeActivity {

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

    private String search_key;
    private String url;
    private List<DataBean.TripsBean> mTripsBeen = new ArrayList<>();
    private List<DataBean.PlacesBean> mPlacesBeen = new ArrayList<>();
    private List<DataBean.UsersBean> mUsersBeen = new ArrayList<>();
    private SearchCityAdapter mSearchCityAdapter;
    private SearchUserAdapter mSearchUserAdapter;
    private SearchTripAdapter mSearchTripAdapter;

    @Override
    protected int getResultId() {
        return R.layout.activity_serach_result_item;
    }

    @Override
    protected void initListener() {

    }

    @Override
    public void initView() {

        search_key = getIntent().getStringExtra("key");


        mActivitySerachResultItem = (RelativeLayout) findViewById(R.id.activity_serach_result_item);
        mTitle = (RelativeLayout) findViewById(R.id.title);
        mImgBack = (ImageView) findViewById(R.id.img_back);
        mEditText = (EditText) findViewById(R.id.edit_text);
        mReDestination = (RelativeLayout) findViewById(R.id.re_destination);
        mTvDestination = (TextView) findViewById(R.id.tv_destination);
        LinearLayoutManager layout1 = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        mRecyclerViewDestination = (RecyclerView) findViewById(R.id.recycler_view_destination);
        mRecyclerViewDestination.setLayoutManager(layout1);
        mRecyclerViewDestination.setItemAnimator(new DefaultItemAnimator());
        mSearchCityAdapter = new SearchCityAdapter(this, mPlacesBeen);
        mRecyclerViewDestination.setAdapter(mSearchCityAdapter);

        mReTripStory = (RelativeLayout) findViewById(R.id.re_trip_story);
        mTvStory = (TextView) findViewById(R.id.tv_story);
        mRecyclerViewStory = (RecyclerView) findViewById(R.id.recycler_view_story);

        LinearLayoutManager layout2 = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        mRecyclerViewStory.setLayoutManager(layout2);
        mRecyclerViewStory.setItemAnimator(new DefaultItemAnimator());
        mSearchTripAdapter = new SearchTripAdapter(this, mTripsBeen);
        mRecyclerViewStory.setAdapter(mSearchTripAdapter);

        mReUser = (RelativeLayout) findViewById(R.id.re_user);
        mTvUser = (TextView) findViewById(R.id.tv_user);
        mRecyclerViewUser = (RecyclerView) findViewById(R.id.recycler_view_user);

        LinearLayoutManager layout3 = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        mRecyclerViewUser.setLayoutManager(layout3);
        mRecyclerViewUser.setItemAnimator(new DefaultItemAnimator());
        mSearchUserAdapter = new SearchUserAdapter(this, mUsersBeen);
        mRecyclerViewUser.setAdapter(mSearchUserAdapter);

    }

    @Override
    public void initData() {
        super.initData();
        url = HttpUrlPath.getSearchTripResult(search_key);
        if (!TextUtils.isEmpty(url)) {
            OkGo.get(url)
                    .execute(new StringCallback(){
                        @Override
                        public void onSuccess(String s, Call call, Response response) {
                            TripSearchData data = new
                                    Gson().fromJson(s,
                                    new TypeToken<TripSearchData>(){}.getType());
                            if (data != null){
                                mPlacesBeen = data.data.places;
                                if (mPlacesBeen.size() > 0){
                                    mReDestination.setVisibility(View.VISIBLE);
                                    mSearchCityAdapter.setDatas(mPlacesBeen);
                                }
                                mUsersBeen = data.data.users;
                                if (mUsersBeen.size() > 0){
                                    mReUser.setVisibility(View.VISIBLE);
                                    mSearchUserAdapter.setDatas(mUsersBeen);
                                }
                                mTripsBeen = data.data.trips;
                                if (mTripsBeen.size() > 0){
                                    mSearchTripAdapter.setDatas(mTripsBeen);
                                    mReTripStory.setVisibility(View.VISIBLE);
                                }
                            }
                        }
                    });
        }
    }
}
