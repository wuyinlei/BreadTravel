package com.renren.breadtravel.fragment;


import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.renren.breadtravel.R;
import com.renren.breadtravel.adapter.DetailAdapter;
import com.renren.breadtravel.base.BaseLeftFragment;
import com.renren.breadtravel.constant.HttpUrlPath;
import com.renren.breadtravel.entity.BannerData;
import com.renren.breadtravel.entity.DetailBean;
import com.renren.breadtravel.entity.HotInnerCity;
import com.renren.breadtravel.entity.HotOuterCity;
import com.renren.breadtravel.widget.banner.BannerPagerAdapter;
import com.renren.breadtravel.widget.banner.MyPagerListener;
import com.renren.breadtravel.widget.banner.ViewPagerIndicator;
import com.renren.breadtravel.widget.recycler.adapter.LRecyclerViewAdapter;
import com.renren.breadtravel.widget.recycler.view.LRecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

import static android.media.CamcorderProfile.get;
import static com.renren.breadtravel.R.id.recycler_view;

/**
 * A simple {@link Fragment} subclass.
 */
public class HotTripFragment extends BaseLeftFragment {


    private LRecyclerView mLRecyclerView;

    private ViewPagerIndicator mIndicator;
    private ViewPager mViewPager;
    private List<String> imgUrls = new ArrayList<>();
    private BannerPagerAdapter mBannerPagerAdapter;
    private DetailAdapter mDetailAdapter;
    private LRecyclerViewAdapter mLRecyclerViewAdapter;


    @Override
    protected void initListener() {

    }


    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hot_trip, container, false);
        mLRecyclerView = (LRecyclerView) view.findViewById(R.id.recycler_view);
        mDetailAdapter = new DetailAdapter(getContext(), mDetailBeanDatas);
        mLRecyclerViewAdapter = new LRecyclerViewAdapter(mDetailAdapter);
        mLRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        //设置图片(下拉刷新的时候出现的箭头)
        mLRecyclerView.setArrowImageView(R.drawable.ic_pulltorefresh_arrow);
        mLRecyclerView.setAdapter(mLRecyclerViewAdapter);
        return view;
    }

    @Override
    public void initData() {
        super.initData();

        OkGo.get(HttpUrlPath.HOME_POPULAR_TRAVEL)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        parseJson(s);
                    }
                });

        // initHeaderView(imgUrls);
    }

    //国内热门城市
    List<HotInnerCity> mHotInnerCity = new ArrayList<>();
    //国外热门城市
    List<HotOuterCity> mHotOuterCity = new ArrayList<>();
    //轮播数据
    List<BannerData> mBannerDatas = new ArrayList<>();
    //列表数据
    List<DetailBean> mDetailBeanDatas = new ArrayList<>();

    /**
     * 解析数据
     *
     * @param s result
     */
    private void parseJson(String s) {

        mDetailBeanDatas.clear();
        try {
            JSONObject jsonObject = new JSONObject(s);
            if (jsonObject.getString("status").equals("0")) {
                JSONObject dataResults = jsonObject.getJSONObject("data");  //data
                JSONArray mSearchDataArray = dataResults.getJSONArray("search_data");

                parseOuterCityData(mSearchDataArray);

                parseInnerCityData(mSearchDataArray);


                parseDetailData(dataResults);

                mDetailAdapter.setDatas(mDetailBeanDatas);

                Log.d("HotTripFragment", "mBannerDatas.size():" + mBannerDatas.size());
                for (BannerData bannerData : mBannerDatas) {
                    imgUrls.add(bannerData.getImage_url());
                }

               View headView =  initHeaderView(imgUrls);

                mLRecyclerViewAdapter.addHeaderView(headView);
                Log.d("HotTripFragment", "mDetailBeanDatas.size():" + mDetailBeanDatas.size());
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     * 解析热门外国城市
     * @param mSearchDataArray  mSearchDataArray
     * @throws JSONException
     */
    private void parseOuterCityData(JSONArray mSearchDataArray) throws JSONException {
        JSONObject objectOuter = (JSONObject) mSearchDataArray.get(0);
        JSONArray mElementSearchDataOuterArray = objectOuter.getJSONArray("elements");
        int outerLength = mElementSearchDataOuterArray.length();
        for (int i = 0; i < outerLength; i++) {
            JSONObject outerCityResult = (JSONObject) mElementSearchDataOuterArray.get(i);
            HotOuterCity outerCity = new HotOuterCity();
            //   Type type = new TypeToken<HotOuterCity>(){}.getType();
            //   outerCity = new Gson().fromJson(outerCityResult.toString(),type);
            outerCity.setRating(outerCityResult.getInt("rating"));
            outerCity.setName(outerCityResult.getString("name"));
            outerCity.setUrl(outerCityResult.getString("url"));
            outerCity.setWish_to_go_count(outerCityResult.getInt("wish_to_go_count"));
            outerCity.setName_orig(outerCityResult.getString("name_orig"));
            outerCity.setVisited_count(outerCityResult.getInt("visited_count"));
            outerCity.setComments_count(outerCityResult.getInt("comments_count"));
            outerCity.setHas_experience(outerCityResult.getBoolean("has_experience"));
            outerCity.setRating_users(outerCityResult.getInt("rating_users"));
            //outerCity.setName_zh(outerCityResult.getString("name_zh"));
            //outerCity.setName_en(outerCityResult.getString("name_en"));
            outerCity.setType(outerCityResult.getInt("type"));
            outerCity.setId(outerCityResult.getString("id"));
            outerCity.setHas_route_maps(outerCityResult.getBoolean("has_route_maps"));
            outerCity.setIcon(outerCityResult.getString("icon"));
            mHotOuterCity.add(outerCity);
        }
    }

    /**
     * 解析国内热门旅游城市信息
     * @param mSearchDataArray  mSearchDataArray
     * @throws JSONException
     */
    private void parseInnerCityData(JSONArray mSearchDataArray) throws JSONException {
        JSONObject objectInner = (JSONObject) mSearchDataArray.get(1);
        JSONArray mElementSearchDataInnerArray = objectInner.getJSONArray("elements");
        int innerLength = mElementSearchDataInnerArray.length();
        for (int i = 0; i < innerLength; i++) {
            JSONObject innerCityResult = (JSONObject) mElementSearchDataInnerArray.get(i);
            //Type type = new TypeToken<HotInnerCity>(){}.getType();

            HotInnerCity innerCity = new HotInnerCity();

            // innerCity = new Gson().fromJson(innerCityResult.toString(),type);
            innerCity.setRating(innerCityResult.getInt("rating"));
            innerCity.setName(innerCityResult.getString("name"));
            innerCity.setUrl(innerCityResult.getString("url"));
            innerCity.setWish_to_go_count(innerCityResult.getInt("wish_to_go_count"));
            innerCity.setName_orig(innerCityResult.getString("name_orig"));
            innerCity.setVisited_count(innerCityResult.getInt("visited_count"));
            innerCity.setComments_count(innerCityResult.getInt("comments_count"));
            innerCity.setHas_experience(innerCityResult.getBoolean("has_experience"));
            innerCity.setRating_users(innerCityResult.getInt("rating_users"));
            // innerCity.setName_zh(innerCityResult.getString("name_zh"));
            // innerCity.setName_en(innerCityResult.getString("name_en"));
            innerCity.setType(innerCityResult.getInt("type"));
            innerCity.setId(innerCityResult.getString("id"));
            innerCity.setHas_route_maps(innerCityResult.getBoolean("has_route_maps"));
            innerCity.setIcon(innerCityResult.getString("icon"));
            mHotInnerCity.add(innerCity);
        }
    }

    /**
     * 解析详情数据
     * @param dataResults dataResults
     * @throws JSONException
     */
    private void parseDetailData(JSONObject dataResults) throws JSONException {
        JSONArray mElementsArray = dataResults.getJSONArray("elements");
        int length = mElementsArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject mElementsObject = (JSONObject) mElementsArray.get(i);
            if (mElementsObject.getString("type").equals("1")) {  //轮播图
                JSONArray jsonArray = mElementsObject.getJSONArray("data");
                JSONArray bannerArrays = (JSONArray) jsonArray.get(0);
                for (int i1 = 0; i1 < bannerArrays.length(); i1++) {
                    BannerData banner = new BannerData();
                    JSONObject bannerObject = (JSONObject) bannerArrays.get(i1);
                    banner.html_url = bannerObject.getString("html_url");
                    banner.image_url = bannerObject.getString("image_url");
                    banner.platform = bannerObject.getString("platform");
                    mBannerDatas.add(banner);
                }

            } else if (mElementsObject.getString("type").equals("11")) {

            } else if (mElementsObject.getString("type").equals("10")) {

            } else if (mElementsObject.getString("type").equals("9")) {

            } else if (mElementsObject.getString("type").equals("4")) {
                JSONArray jsonArray = mElementsObject.getJSONArray("data");
                JSONObject detailObject = (JSONObject) jsonArray.get(0);
                DetailBean bean = new DetailBean();
                // Type type = new TypeToken<DetailBean>(){}.getType();
                //  bean = new Gson().fromJson(detailObject.toString(),type);
                bean.setCover_image(detailObject.getString("cover_image_default"));
                bean.setName(detailObject.getString("name"));
                bean.setFirst_day(detailObject.getString("first_day"));
                bean.setDay_count(detailObject.getInt("day_count"));
                bean.setView_count(detailObject.getInt("view_count"));
                bean.setPopular_place_str(detailObject.getString("popular_place_str"));
                JSONObject userObject = detailObject.getJSONObject("user");
                DetailBean.UserEntity entity = new DetailBean.UserEntity();
                entity.setName(userObject.getString("name"));
                entity.setAvatar_m(userObject.getString("avatar_m"));
                entity.setAvatar_l(userObject.getString("avatar_l"));
                entity.setAvatar_s(userObject.getString("avatar_s"));
                entity.setId(userObject.getString("id"));
                entity.setUser_desc(userObject.getString("user_desc"));
                entity.setPoints(userObject.getInt("points"));
                bean.setUser(entity);
                bean.setShare_url(detailObject.getString("share_url"));
                bean.setId(detailObject.getString("id"));
                mDetailBeanDatas.add(bean);
                //Log.d("HotTripFragment", detailObject.toString());
            }
        }
    }

    private View initHeaderView(List<String> imgUrls) {
        View headerView = LayoutInflater.from(getActivity())
                .inflate(R.layout.hot_fragment_banner_layout, null);
        mViewPager = (ViewPager) headerView.findViewById(R.id.view_pager);
        mIndicator = (ViewPagerIndicator) headerView.findViewById(R.id.indicator);
        mBannerPagerAdapter = new BannerPagerAdapter(getChildFragmentManager(), imgUrls);
        mBannerPagerAdapter.setOnClickListener(new BannerPagerAdapter.OnClickListener() {
            @Override
            public void onClick(View v, int position) {
                Toast.makeText(getContext(),
                        mBannerDatas.get(position).html_url, Toast.LENGTH_SHORT).show();
            }
        });
        mViewPager.setAdapter(mBannerPagerAdapter);
        mViewPager.setOnPageChangeListener(new MyPagerListener(mIndicator, imgUrls.size()));
        autoScorll();
        return headerView;
    }


    private Handler mHandler = new Handler();

    /**
     * 自动滚动
     */
    private void autoScorll() {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                int currentItem = mViewPager.getCurrentItem();
                mViewPager.setCurrentItem(currentItem + 1);
                mHandler.postDelayed(this, 5000);
            }
        }, 5000);
    }

}
