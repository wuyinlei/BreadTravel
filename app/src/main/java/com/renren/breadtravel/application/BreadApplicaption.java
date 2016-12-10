package com.renren.breadtravel.application;

import android.app.Application;

import com.avos.avoscloud.AVOSCloud;

/**
 * Created by wuyinlei on 2016/12/10.
 */

public class BreadApplicaption extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // 初始化参数依次为 this, AppId, AppKey
        AVOSCloud.initialize(this,
                "f8xAgOh3QDjicnWtHRjN84AJ-gzGzoHsz",
                "vBYDqJvUT4xxmL33KDjhbDkA");
    }
}
