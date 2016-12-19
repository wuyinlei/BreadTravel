package com.renren.breadtravel.fragment;


import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.renren.breadtravel.R;
import com.renren.breadtravel.base.BaseLeftFragment;
import com.renren.breadtravel.cn.sharesdk.onekeyshare.OnekeyShare;
import com.renren.breadtravel.constant.Constants;
import com.renren.breadtravel.ui.MainActivity;
import com.renren.breadtravel.ui.WebActivity;
import com.renren.breadtravel.utils.CommentUtils;
import com.renren.breadtravel.utils.DataCleanManager;
import com.renren.breadtravel.utils.ShareUtils;

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

    private MainActivity mActivity;


    @Override
    protected void initListener() {
        mGestureMge.setOnClickListener(this);
        mClearCache.setOnClickListener(this);
        mSettingOpinion.setOnClickListener(this);
        mSettingShare.setOnClickListener(this);
        mVersionCheck.setOnClickListener(this);
        mSettingByme.setOnClickListener(this);
        mIvNav.setOnClickListener(this);
    }

    private ImageView mIvNav,mImgSearch;
    private TextView mTvTitle;

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

        mIvNav = (ImageView) view.findViewById(R.id.img_nav);
        mImgSearch = (ImageView) view.findViewById(R.id.img_search);
        mTvTitle = (TextView) view.findViewById(R.id.tv_title);
        mTvTitle.setText(mActivity.getResources().getString(R.string.setting));

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
                //showShare();
                ShareUtils.showShare(getActivity(),
                        getActivity().getResources().getString(R.string.tip),
                        Constants.SHARE_URL);
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

            case R.id.img_nav:
                NavigationDrawerFragment navigationDrawerFragment = mActivity.getNavigationDrawerFragment();
                if (navigationDrawerFragment !=null){
                    navigationDrawerFragment.openDrawer();
                }
                break;
        }


    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mActivity = (MainActivity) activity;
    }

    private void showShare() {
            OnekeyShare oks = new OnekeyShare();
            //关闭sso授权
            oks.disableSSOWhenAuthorize();
            // title标题，印象笔记、邮箱、信息、微信、人人网、QQ和QQ空间使用
            oks.setTitle(getActivity().getResources().getString(R.string.tip));
            // titleUrl是标题的网络链接，仅在Linked-in,QQ和QQ空间使用
            oks.setTitleUrl(Constants.SHARE_URL);
            // text是分享文本，所有平台都需要这个字段
            //分享网络图片，新浪微博分享网络图片需要通过审核后申请高级写入接口，否则请注释掉测试新浪微博
           // oks.setImageUrl("http://f1.sharesdk.cn/imgs/2014/02/26/owWpLZo_638x960.jpg");
            // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
            //oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
            // url仅在微信（包括好友和朋友圈）中使用
            oks.setUrl(Constants.SHARE_URL);
            // comment是我对这条分享的评论，仅在人人网和QQ空间使用
            oks.setComment(getActivity().getResources().getString(R.string.notification_content));
            // site是分享此内容的网站名称，仅在QQ空间使用
            oks.setSite("Welcome To My Home!");
            // siteUrl是分享此内容的网站地址，仅在QQ空间使用
            oks.setSiteUrl(Constants.SHARE_URL);
            // 启动分享GUI
            oks.show(getActivity());

    }
}
