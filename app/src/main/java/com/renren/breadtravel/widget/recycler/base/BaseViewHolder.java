package com.renren.breadtravel.widget.recycler.base;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/10/21.
 */

public class BaseViewHolder extends RecyclerView.ViewHolder {


    //稀疏数组,提升性能，减少内存的消耗
    private SparseArray<View> views;


    public BaseViewHolder(View itemView) {
        super(itemView);
        this.views = new SparseArray<>();
    }


    /**
     * 获取到TextView
     *
     * @param viewId viewId
     * @return TextView
     */
    public TextView getTextView(int viewId) {
        return retrieveView(viewId);
    }

    /**
     * CheckBox
     *
     * @param viewId viewId
     * @return CheckBox
     */
    public CheckBox getCheckBox(int viewId) {
        return retrieveView(viewId);
    }

    /**
     * Button
     *
     * @param viewId viewId
     * @return Button
     */
    public Button getButton(int viewId) {
        return retrieveView(viewId);
    }

    /**
     * ImageView
     *
     * @param viewId viewId
     * @return ImageView
     */
    public ImageView getImageView(int viewId) {
        return retrieveView(viewId);
    }

    /**
     * 获取到View  其他类型，如果没有写，可以通过此方法来回去之后再强转一下类型即可
     *
     * @param viewId viewId
     * @return View
     */
    public View getView(int viewId) {
        return retrieveView(viewId);
    }

//
//    /**
//     * 获取到TextView
//     *
//     * @param viewId viewId
//     * @return TextView
//     */
//    public RelativeLayout getRelativeLayout(int viewId) {
//        return retrieveView(viewId);
//    }


    /**
     * 类似findViewById
     *
     * @param viewId viewId
     * @param <T>    泛型
     * @return view
     */
    protected <T extends View> T retrieveView(int viewId) {
        View view = views.get(viewId);
        if (view == null) {
            view = itemView.findViewById(viewId);
            views.put(viewId, view);
        }
        return (T) view;
    }

//    @Override
//    public void onClick(View v) {
//        if (mOnItemClickListener != null) {
//            mOnItemClickListener.onItemClick(v,getLayoutPosition());
//        }
//    }
}
