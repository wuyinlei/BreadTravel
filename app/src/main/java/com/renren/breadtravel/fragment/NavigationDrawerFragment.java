package com.renren.breadtravel.fragment;


import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.avos.avoscloud.AVUser;
import com.bumptech.glide.Glide;
import com.renren.breadtravel.R;
import com.renren.breadtravel.constant.Constants;
import com.renren.breadtravel.event.UserEvent;
import com.renren.breadtravel.ui.LoginActivity;
import com.renren.breadtravel.ui.UserDetailActivity;
import com.renren.breadtravel.widget.navagation.NavigationDrawerAdapter;
import com.renren.breadtravel.widget.navagation.NavigationDrawerCallbacks;
import com.renren.breadtravel.widget.navagation.NavigationItem;
import com.renren.breadtravel.widget.transform.GlideCircleTransform;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

/**
 * 左侧菜单栏,用于选择选项记录,并且在主界面更新所选择的Fragment
 */
public class NavigationDrawerFragment extends Fragment implements NavigationDrawerCallbacks, View.OnClickListener {

    private static final String PREF_USER_LEARNED_DRAWER = "navigation_drawer_learned";

    //选择
    private static final String STATE_SELECTED_POSITION = "selected_navigation_drawer_position";

    //
    private static final String PREFERENCES_FILE = "my_app_settings"; //TODO: change this to your file

    //回调
    private NavigationDrawerCallbacks mCallbacks;

    private RecyclerView mDrawerList;

    private View mFragmentContainerView;

    private DrawerLayout mDrawerLayout;

    private ActionBarDrawerToggle mActionBarDrawerToggle;

    private boolean mUserLearnedDrawer;

    //是否是有保存
    private boolean mFromSaveInstanceState;

    //当前选择的位置
    private int mCurrentSelectedPosition;

    private TextView mTvLogin;
    private ImageView mIvAvator;

    private AVUser mAVUser;
    String userName;
    String userAvator;
    private String mImage;

    /**
     * 保存sp值
     *
     * @param context      上下文
     * @param settingName  name
     * @param settingValue value
     */
    public static void savaShareSetting(Context context, String settingName, String settingValue) {
        SharedPreferences prefs = context.getSharedPreferences(PREFERENCES_FILE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(settingName, settingValue);
        editor.apply();
    }

    /**
     * 读取设置的值
     *
     * @param context      上下文
     * @param settingName  name
     * @param settingValue value
     * @return 保存的值
     */
    public static String readShareSetting(Context context, String settingName, String settingValue) {
        SharedPreferences prefs = context.getSharedPreferences(PREFERENCES_FILE, Context.MODE_PRIVATE);
        return prefs.getString(settingName, settingValue);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        EventBus.getDefault().register(this);

        View view = inflater.inflate(R.layout.fragment_navigation_drawer, container, false);
        mDrawerList = (RecyclerView) view.findViewById(R.id.drawerList);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mDrawerList.setLayoutManager(manager);
        mDrawerList.setHasFixedSize(true);

        final List<NavigationItem> navigationItems = getMenu();

        NavigationDrawerAdapter adapter = new NavigationDrawerAdapter(navigationItems);
        adapter.setNavigationDrawerCallbacks(this);
        mDrawerList.setAdapter(adapter);
        selectItem(mCurrentSelectedPosition);

        mTvLogin = (TextView) view.findViewById(R.id.tv_login);
        mIvAvator = (ImageView) view.findViewById(R.id.img_avator);
        mTvLogin.setOnClickListener(this);
        mIvAvator.setOnClickListener(this);

        mAVUser = AVUser.getCurrentUser();
       // Log.d("NavigationDrawerFragmen", "mAVUser:" + mAVUser);
        if (mAVUser != null){
            mTvLogin.setText(mAVUser.getUsername());
            Glide.with(getActivity())
                    .load(mAVUser.get(Constants.USER_AVATOR_KEY))
                    .asBitmap()
                    .transform(new GlideCircleTransform(getActivity()))
                    .into(mIvAvator);
        }

        return view;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void UserEventCallback(UserEvent event) {
        if (event != null) {
            mAVUser = event.mAVUser;
            userName = mAVUser.getUsername();
            mImage = (String) mAVUser.get(Constants.USER_AVATOR_KEY);
            if (mImage == null)
                updateUI(userName);
            else
                updateUI(userName, mImage);
        }
    }

    /**
     * 更新UI
     *
     * @param userName 用户名
     * @param image    用户名图片地址
     */
    private void updateUI(String userName, String image) {
        if (!TextUtils.isEmpty(userName))
            mTvLogin.setText(userName);
        Glide.with(getActivity())
                .load(image)
                .asBitmap()
                .transform(new GlideCircleTransform(getActivity()))
                .into(mIvAvator);
    }

    /**
     * 更新UI
     *
     * @param userName 用户名
     */
    private void updateUI(String userName) {
        if (!TextUtils.isEmpty(userName))
            mTvLogin.setText(userName);
        mAVUser.put(Constants.USER_AVATOR_KEY,Constants.USER_AVATOR_IMG);
        Glide.with(getActivity())
                .load(Constants.USER_AVATOR_IMG)
                .asBitmap()
                .transform(new GlideCircleTransform(getActivity()))
                .into(mIvAvator);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mCallbacks = (NavigationDrawerCallbacks) context;
    }

    public void setUp(int fragmentId, DrawerLayout drawerLayout) {
        mFragmentContainerView = getActivity().findViewById(fragmentId);
        mDrawerLayout = drawerLayout;
//        mDrawerLayout
//                .setStatusBarBackgroundColor(
//                        getResources().getColor(R.color.myPrimaryDarkColor));

        mActionBarDrawerToggle = new ActionBarDrawerToggle(getActivity(), mDrawerLayout, null
                , R.string.drawer_open, R.string.drawer_close) {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                if (isAdded()) {
                    return;
                }
                getActivity().invalidateOptionsMenu();
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                if (!isAdded()) {
                    return;
                }
                if (!mUserLearnedDrawer) {
                    mUserLearnedDrawer = true;
                    savaShareSetting(getActivity(), PREF_USER_LEARNED_DRAWER, "true");
                }
                getActivity().invalidateOptionsMenu();
            }
        };

        if (!mUserLearnedDrawer && !mFromSaveInstanceState) {
            mDrawerLayout.openDrawer(mFragmentContainerView);
        }

        mDrawerLayout.post(() -> mActionBarDrawerToggle.syncState());

        mDrawerLayout.setDrawerListener(mActionBarDrawerToggle);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallbacks = null;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mUserLearnedDrawer = Boolean.valueOf(readShareSetting(getActivity(), PREF_USER_LEARNED_DRAWER, "false"));
        if (savedInstanceState != null) {
            mCurrentSelectedPosition = savedInstanceState.getInt(STATE_SELECTED_POSITION);
            mFromSaveInstanceState = true;
        }
    }

    private void selectItem(int currentSelectedPosition) {
        mCurrentSelectedPosition = currentSelectedPosition;
        if (mDrawerLayout != null) {
            mDrawerLayout.closeDrawer(mFragmentContainerView);
        }
        if (mCallbacks != null) {
            mCallbacks.onNavigationDrawerItemSelected(currentSelectedPosition);
        }
        ((NavigationDrawerAdapter) mDrawerList.getAdapter()).selectPosition(currentSelectedPosition);
    }

    public boolean isDrawerOpen() {
        return mDrawerLayout != null && mDrawerLayout.isDrawerOpen(mFragmentContainerView);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mActionBarDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(STATE_SELECTED_POSITION, mCurrentSelectedPosition);
    }


    public void openDrawer() {
        mDrawerLayout.openDrawer(mFragmentContainerView);
    }

    public void closeDrawer() {
        mDrawerLayout.closeDrawer(mFragmentContainerView);
    }


    public ActionBarDrawerToggle getActionBarDrawerToggle() {
        return mActionBarDrawerToggle;
    }

    public void setActionBarDrawerToggle(ActionBarDrawerToggle actionBarDrawerToggle) {
        mActionBarDrawerToggle = actionBarDrawerToggle;
    }

    private List<NavigationItem> getMenu() {
        List<NavigationItem> items = new ArrayList<>();
        items.add(new NavigationItem(getActivity().getResources().getString(R.string.hot_trip)));
        items.add(new NavigationItem(getActivity().getResources().getString(R.string.bread_order)));
        items.add(new NavigationItem(getActivity().getResources().getString(R.string.setting)));

        return items;
    }

    public DrawerLayout getDrawerLayout() {
        return mDrawerLayout;
    }

    public void setDrawerLayout(DrawerLayout drawerLayout) {
        mDrawerLayout = drawerLayout;
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        selectItem(position);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_avator:
            case R.id.tv_login:
                if (mTvLogin.getText().equals(
                        getActivity()
                                .getResources()
                                .getString(R.string.login))) {
                    Intent intent = new Intent(getActivity(), LoginActivity.class);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(getActivity(), UserDetailActivity.class);
                    startActivity(intent);
                    //Toast.makeText(getActivity(), "you have been logined", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
