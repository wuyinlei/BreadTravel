package com.renren.breadtravel.ui;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.transition.Explode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.renren.breadtravel.R;
import com.renren.breadtravel.base.BaseSwipeActivity;

import static com.renren.breadtravel.R.id.fab_register;

public class LoginActivity extends BaseSwipeActivity implements View.OnClickListener {

    private EditText mEtUsername;
    private EditText mEtPassword;
    private Button mBtGo;
    private FloatingActionButton mFabRegister;
   // private FloatingActionButton mFabThird;


    @Override
    protected int getResultId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initListener() {
       // mFabThird.setOnClickListener(this);
        mFabRegister.setOnClickListener(this);
        mBtGo.setOnClickListener(this);
    }

    @Override
    public void initView() {
        mEtUsername = (EditText) findViewById(R.id.et_username);
        mEtPassword = (EditText) findViewById(R.id.et_password);
        mBtGo = (Button) findViewById(R.id.bt_go);
        mFabRegister = (FloatingActionButton) findViewById(fab_register);
        //mFabThird = (FloatingActionButton) findViewById(R.id.fab_third);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case fab_register:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    getWindow().setExitTransition(null);
                    getWindow().setEnterTransition(null);
                    ActivityOptions options =
                            ActivityOptions.makeSceneTransitionAnimation(this, mFabRegister,
                                    mFabRegister.getTransitionName());
                    startActivity(new Intent(this, RegisterActivity.class), options.toBundle());
                } else {
                    startActivity(new Intent(this, RegisterActivity.class));
                }
                break;
            case R.id.bt_go:
                Explode explode = null;
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    explode = new Explode();
                    explode.setDuration(500);

                    getWindow().setExitTransition(explode);
                    getWindow().setEnterTransition(explode);
                }

                ActivityOptionsCompat oc2 = ActivityOptionsCompat.makeSceneTransitionAnimation(this);
             //   Intent i2 = new Intent(this,LoginSuccessActivity.class);
             //   startActivity(i2, oc2.toBundle());
                break;
        }
    }
}
