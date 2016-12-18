package com.renren.breadtravel.ui;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.avos.avoscloud.AVCloudQueryResult;
import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.CloudQueryCallback;
import com.avos.avoscloud.SaveCallback;
import com.renren.breadtravel.R;
import com.renren.breadtravel.base.BaseActivity;
import com.renren.breadtravel.base.BaseSwipeActivity;
import com.renren.breadtravel.constant.Constants;
import com.renren.breadtravel.utils.ShareUtils;

import java.util.Arrays;

public class DetailActivity extends BaseSwipeActivity implements View.OnClickListener {

    private ImageView mImgBack, mImgLiked, mImgShare;
    private TextView mTvTitle;
    private WebView mWebView;

    private FrameLayout mFramelayoutNotification;

    private String web_url;

    private AVUser mAVUser;

    private String mWebTitle;

    private boolean isCollect = false;  //用于判断是否被收藏了
    private String objectId;


    @Override
    protected int getResultId() {
        return R.layout.activity_banner_detail;
    }

    @Override
    protected void initListener() {
        mImgBack.setImageResource(R.drawable.btn_selector_bg);
        mImgBack.setOnClickListener(this);
        mImgShare.setOnClickListener(this);
        mImgLiked.setOnClickListener(this);
        mFramelayoutNotification.setOnClickListener(this);
    }

    @Override
    public void initData() {
        super.initData();

        mWebView.loadUrl(web_url);

        WebChromeClient wvcc = new WebChromeClient() {
            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
                mWebTitle = title;
                mTvTitle.setText(title);


            }
        };
        mWebView.setWebChromeClient(wvcc);

        // 创建WebViewClient对象
        WebViewClient wvc = new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                // 使用自己的WebView组件来响应Url加载事件，而不是使用默认浏览器器加载页面
                mWebView.loadUrl(url);
                // 消耗掉这个事件。Android中返回True的即到此为止吧,事件就会不会冒泡传递了，我们称之为消耗掉
                return true;
            }
        };
        mWebView.setWebViewClient(wvc);


    }

    /**
     * 查询是否已经收藏过
     */
    private void queryCollection() {
        String sql = "select * from Collection where username = '"+mAVUser.getUsername() +"' and  web_url = '" + web_url + "'";
        AVQuery.doCloudQueryInBackground(sql, new CloudQueryCallback<AVCloudQueryResult>() {
            @Override
            public void done(AVCloudQueryResult avCloudQueryResult, AVException e) {
                if (e == null) {
                    if (avCloudQueryResult.getResults().size() != 0) {
                        //查询出来了  证明有了数据保存
                        mImgLiked.setImageResource(R.drawable.btn_spot_liked_check_press);
                        isCollect = true;
                        objectId = avCloudQueryResult.getResults().get(0).getObjectId();
                    }
                } else {
                    mImgLiked.setImageResource(R.drawable.btn_spot_liked_normal);
                    isCollect = false;
                }
            }
        });
    }

    @Override
    public void initView() {
        mImgBack = (ImageView) findViewById(R.id.img_nav);
        mImgLiked = (ImageView) findViewById(R.id.img_like);
        mImgLiked.setVisibility(View.VISIBLE);
        mImgShare = (ImageView) findViewById(R.id.img_search);
        mImgShare.setImageResource(R.drawable.icon_share_click);
        mTvTitle = (TextView) findViewById(R.id.tv_title);
        mWebView = (WebView) findViewById(R.id.webview);
        mFramelayoutNotification = (FrameLayout) findViewById(R.id.framelayout_notification);
        web_url = getIntent().getStringExtra(Constants.WEB_VIEW_URL);
        mAVUser = AVUser.getCurrentUser();
        if (mAVUser != null)
            queryCollection();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_nav:  //返回逻辑
                finish();
                break;
            case R.id.img_search:  //分享逻辑
                if (mAVUser != null) {
                    //执行分享逻辑
                    ShareUtils.showShare(this,
                            getResources().getString(R.string.tip),
                            Constants.SHARE_URL);
                } else {
                    //执行登录逻辑
                    startActivity(new Intent(this, LoginActivity.class));
                }
                break;
            case R.id.img_like:  //添加收藏逻辑
                if (mAVUser != null) {
                    if (!isCollect)
                        //执行收藏逻辑
                        doCollection();
                    else
                        doNotCollection();
                } else {
                    //指定登录逻辑
                    startActivity(new Intent(this, LoginActivity.class));
                }
                break;

            case R.id.framelayout_notification:
                new MaterialDialog.Builder(this)
                        .title(getResources().getString(R.string.tip))
                        .content(getResources().getString(R.string.notification_content))
                        .positiveText(getResources().getString(R.string.ok))
                        .onPositive((dialog, which) -> {
                            dialog.dismiss();
                        }).show();
                break;
        }
    }

    /**
     * 执行不收藏逻辑
     */
    private void doNotCollection() {
        if (!TextUtils.isEmpty(objectId)) {
            String deleteSql = "delete from Collection where objectId = '" + objectId+"'";
            AVQuery.doCloudQueryInBackground(deleteSql, new CloudQueryCallback<AVCloudQueryResult>() {
                @Override
                public void done(AVCloudQueryResult avCloudQueryResult, AVException e) {
                    if (e == null) {
                        //删除收藏成功  改变图片颜色  标志设置为false
                        mImgLiked.setImageResource(R.drawable.btn_spot_liked_normal);
                        isCollect = false;
                    }
                }
            });
        }

    }

    /**
     * 收藏逻辑
     */
    private void doCollection() {
        String username = mAVUser.getUsername();  //作为一个唯一的变量来标志每个用户的收藏  查询的时候也是根据用户名和商品id来查询
        if (!TextUtils.isEmpty(mWebTitle)) {
            AVObject collect = new AVObject("Collection");
            collect.put("username", username);
            collect.put("web_url", web_url);
            collect.put("title", mWebTitle);
            collect.saveInBackground(new SaveCallback() {
                @Override
                public void done(AVException e) {
                    if (e == null) {
                        //收藏成功
                        mImgLiked.setImageResource(R.drawable.btn_spot_liked_check_press);
                        isCollect = true;
                        objectId = collect.getObjectId();
                    }
                }
            });
        }
    }
}
