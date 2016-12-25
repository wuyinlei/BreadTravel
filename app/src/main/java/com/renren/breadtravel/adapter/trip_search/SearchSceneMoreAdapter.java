package com.renren.breadtravel.adapter.trip_search;

import android.content.Context;
import android.util.Log;

import com.bumptech.glide.Glide;
import com.renren.breadtravel.R;
import com.renren.breadtravel.entity.SearchScene;
import com.renren.breadtravel.widget.recycler.base.BaseViewHolder;
import com.renren.breadtravel.widget.recycler.base.SimpleAdapter;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by wuyinlei on 2016/12/25.
 */

public class SearchSceneMoreAdapter extends SimpleAdapter<SearchScene.DataBean.TripsBean> {
    public SearchSceneMoreAdapter(Context context, List<SearchScene.DataBean.TripsBean> datas) {
        super(context, R.layout.search_trip_item_layout, datas);
    }

    @Override
    protected void convert(BaseViewHolder viewHoder, SearchScene.DataBean.TripsBean item) {
        Glide.with(mContext)
                .load(item.cover_image_default)
                .asBitmap().into(viewHoder.getImageView(R.id.photo));
        viewHoder.getTextView(R.id.tv_title).setText(item.name);
        String date = item.date_added;
        //long l = Long.parseLong(date);
        String realDate = date.substring(0, 10);

        SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");
        Long data = Long.parseLong(realDate) * 1000;
        String format1 = format.format(data);
        viewHoder.getTextView(R.id.tv_time).setText(format1.toString());
        viewHoder.getTextView(R.id.tv_zuji).setText(item.waypoints + "");
        viewHoder.getTextView(R.id.tv_view_count).setText(item.view_count);
        viewHoder.getTextView(R.id.tv_liked_count).setText(item.liked_count + "");
        viewHoder.getTextView(R.id.tv_comment_count).setText(item.total_comments_count + "");
    }
}
