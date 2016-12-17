package com.renren.breadtravel.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.renren.breadtravel.R;
import com.renren.breadtravel.adapter.BreadHotCitySceneAdapter;
import com.renren.breadtravel.base.BaseFragment;
import com.renren.breadtravel.constant.Constants;
import com.renren.breadtravel.constant.HttpUrlPath;
import com.renren.breadtravel.entity.BreadData;
import com.renren.breadtravel.entity.BreadData.DataBean.TopicListBean;
import com.renren.breadtravel.entity.BreadData.DataBean.TopicListBean.ProductsBean;
import com.renren.breadtravel.utils.PreferencesUtils;
import com.renren.breadtravel.widget.recycler.adapter.LRecyclerViewAdapter;
import com.renren.breadtravel.widget.recycler.view.LRecyclerView;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

import static android.R.attr.fragment;


public class BreadOrderDetailFragment extends BaseFragment {


    /**
     * 用于传递一些数据信息
     *
     * @param cityId   cityId  用于拼接请求网址的
     * @param cityName 城市名字
     * @return BreadOrderDetailFragment对象
     */
    public static BreadOrderDetailFragment newInstance(String cityId, String cityName) {
        // Required empty public constructor
        Bundle bundle = new Bundle();
        bundle.putString(Constants.HOT_CITY_INDEX, cityId);
        bundle.putString(Constants.HOT_CITY_NAME, cityName);
        BreadOrderDetailFragment fragment = new BreadOrderDetailFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    private String mCityId, mCityName;

    private int start = 0;
    private int count = 10;
    private String url;

    private TextView mTvTitle;
    private List<TopicListBean> mTopicListBeen = new ArrayList<>();

    private LRecyclerView mRecyclerView;
    private BreadHotCitySceneAdapter mSceneAdapter;
    private LRecyclerViewAdapter mLRecyclerViewAdapter;
    private List<ProductsBean> mProductsBeen = new ArrayList<>();


    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        initViews(view);
        mCityId = getArguments().getString(Constants.HOT_CITY_INDEX);
        mCityName = getArguments().getString(Constants.HOT_CITY_NAME);
        if (!TextUtils.isEmpty(mCityId)) {
            url = HttpUrlPath.getBreadOrder(start, count, mCityId);
        }
//        mTvTitle = (TextView) view.findViewById(R.id.tv_title);
//        if (!TextUtils.isEmpty(mCityName)) {
//            mTvTitle.setText(mCityName);
//        }
        mRecyclerView = (LRecyclerView) view.findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mSceneAdapter = new BreadHotCitySceneAdapter(getActivity(), mTopicListBeen);
        mLRecyclerViewAdapter = new LRecyclerViewAdapter(mSceneAdapter);
        mRecyclerView.setAdapter(mLRecyclerViewAdapter);

        return view;
    }

    private void initViews(View view) {

    }

    @Override
    protected void initData() {
        OkGo.get(url)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Type type = new TypeToken<BreadData>() {
                        }.getType();
                        BreadData da = new Gson().fromJson(s, type);
                        if (da != null) {
                            mTopicListBeen = da.getData().getTopic_list();
                            if (mTopicListBeen.size() > 0) {
                                for (TopicListBean listBean : mTopicListBeen) {
                                    mProductsBeen = listBean.getProducts();
                                    ProductsBean bean = new ProductsBean();
                                    bean.isLookMore = true;
                                    mProductsBeen.add(bean);
                                }
                            }

                            mSceneAdapter.setDatas(mTopicListBeen);
                        }
                    }
                });
    }

}
