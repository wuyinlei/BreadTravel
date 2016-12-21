package com.renren.breadtravel.adapter.trip_search;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.renren.breadtravel.R;
import com.renren.breadtravel.adapter.base.BaseViewHolder;
import com.renren.breadtravel.adapter.base.SimpleAdapter;
import com.renren.breadtravel.entity.TripSearchData;
import com.renren.breadtravel.widget.transform.GlideCircleTransform;

import java.util.List;

/**
 * Created by wuyinlei on 2016/12/21.
 */

public class SearchUserAdapter extends SimpleAdapter<TripSearchData.DataBean.UsersBean> {
    public SearchUserAdapter(Context context, int layoutResId, List<TripSearchData.DataBean.UsersBean> datas) {
        super(context, R.layout.search_mianyou_item_layout, datas);
    }

    @Override
    protected void convert(BaseViewHolder viewHoder, TripSearchData.DataBean.UsersBean item) {
        Glide.with(context)
                .load(item.avatar_s)
                .asBitmap().transform(new GlideCircleTransform(context))
                .into(viewHoder.getImageView(R.id.img_avator));
        viewHoder.getTextView(R.id.tv_user_name).setText(item.name);
    }
}
