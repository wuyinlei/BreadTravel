package com.renren.breadtravel;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.renren.breadtravel.widget.NavigationDrawerFragment;
import com.renren.breadtravel.widget.navagation.NavigationDrawerCallbacks;

import static android.R.attr.breadCrumbShortTitle;
import static android.R.attr.fragment;

public class MainActivity extends AppCompatActivity implements NavigationDrawerCallbacks, View.OnClickListener {


    private DrawerLayout mDrawerLayout;
    private FrameLayout mContainer;

    private NavigationDrawerFragment mNavigationDrawerFragment;

    private ImageView mImgNav;
    private ImageView mImgSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mContainer = (FrameLayout) findViewById(R.id.container);
        mNavigationDrawerFragment = (NavigationDrawerFragment) getFragmentManager()
                .findFragmentById(R.id.fragment_drawer);
        mNavigationDrawerFragment.setUp(R.id.fragment_drawer,mDrawerLayout);
        mImgNav = (ImageView) findViewById(R.id.img_nav);
        mImgNav.setOnClickListener(this);
        mImgSearch = (ImageView) findViewById(R.id.img_search);
        mImgSearch.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        if (mNavigationDrawerFragment.isDrawerOpen()) {
            mNavigationDrawerFragment.closeDrawer();
        } else {
            super.onBackPressed();
        }

    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.img_nav:
                    mNavigationDrawerFragment.openDrawer();
                break;
            case R.id.img_search:
                Toast.makeText(this, "clicked search", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
