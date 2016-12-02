package com.renren.breadtravel.adapter;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.makeramen.RoundedImageView;
import com.renren.breadtravel.R;
import com.renren.breadtravel.entity.DetailBean;
import com.renren.breadtravel.widget.recycler.base.BaseViewHolder;
import com.renren.breadtravel.widget.recycler.base.SimpleAdapter;
import com.renren.breadtravel.widget.transform.GlideCircleTransform;

import java.util.List;

/**
 * Created by Administrator on 2016/12/2.
 */

public class DetailAdapter extends SimpleAdapter<DetailBean> {
    public DetailAdapter(Context context,  List<DetailBean> datas) {
        super(context, R.layout.hot_fragment_detail_item_layout, datas);
    }

    @Override
    protected void convert(BaseViewHolder viewHoder, DetailBean item) {
        Glide.with(viewHoder.itemView.getContext())
                .load(item.getCover_image()).asBitmap()
        .into((RoundedImageView)viewHoder.getView(R.id.photo));
        viewHoder.getTextView(R.id.tv_time).setText(item.getFirst_day());
        viewHoder.getTextView(R.id.tv_count_day).setText(item.getDay_count()+"");
        viewHoder.getTextView(R.id.tv_count_view).setText(item.getView_count()+"");
        viewHoder.getTextView(R.id.tv_address).setText(item.getPopular_place_str());
        viewHoder.getTextView(R.id.tv_user_name).setText(item.getUser().getName());
        Glide.with(viewHoder.itemView.getContext())
                .load(item.getUser().getAvatar_s())
                .asBitmap().transform(new GlideCircleTransform(viewHoder.itemView.getContext()))
                .into(viewHoder.getImageView(R.id.img_avator));
    }
}
