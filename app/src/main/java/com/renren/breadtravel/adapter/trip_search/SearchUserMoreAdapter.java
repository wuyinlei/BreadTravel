package com.renren.breadtravel.adapter.trip_search;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.renren.breadtravel.R;
import com.renren.breadtravel.entity.SearchUser.DataBean.UsersBean;
import com.renren.breadtravel.widget.recycler.base.BaseViewHolder;
import com.renren.breadtravel.widget.recycler.base.SimpleAdapter;
import com.renren.breadtravel.widget.transform.GlideCircleTransform;

import java.util.List;

/**
 * Created by wuyinlei on 2016/12/25.
 */

public class SearchUserMoreAdapter extends SimpleAdapter<UsersBean> {
    public SearchUserMoreAdapter(Context context, List<UsersBean> datas) {
        super(context, R.layout.search_mianyou_item_layout, datas);
    }

    @Override
    protected void convert(BaseViewHolder viewHoder, UsersBean item) {
        Glide.with(mContext)
                .load(item.avatar_m)
                .asBitmap().transform(new GlideCircleTransform(mContext))
                .into(viewHoder.getImageView(R.id.img_avator));
        viewHoder.getTextView(R.id.tv_user_name).setText(item.name);
    }
}
