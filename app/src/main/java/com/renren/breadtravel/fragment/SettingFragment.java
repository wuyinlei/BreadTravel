package com.renren.breadtravel.fragment;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.renren.breadtravel.R;
import com.renren.breadtravel.base.BaseLeftFragment;
import com.renren.breadtravel.ui.WebActivity;
import com.renren.breadtravel.utils.CommentUtils;
import com.renren.breadtravel.utils.DataCleanManager;

/**
 * A simple {@link Fragment} subclass.
 */
public class SettingFragment extends BaseLeftFragment implements View.OnClickListener {

    private LinearLayout mGestureMge;//手势管理
    private TextView mGesturestate; //手势提示


    private LinearLayout mClearCache;//缓存
    private TextView mCurrentCacheSize;//当前缓存大小

    private LinearLayout mSettingOpinion;//意见反馈

    private LinearLayout mSettingShare;//分享好友

    private TextView mCurrentVersionCode; //当前版本号
    private LinearLayout mVersionCheck;

    private LinearLayout mSettingByme; //关于作者
    private String mTotalCacheSize;


    @Override
    protected void initListener() {
        mGestureMge.setOnClickListener(this);
        mClearCache.setOnClickListener(this);
        mSettingOpinion.setOnClickListener(this);
        mSettingShare.setOnClickListener(this);
        mVersionCheck.setOnClickListener(this);
        mSettingByme.setOnClickListener(this);
    }

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View  view = inflater.inflate(R.layout.fragment_setting, container, false);
        initViews(view);
        return view;
    }

    @Override
    public void initData() {
        super.initData();
        mCurrentVersionCode.setText(CommentUtils.getVersionName(getActivity()));
        mTotalCacheSize = DataCleanManager.getTotalCacheSize(getActivity());
        if (mTotalCacheSize != null) {
            mCurrentCacheSize.setText(mTotalCacheSize);
        }
    }

    private void initViews(View view) {
        mGestureMge = (LinearLayout) view.findViewById(R.id.gesture_mge);
        mGesturestate = (TextView) view.findViewById(R.id.gesture_state);
        mClearCache = (LinearLayout) view.findViewById(R.id.clear_cache);
        mCurrentCacheSize = (TextView) view.findViewById(R.id.current_cache);
        mSettingOpinion = (LinearLayout) view.findViewById(R.id.setting_opinion);
        mSettingShare = (LinearLayout) view.findViewById(R.id.setting_share);
        mVersionCheck = (LinearLayout) view.findViewById(R.id.version_check);
        mCurrentVersionCode = (TextView) view.findViewById(R.id.version_name);
        mSettingByme = (LinearLayout) view.findViewById(R.id.setting_byme);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.gesture_mge: //手势管理

                break;
            case R.id.clear_cache: //清理缓存
                DataCleanManager.clearAllCache(getActivity());  //清理app缓存
                new MaterialDialog.Builder(getActivity())
                        .title(getResources().getString(R.string.clear_tip))
                        .content(getResources().getString(R.string.clear_success))
                        .positiveText(getResources().getString(R.string.ok))
                        .onPositive((dialog, which) -> mCurrentCacheSize.setText("0 KB")).show();

                break;
            case R.id.setting_opinion: //意见反馈

                break;
            case R.id.setting_share: //好友分享

                break;
            case R.id.version_check: //版本检查
                new MaterialDialog.Builder(getActivity())
                        .title(getResources().getString(R.string.clear_tip))
                        .content(getResources().getString(R.string.is_already_the_latest_version))
                        .positiveText(getResources().getString(R.string.ok))
                        .onPositive((dialog,which)->dialog.dismiss()).show();
                break;
            case R.id.setting_byme:  //关于作者
                WebActivity.runActivity(getActivity(), "My Github,Welcome star", "https://github.com/wuyinlei");
                break;
        }
    }
}
