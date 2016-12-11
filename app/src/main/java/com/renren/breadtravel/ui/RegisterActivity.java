package com.renren.breadtravel.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.text.TextUtils;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.SignUpCallback;
import com.renren.breadtravel.R;
import com.renren.breadtravel.base.BaseActivity;
import com.renren.breadtravel.base.BaseSwipeActivity;
import com.renren.breadtravel.constant.Constants;
import com.renren.breadtravel.event.UserEvent;

import org.greenrobot.eventbus.EventBus;

public class RegisterActivity extends BaseActivity implements View.OnClickListener {

    private CardView mCvAdd;
    private EditText mEtUsername;
    private EditText mEtPassword;
    private EditText mEtRepeatpassword;
    private Button mBtGo;
    private FloatingActionButton mFabFinish;


    @Override
    protected int getResultId() {
        return R.layout.activity_register;
    }

    @Override
    protected void initListener() {
        mFabFinish.setOnClickListener(this);
        mBtGo.setOnClickListener(this);
    }

    @Override
    public void initView() {
        mCvAdd = (CardView) findViewById(R.id.cv_add);
        mEtUsername = (EditText) findViewById(R.id.et_username);
        mEtPassword = (EditText) findViewById(R.id.et_password);
        mEtRepeatpassword = (EditText) findViewById(R.id.et_repeatpassword);
        mBtGo = (Button) findViewById(R.id.bt_go);
        mFabFinish = (FloatingActionButton) findViewById(R.id.fab_finish);
    }

    private void ShowEnterAnimation() {
        Transition transition = TransitionInflater.from(this)
                .inflateTransition(R.transition.fabtransition);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setSharedElementEnterTransition(transition);


            transition.addListener(new Transition.TransitionListener() {
                @Override
                public void onTransitionStart(Transition transition) {
                    mCvAdd.setVisibility(View.GONE);
                }

                @Override
                public void onTransitionEnd(Transition transition) {
                    transition.removeListener(this);
                    animateRevealShow();
                }

                @Override
                public void onTransitionCancel(Transition transition) {

                }

                @Override
                public void onTransitionPause(Transition transition) {

                }

                @Override
                public void onTransitionResume(Transition transition) {

                }


            });
        }
    }

    public void animateRevealShow() {

        Animator mAnimator = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            mAnimator = ViewAnimationUtils.createCircularReveal(mCvAdd,
                    mCvAdd.getWidth() / 2, 0, mFabFinish.getWidth() / 2, mCvAdd.getHeight());

            mAnimator.setDuration(500);
            mAnimator.setInterpolator(new AccelerateInterpolator());
            mAnimator.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                }

                @Override
                public void onAnimationStart(Animator animation) {
                    mCvAdd.setVisibility(View.VISIBLE);
                    super.onAnimationStart(animation);
                }
            });
            mAnimator.start();
        }
    }

    public void animateRevealClose() {
        Animator mAnimator = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            mAnimator = ViewAnimationUtils.createCircularReveal(mCvAdd, mCvAdd.getWidth() / 2,
                    0, mCvAdd.getHeight(), mFabFinish.getWidth() / 2);

            mAnimator.setDuration(500);
            mAnimator.setInterpolator(new AccelerateInterpolator());
            mAnimator.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mCvAdd.setVisibility(View.INVISIBLE);
                    super.onAnimationEnd(animation);
                    mFabFinish.setImageResource(R.drawable.fab_plus);
                    RegisterActivity.super.onBackPressed();
                }

                @Override
                public void onAnimationStart(Animator animation) {
                    super.onAnimationStart(animation);
                }
            });
            mAnimator.start();
        } else {
            finish();
        }
    }

    @Override
    public void onBackPressed() {
        animateRevealClose();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fab_finish:
                animateRevealClose();
                break;

            case R.id.bt_go:
                doRegister();
                break;
        }
    }

    /**
     * 执行注册逻辑
     */
    private void doRegister() {
        String username = mEtUsername.getText().toString().trim();
        String password = mEtPassword.getText().toString().trim();
        String reportPassword = mEtRepeatpassword.getText().toString().trim();
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
        if (!password.equals(reportPassword)){
            Toast.makeText(this, getResources().getString(R.string.check_your_password_is_equal),
                    Toast.LENGTH_SHORT).show();
            return;
        }

        AVUser user = new AVUser();//新创建AVUser对象
        user.setUsername(username);//设置用户名
        user.setPassword(password);//设置密码
        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(AVException e) {
                if (e == null){
                    // 注册成功，把用户对象赋值给当前用户 AVUser.getCurrentUser()
                    AVUser currentUser = AVUser.getCurrentUser();
                    //为用户提供一个默认的图片地址
                    currentUser.put(Constants.USER_AVATOR_KEY, Constants.USER_AVATOR_IMG);
                    currentUser.saveInBackground();
                    //UserEvent event = new UserEvent();
                 //   event.mAVUser = currentUser;
                   // EventBus.getDefault().post(event);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            RegisterActivity.this.finish();
                        }
                    },500);

                } else if (e.getCode() == 202){
                    Toast.makeText(RegisterActivity.this,
                            getResources().getString(R.string.username_has_been_register),
                            Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
}
