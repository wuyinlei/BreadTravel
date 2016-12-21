package com.renren.breadtravel.adapter.trip_search;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.renren.breadtravel.R;
import com.renren.breadtravel.adapter.base.BaseViewHolder;
import com.renren.breadtravel.adapter.base.SimpleAdapter;
import com.renren.breadtravel.entity.TripSearchData;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by wuyinlei on 2016/12/21.
 */

public class SearchTripAdapter extends SimpleAdapter<TripSearchData.DataBean.TripsBean> {
    public SearchTripAdapter(Context context, int layoutResId, List<TripSearchData.DataBean.TripsBean> datas) {
        super(context, R.layout.search_trip_item_layout, datas);
    }

    @Override
    protected void convert(BaseViewHolder viewHoder, TripSearchData.DataBean.TripsBean item) {
        Glide.with(context)
                .load(item.cover_image_default)
                .asBitmap().into(viewHoder.getImageView(R.id.img_bg));
        viewHoder.getTextView(R.id.tv_title).setText(item.name);
        SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");
        String format1 = format.format(item.date_added);
        viewHoder.getTextView(R.id.tv_time).setText(format1);
        viewHoder.getTextView(R.id.tv_zuji).setText(item.waypoints);
        viewHoder.getTextView(R.id.tv_view_count).setText(item.view_count);
        viewHoder.getTextView(R.id.tv_liked_count).setText(item.liked_count);
        viewHoder.getTextView(R.id.tv_comment_count).setText(item.total_comments_count);
    }
}
