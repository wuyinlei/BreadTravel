package com.renren.breadtravel.ui;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.text.TextUtils;
import android.transition.Explode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.LogInCallback;
import com.renren.breadtravel.R;
import com.renren.breadtravel.base.BaseSwipeActivity;
import com.renren.breadtravel.event.UserEvent;

import org.greenrobot.eventbus.EventBus;

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
                //finish();
                break;
            case R.id.bt_go:
                doLogin();

                ActivityOptionsCompat oc2 = ActivityOptionsCompat.makeSceneTransitionAnimation(this);
             //   Intent i2 = new Intent(this,LoginSuccessActivity.class);
             //   startActivity(i2, oc2.toBundle());
                break;
        }
    }

    private void doLogin() {
        Explode explode = null;
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            explode = new Explode();
//            explode.setDuration(500);
//
//            getWindow().setExitTransition(explode);
//            getWindow().setEnterTransition(explode);
//            ActivityOptionsCompat oc2 = ActivityOptionsCompat.makeSceneTransitionAnimation(this);
//
//        }

        String username = mEtUsername.getText().toString().trim();
        String password = mEtPassword.getText().toString().trim();
        if (TextUtils.isEmpty(username)){
            Toast.makeText(this, getResources().getString(R.string.user_name_is_empty),
                    Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(password)){
            Toast.makeText(this, getResources().getString(R.string.pass_word_is_empty),
                    Toast.LENGTH_SHORT).show();
            return;
        }

        AVUser.logInInBackground(username, password, new LogInCallback<AVUser>() {
            @Override
            public void done(AVUser avUser, AVException e) {
                if (e == null){
                    AVUser mCurrentUser = avUser;
                    UserEvent event = new UserEvent();
                    event.mAVUser = mCurrentUser;
                    EventBus.getDefault().post(event);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            LoginActivity.this.finish();
                        }
                    },500);
                }
            }
        });

    }
}
