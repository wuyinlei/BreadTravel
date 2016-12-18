package com.renren.breadtravel.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.renren.breadtravel.R;
import com.renren.breadtravel.constant.Constants;
import com.renren.breadtravel.entity.BreadData.DataBean.TopicListBean;
import com.renren.breadtravel.ui.BannerDetailActivity;
import com.renren.breadtravel.widget.recycler.base.BaseViewHolder;
import com.renren.breadtravel.widget.recycler.base.SimpleAdapter;

import java.util.List;

/**
 * Created by wuyinlei on 2016/12/17.
 */

public class BreadHotCitySceneAdapter extends SimpleAdapter<TopicListBean> {
    public BreadHotCitySceneAdapter(Context context,  List<TopicListBean> datas) {
        super(context, R.layout.bread_fragment_item_first_layout, datas);
    }

    @Override
    protected void convert(BaseViewHolder viewHoder, TopicListBean item) {
        Glide.with(mContext)
                .load(item.getCover_image_url())
                .asBitmap()
                .into(viewHoder.getImageView(R.id.img_bg));
        viewHoder.getImageView(R.id.img_bg).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, BannerDetailActivity.class);
                intent.putExtra(Constants.WEB_VIEW_URL, item.getUrl());
                mContext.startActivity(intent);
            }
        });
        viewHoder.getTextView(R.id.tv_title).setText(item.getTitle());
        viewHoder.getTextView(R.id.tv_name).setText(item.getSub_title());
        RecyclerView recyclerView = (RecyclerView) viewHoder.getView(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        BreadHotRecyclerViewAdapter adapter = new BreadHotRecyclerViewAdapter(mContext,  item.getProducts());
        recyclerView.setAdapter(adapter);
    }

    public interface OnBannerItemClick{
        void onItemClickListener(View view,TopicListBean listBean);
    }

    private OnBannerItemClick mOnBannerItemClick;

    public void setOnBannerItemClick(OnBannerItemClick onBannerItemClick) {
        mOnBannerItemClick = onBannerItemClick;
    }

    private interface OnItemClick{
        void onItemClickListener(View v, TopicListBean.ProductsBean item);
    }

    private OnItemClick mOnItemClick;

    public void setOnItemClick(OnItemClick onItemClick) {
        mOnItemClick = onItemClick;
    }

    public class BreadHotRecyclerViewAdapter extends SimpleAdapter<TopicListBean.ProductsBean> {
        public BreadHotRecyclerViewAdapter(Context context, List<TopicListBean.ProductsBean> datas) {
            super(context, R.layout.bread_fragment_item_second_layout, datas);
        }

        @Override
        protected void convert(BaseViewHolder viewHoder, TopicListBean.ProductsBean item) {
            if (!item.isLookMore) {
                Glide.with(mContext)
                        .load(item.getCover_img())
                        .asBitmap()
                        .into(viewHoder.getImageView(R.id.iv_image));
                viewHoder.getTextView(R.id.tv_title).setText(item.getText());
                viewHoder.getTextView(R.id.price_now).setText(item.getPrice());
                TextView textView = viewHoder.getTextView(R.id.price_origin);
                textView.setText(item.getMarket_price());
                textView.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG);
//                Intent intent = new Intent(mContext, BannerDetailActivity.class);
//                intent.putExtra(Constants.WEB_VIEW_URL, item.getUrl());
//                mContext.startActivity(intent);
             RelativeLayout reItem = (RelativeLayout) viewHoder.getView(R.id.re_item);
                reItem.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(mContext, BannerDetailActivity.class);
               intent.putExtra(Constants.WEB_VIEW_URL, item.getUrl());
                mContext.startActivity(intent);
                    }
                });
            } else {
                viewHoder.getView(R.id.re_item).setVisibility(View.GONE);
                RelativeLayout reLookMore = (RelativeLayout) viewHoder.getView(R.id.re_look_more);
                reLookMore.setVisibility(View.VISIBLE);
                String url = item.getUrl();
                if (!TextUtils.isEmpty(url)) {

                    reLookMore.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
//                            if (mOnItemClick !=null){
//                                mOnItemClick.onItemClickListener(view,item);
//                            }
                            Intent intent = new Intent(mContext, BannerDetailActivity.class);
                            intent.putExtra(Constants.WEB_VIEW_URL, url);
                            mContext.startActivity(intent);
                        }
                    });
                }
            }
        }
    }
}
