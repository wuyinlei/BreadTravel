package com.renren.breadtravel.widget.navagation;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.renren.breadtravel.R;

import java.util.List;


/**
 * 在此写用途
 *
 * @version V1.0 <描述当前版本功能>
 * @FileName: NavigationDrawerAdapter.java
 * @author: myName
 * @date: 2016-07-30 16:13
 */

public class NavigationDrawerAdapter extends
        RecyclerView.Adapter<NavigationDrawerAdapter.ViewHolder> {

    private List<NavigationItem> mData;

    private NavigationDrawerCallbacks mNavigationDrawerCallbacks;

    private int mSelectPosition;  //选择

    private int mTouchPosition = -1;  //按下触摸

    public NavigationDrawerAdapter(List<NavigationItem> data) {
        mData = data;
    }

    public NavigationDrawerCallbacks getNavigationDrawerCallbacks() {
        return mNavigationDrawerCallbacks;
    }

    public void setNavigationDrawerCallbacks(NavigationDrawerCallbacks navigationDrawerCallbacks) {
        mNavigationDrawerCallbacks = navigationDrawerCallbacks;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.drawer_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.mTextView.setText(mData.get(position).getText());
        holder.itemView.setOnTouchListener((view, motionEvent) -> {
            switch (motionEvent.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    touchPosition(position);
                    return false;
                case MotionEvent.ACTION_CANCEL:
                    touchPosition(-1);
                    return false;
                case MotionEvent.ACTION_MOVE:
                    return false;
                case MotionEvent.ACTION_UP:
                    touchPosition(-1);
                    return false;
            }
            return true;
        });

        holder.itemView.setOnClickListener(view -> {
            if (mNavigationDrawerCallbacks != null) {
                mNavigationDrawerCallbacks.onNavigationDrawerItemSelected(position);
            }
        });

        if (mSelectPosition == position || mTouchPosition == position) {
            holder.mTextView
                    .setTextColor(holder.itemView.getContext()
                            .getResources().getColor(R.color.color_home_item_bg));
        } else {
            holder.mTextView.setTextColor(holder
            .itemView.getContext().getResources()
            .getColor(R.color.color_drawer_title_bg_normal));
        }
    }


    /**
     * 按下的位置
     * @param position   位置
     */
    private void touchPosition(int position) {
        int lastPosition = mTouchPosition;
        mTouchPosition = position;
        if (lastPosition >= 0) {
            notifyItemChanged(lastPosition);
        }
        if (position > 0) {
            notifyItemChanged(position);
        }
    }

    /**
     * 选择的item
     * @param position   item位置
     */
    public void selectPosition(int position) {
        int lastPosition = mSelectPosition;
        mSelectPosition = position;
        notifyItemChanged(lastPosition);
        notifyItemChanged(position);
    }

    @Override
    public int getItemCount() {
        return mData != null ? mData.size() : 0;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mTextView;

        ViewHolder(View itemView) {
            super(itemView);

            mTextView = (TextView) itemView.findViewById(R.id.item_name);
        }
    }
}
