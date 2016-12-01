package com.renren.breadtravel.fragment;


import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.renren.breadtravel.R;
import com.renren.breadtravel.widget.navagation.NavigationDrawerAdapter;
import com.renren.breadtravel.widget.navagation.NavigationDrawerCallbacks;
import com.renren.breadtravel.widget.navagation.NavigationItem;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class NavigationDrawerFragment extends Fragment implements NavigationDrawerCallbacks {

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

    /**
     * 保存sp值
     *
     * @param context  上下文
     * @param settingName  name
     * @param settingValue  value
     */
    public static void savaShareSetting(Context context, String settingName, String settingValue) {
        SharedPreferences prefs = context.getSharedPreferences(PREFERENCES_FILE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(settingName, settingValue);
        editor.apply();
    }

    /**
     * 读取设置的值
     * @param context  上下文
     * @param settingName  name
     * @param settingValue  value
     * @return  保存的值
     */
    public static String readShareSetting(Context context, String settingName, String settingValue) {
        SharedPreferences prefs = context.getSharedPreferences(PREFERENCES_FILE, Context.MODE_PRIVATE);
        return prefs.getString(settingName, settingValue);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

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


        return view;
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
       /* mDrawerLayout.post(new Runnable() {
            @Override
            public void run() {
                mActionBarDrawerToggle.syncState();
            }
        });*/

        mDrawerLayout.post(()->mActionBarDrawerToggle.syncState());

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
}
