package com.renren.breadtravel.adapter.trip_search;

import android.content.Context;

import com.renren.breadtravel.R;
import com.renren.breadtravel.adapter.base.BaseViewHolder;
import com.renren.breadtravel.adapter.base.SimpleNormalAdapter;
import com.renren.breadtravel.entity.TripSearchData;

import java.util.List;

/**
 * Created by wuyinlei on 2016/12/21.
 */

public class SearchCityAdapter extends SimpleNormalAdapter<TripSearchData.DataBean.PlacesBean> {
    public SearchCityAdapter(Context context,  List<TripSearchData.DataBean.PlacesBean> datas) {
        super(context, R.layout.search_city_item_layout, datas);
    }

    @Override
    protected void convert(BaseViewHolder viewHoder, TripSearchData.DataBean.PlacesBean item) {
        viewHoder.getTextView(R.id.city_name).setText(item.name);
        viewHoder.getTextView(R.id.city_name_place).setText(item.country.name);
    }
}
