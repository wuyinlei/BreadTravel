package com.renren.breadtravel.widget.banner;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.makeramen.RoundedImageView;
import com.renren.breadtravel.R;
import com.renren.breadtravel.base.BaseLeftFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class BannerFragment extends Fragment {

    private String imgRes;

    public BannerFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return initView(inflater, container, savedInstanceState);
    }

    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_banner, container, false);
        RoundedImageView iv_banner = (RoundedImageView) view.findViewById(R.id.photo);
        //iv_banner.setImageResource(imgRes);
        Glide.with(getActivity())
                .load(imgRes)
                .asBitmap()
                .into(iv_banner);
        iv_banner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mOnClickListener !=null){
                    mOnClickListener.onClick(view);
                }
            }
        });
        return view;
    }

    public void setImgRes(String imgRes) {
        this.imgRes = imgRes;
    }

    private OnClickListener mOnClickListener;

    public interface OnClickListener {
        void  onClick(View v);
    }

    public void setOnClickListener(OnClickListener onClickListener){
        this.mOnClickListener = onClickListener;
    }

}
