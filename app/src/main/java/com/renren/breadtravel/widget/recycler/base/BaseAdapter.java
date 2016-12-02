package com.renren.breadtravel.widget.recycler.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class BaseAdapter<T, H extends BaseViewHolder> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    protected Context mContext;

    protected List<T> datas = new ArrayList<>();

    protected int layoutResId;

    public BaseAdapter(Context context, int layoutResId) {
        this(context, layoutResId, null);
    }


    /**
     * construct
     * @param context  上下文
     * @param layoutResId  布局ID
     * @param datas  数据源
     */
    public BaseAdapter(Context context, int layoutResId, List<T> datas) {
        this.datas = datas == null ? new ArrayList<T>() : datas;
        this.mContext = context;
        this.layoutResId = layoutResId;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(layoutResId, parent, false);
        BaseViewHolder vh = new BaseViewHolder(view);
        return vh;
    }



    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof BaseViewHolder) {
            BaseViewHolder viewHolder = (BaseViewHolder) holder;
            T item = getItem(position);
            convert((H) viewHolder, item);
        }
    }



    /**
     * Implement this method and use the helper to adapt the view to the given item.
     *
     * @param viewHoder A fully initialized helper.
     * @param item      The item that needs to be displayed.
     */
    protected abstract void convert(H viewHoder, T item);


    private T getItem(int position) {
        if (position >= datas.size()) return null;
        return datas.get(position);
    }


    @Override
    public int getItemCount() {
        return datas.size();
    }

    public List<T> getDatas() {
        return datas;
    }

    /**
     * 设置数据集
     *
     * @param list 填充的数据
     */
    public void setDatas(List<T> list) {
      //  this.datas.clear();
        this.datas = list;
        notifyDataSetChanged();
    }

    /**
     * 添加所有数据
     *
     * @param list 数据集
     */
    public void addAll(Collection<T> list) {
        int lastIndex = this.datas.size();
        if (this.datas.addAll(list)) {
            notifyItemRangeInserted(lastIndex, list.size());
        }
    }

    public void remove(int position) {
        if (this.datas.size() > 0) {
            datas.remove(position);
            notifyItemRemoved(position);
        }

    }

    public void clear() {
        datas.clear();
        notifyDataSetChanged();
    }

}
