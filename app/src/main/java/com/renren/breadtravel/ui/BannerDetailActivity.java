package com.renren.breadtravel.ui;

import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.renren.breadtravel.R;
import com.renren.breadtravel.base.BaseActivity;
import com.renren.breadtravel.constant.Constants;

public class BannerDetailActivity extends BaseActivity implements View.OnClickListener {

    private ImageView mImgBack, mImgLiked, mImgShare;
    private TextView mTvTitle;
    private WebView mWebView;

    private FrameLayout mFramelayoutNotification;

    private String web_url;


    @Override
    protected int getResultId() {
        return R.layout.activity_banner_detail;
    }

    @Override
    protected void initListener() {
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

    @Override
    public void initView() {
        mImgBack = (ImageView) findViewById(R.id.img_nav);
        mImgLiked = (ImageView) findViewById(R.id.img_like);
        mImgLiked.setVisibility(View.VISIBLE);
        mImgShare = (ImageView) findViewById(R.id.img_search);
        mTvTitle = (TextView) findViewById(R.id.tv_title);
        mWebView = (WebView) findViewById(R.id.webview);
        mFramelayoutNotification = (FrameLayout) findViewById(R.id.framelayout_notification);
        web_url = getIntent().getStringExtra(Constants.WEB_VIEW_URL);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_nav:  //返回逻辑
                finish();
                break;
            case R.id.img_search:  //分享逻辑

                break;
            case R.id.img_like:  //添加收藏逻辑

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
}
