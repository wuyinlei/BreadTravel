package com.renren.breadtravel;

import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.SaveCallback;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.renren.breadtravel.base.BaseActivity;
import com.renren.breadtravel.constant.DataStore;
import com.renren.breadtravel.constant.HttpUrlPath;
import com.renren.breadtravel.fragment.BreadOrderFragment;
import com.renren.breadtravel.fragment.HotTripFragment;
import com.renren.breadtravel.fragment.NavigationDrawerFragment;
import com.renren.breadtravel.fragment.SettingFragment;
import com.renren.breadtravel.widget.navagation.NavigationDrawerCallbacks;

import okhttp3.Call;
import okhttp3.Response;

public class MainActivity extends BaseActivity implements
        NavigationDrawerCallbacks, View.OnClickListener {


    private DrawerLayout mDrawerLayout;
    private FrameLayout mContainer;

    private NavigationDrawerFragment mNavigationDrawerFragment;

    private ImageView mImgNav;
    private ImageView mImgSearch;

    private TextView mTvTitle;


    @Override
    protected int getResultId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initListener() {
        mImgNav.setOnClickListener(this);
        mImgSearch.setOnClickListener(this);
    }

    @Override
    public void initView() {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mContainer = (FrameLayout) findViewById(R.id.container);
        mNavigationDrawerFragment = (NavigationDrawerFragment) getFragmentManager()
                .findFragmentById(R.id.fragment_drawer);
        mNavigationDrawerFragment.setUp(R.id.fragment_drawer, mDrawerLayout);
        if (mNavigationDrawerFragment.isDrawerOpen()){
            mNavigationDrawerFragment.closeDrawer();
        }
        mImgNav = (ImageView) findViewById(R.id.img_nav);
        mImgSearch = (ImageView) findViewById(R.id.img_search);
        mTvTitle = (TextView) findViewById(R.id.tv_title);


//        // 测试 SDK 是否正常工作的代码
//        AVObject testObject = new AVObject("TestObject");
//        testObject.put("words","Hello World!");
//        testObject.saveInBackground(new SaveCallback() {
//            @Override
//            public void done(AVException e) {
//                if(e == null){
//                    Log.d("saved","success!");
//                }
//            }
//        });
    }

    @Override
    public void initData() {
        super.initData();

    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN){
            if(!mNavigationDrawerFragment.isDrawerOpen()) {
                //双击退出逻辑
                new MaterialDialog.Builder(MainActivity.this)
                        .title(getResources().getString(R.string.tip))
                        .content(getResources().getString(R.string.exit))
                        .negativeText(getResources().getString(R.string.cancel))
                        .onNegative(new MaterialDialog.SingleButtonCallback() {
                            @Override
                            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                dialog.dismiss();
                            }
                        }).positiveText(getResources().getString(R.string.ok))
                        .onPositive(new MaterialDialog.SingleButtonCallback() {
                            @Override
                            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                finish();
                                dialog.dismiss();
                            }
                        }).show();
                return true;
            } else {
                mNavigationDrawerFragment.closeDrawer();
                return false;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        switch (position){
            case 0:
                fragmentManager.beginTransaction()
                        .replace(R.id.container, new HotTripFragment())
                        .commit();
                mTvTitle.setText(getResources().getString(R.string.app_name));
                break;
            case 1:
                fragmentManager.beginTransaction()
                        .replace(R.id.container, new BreadOrderFragment())
                        .commit();
                mTvTitle.setText(getResources().getString(R.string.bread_order));
                break;
            case 2:
                fragmentManager.beginTransaction()
                        .replace(R.id.container, new SettingFragment())
                        .commit();
                mTvTitle.setText(getResources().getString(R.string.setting));
                break;
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_nav:
                mNavigationDrawerFragment.openDrawer();
                break;
            case R.id.img_search:
                Toast.makeText(this, "clicked search", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
