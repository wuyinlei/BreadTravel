package com.renren.breadtravel.adapter;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.makeramen.RoundedImageView;
import com.renren.breadtravel.R;
import com.renren.breadtravel.entity.DetailBean;
import com.renren.breadtravel.widget.recycler.base.BaseViewHolder;
import com.renren.breadtravel.widget.recycler.base.SimpleAdapter;

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
    }
}
