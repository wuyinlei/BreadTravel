package com.renren.breadtravel.widget.recycler.adapter;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.ViewGroup;

import com.renren.breadtravel.widget.recycler.header.ArrowRefreshHeader;
import com.renren.breadtravel.widget.recycler.interfaces.OnItemClickListener;
import com.renren.breadtravel.widget.recycler.interfaces.OnItemLongClickListener;

import java.util.ArrayList;
import java.util.List;


/**
 * RecyclerView.Adapter with Header and Footer
 */
public class LRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_REFRESH_HEADER = 10000;
    private static final int TYPE_NORMAL = 0;
    private static final int TYPE_FOOTER_VIEW = 10001;
    private static final int HEADER_INIT_INDEX = 10002;
    private static List<Integer> mHeaderTypes = new ArrayList<>();

    private ArrowRefreshHeader mRefreshHeader;

    private OnItemClickListener mOnItemClickListener;
    private OnItemLongClickListener mOnItemLongClickListener;

    /**
     * RecyclerView使用的，真正的Adapter
     */
    private RecyclerView.Adapter mInnerAdapter;

    private ArrayList<View> mHeaderViews = new ArrayList<>();
    private ArrayList<View> mFooterViews = new ArrayList<>();


    /**
     * 构造
     *
     * @param innerAdapter 用户需要实现的adapter
     */
    public LRecyclerViewAdapter(RecyclerView.Adapter innerAdapter) {
        this.mInnerAdapter = innerAdapter;
    }

    /**
     * 设置刷新显示的HeadView
     *
     * @param refreshHeader headView
     */
    public void setRefreshHeader(ArrowRefreshHeader refreshHeader) {
        mRefreshHeader = refreshHeader;
    }

    public RecyclerView.Adapter getInnerAdapter() {
        return mInnerAdapter;
    }

    /**
     * 添加HeadView  可以多个添加
     *
     * @param view 需要添加的view
     */
    public void addHeaderView(View view) {

        if (view == null) {
            throw new RuntimeException("header is null");
        }

        mHeaderTypes.add(HEADER_INIT_INDEX + mHeaderViews.size());
        mHeaderViews.add(view);
    }

    /**
     * 添加FooterView
     *
     * @param view 需要添加的view
     */
    public void addFooterView(View view) {

        if (view == null) {
            throw new RuntimeException("footer is null");
        }
        if (getFooterViewsCount() > 0) {
            removeFooterView(getFooterView());
        }
        mFooterViews.add(view);
        //this.notifyDataSetChanged();
    }

    /**
     * 根据header的ViewType判断是哪个header
     *
     * @param itemType 显示的item类型
     * @return 类型
     */
    private View getHeaderViewByType(int itemType) {
        if (!isHeaderType(itemType)) {
            return null;
        }
        return mHeaderViews.get(itemType - HEADER_INIT_INDEX);
    }

    /**
     * 判断一个type是否为HeaderType
     *
     * @param itemViewType 头view
     * @return true / false
     */
    private boolean isHeaderType(int itemViewType) {
        return mHeaderViews.size() > 0 && mHeaderTypes.contains(itemViewType);
    }

    /**
     * 返回第一个FootView
     *
     * @return FooterView
     */
    public View getFooterView() {
        return getFooterViewsCount() > 0 ? mFooterViews.get(0) : null;
    }

    /**
     * 返回第一个HeaderView
     *
     * @return HeaderView
     */
    public View getHeaderView() {
        return getHeaderViewsCount() > 0 ? mHeaderViews.get(0) : null;
    }

    /**
     * 返回HeaderView的集合
     *
     * @return views
     */
    public ArrayList<View> getHeaderViews() {
        return mHeaderViews;
    }

    /**
     * 移除HeaderView
     *
     * @param view 需要移除的view
     */
    public void removeHeaderView(View view) {
        mHeaderViews.remove(view);
        this.notifyDataSetChanged();
    }

    /**
     * 移除FooterView
     *
     * @param view 需要移除的FooterView
     */
    public void removeFooterView(View view) {
        mFooterViews.remove(view);
        this.notifyDataSetChanged();
    }

    /**
     * 获取HeaderView的个数
     *
     * @return count
     */
    public int getHeaderViewsCount() {
        return mHeaderViews.size();
    }

    /**
     * 获取FooterView的个数
     *
     * @return count
     */
    public int getFooterViewsCount() {
        return mFooterViews.size();
    }

    /**
     * 判断该位置是否是HeaderView
     *
     * @param position position
     * @return true / false
     */
    public boolean isHeader(int position) {
        return position >= 1 && position < mHeaderViews.size() + 1;
    }

    /**
     * 是否是刷新的HeaderView
     *
     * @param position position
     * @return true / false
     */
    public boolean isRefreshHeader(int position) {
        return position == 0;
    }


    /**
     * 判断该位置是否是FooterView
     *
     * @param position position
     * @return true / false
     */
    public boolean isFooter(int position) {
        int lastPosition = getItemCount() - getFooterViewsCount();
        return getFooterViewsCount() > 0 && position >= lastPosition;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == TYPE_REFRESH_HEADER) {  //刷新Header
            return new ViewHolder(mRefreshHeader);
        } else if (isHeaderType(viewType)) {  //HeaderView
            return new ViewHolder(getHeaderViewByType(viewType));
        } else if (viewType == TYPE_FOOTER_VIEW) { //FooterView
            return new ViewHolder(mFooterViews.get(0));
        }
        return mInnerAdapter.onCreateViewHolder(parent, viewType);  //数据view
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        if (isHeader(position) || isRefreshHeader(position)) {
            return;
        }
        final int adjPosition = position - (getHeaderViewsCount() + 1);
        int adapterCount;
        if (mInnerAdapter != null) {
            adapterCount = mInnerAdapter.getItemCount();
            if (adjPosition < adapterCount) {
                mInnerAdapter.onBindViewHolder(holder, adjPosition);

                if (mOnItemClickListener != null) {
                    holder.itemView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            mOnItemClickListener.onItemClick(holder.itemView, adjPosition);
                        }
                    });

                }

                if (mOnItemLongClickListener != null) {
                    holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                        @Override
                        public boolean onLongClick(View v) {
                            mOnItemLongClickListener.onItemLongClick(holder.itemView, adjPosition);
                            return true;
                        }
                    });
                }

            }
        }
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position, List<Object> payloads) {
        if (payloads.isEmpty()) {
            onBindViewHolder(holder, position);
        } else {

            if (isHeader(position) || isRefreshHeader(position)) {
                return;
            }
            final int adjPosition = position - (getHeaderViewsCount() + 1);
            int adapterCount;
            if (mInnerAdapter != null) {
                adapterCount = mInnerAdapter.getItemCount();
                if (adjPosition < adapterCount) {
                    mInnerAdapter.onBindViewHolder(holder, adjPosition, payloads);
                }
            }

        }
    }

    @Override
    public int getItemCount() {
        if (mInnerAdapter != null) {  //如果adapter不为空  那么返回来的count就是
            //count = HeaderViews + FooterViews + adapter.getItemCount() + 1 (这个1代表着下拉刷新的头布局)
            return getHeaderViewsCount() + getFooterViewsCount() + mInnerAdapter.getItemCount() + 1;
        } else {
            //如果adapter为空  那么返回来的count就是
            //count = HeaderViews + FooterViews + (这个1代表着下拉刷新的头布局)
            return getHeaderViewsCount() + getFooterViewsCount() + 1;
        }
    }

    @Override
    public int getItemViewType(int position) {
        int adjPosition = position - (getHeaderViewsCount() + 1);
        if (isRefreshHeader(position)) {  //当前的position是否是刷新头布局
            return TYPE_REFRESH_HEADER;
        }
        if (isHeader(position)) { //当前的position是否是HeaderView
            position = position - 1;
            return mHeaderTypes.get(position);
        }
        if (isFooter(position)) {  //当前的position是否是FooterView
            return TYPE_FOOTER_VIEW;
        }
        int adapterCount;  //adapter的数量
        if (mInnerAdapter != null) {
            adapterCount = mInnerAdapter.getItemCount(); //获取adapter的数量
            if (adjPosition < adapterCount) {
                return mInnerAdapter.getItemViewType(adjPosition);
            }
        }
        return TYPE_NORMAL;
    }

    @Override
    public long getItemId(int position) {
        if (mInnerAdapter != null && position >= getHeaderViewsCount()) {
            int adjPosition = position - getHeaderViewsCount();
            int adapterCount = mInnerAdapter.getItemCount();
            if (adjPosition < adapterCount) {
                return mInnerAdapter.getItemId(adjPosition);
            }
        }
        return -1;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        RecyclerView.LayoutManager manager = recyclerView.getLayoutManager();
        if (manager instanceof GridLayoutManager) {
            final GridLayoutManager gridManager = ((GridLayoutManager) manager);
            gridManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    return (isHeader(position) || isFooter(position) || isRefreshHeader(position))
                            ? gridManager.getSpanCount() : 1;
                }
            });
        }
        mInnerAdapter.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        mInnerAdapter.onDetachedFromRecyclerView(recyclerView);
    }

    @Override
    public void onViewAttachedToWindow(RecyclerView.ViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        ViewGroup.LayoutParams lp = holder.itemView.getLayoutParams();
        if (lp != null && lp instanceof StaggeredGridLayoutManager.LayoutParams) {
            if (isHeader(holder.getLayoutPosition()) || isRefreshHeader(holder.getLayoutPosition()) || isFooter(holder.getLayoutPosition())) {
                StaggeredGridLayoutManager.LayoutParams p = (StaggeredGridLayoutManager.LayoutParams) lp;
                p.setFullSpan(true);
            }
        }

        mInnerAdapter.onViewAttachedToWindow(holder);
    }

    @Override
    public void onViewDetachedFromWindow(RecyclerView.ViewHolder holder) {
        mInnerAdapter.onViewDetachedFromWindow(holder);
    }

    @Override
    public void onViewRecycled(RecyclerView.ViewHolder holder) {
        mInnerAdapter.onViewRecycled(holder);
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }

    /**
     * @param isCallback whether position is from callback interface
     * @param position   position
     * @return 位置
     */
    public int getAdapterPosition(boolean isCallback, int position) {
        if (isCallback) {
            int adjPosition = position - (getHeaderViewsCount() + 1);
            int adapterCount = mInnerAdapter.getItemCount();
            if (adjPosition < adapterCount) {
                return adjPosition;
            }
        } else {
            return (position + getHeaderViewsCount()) + 1;
        }

        return -1;
    }

    /**
     * 设置点击事件
     *
     * @param itemClickListener 监听
     */
    public void setOnItemClickListener(OnItemClickListener itemClickListener) {
        this.mOnItemClickListener = itemClickListener;
    }

    /**
     * 长按事件
     *
     * @param itemLongClickListener 长按监听
     */
    public void setOnItemLongClickListener(OnItemLongClickListener itemLongClickListener) {
        this.mOnItemLongClickListener = itemLongClickListener;
    }

}
