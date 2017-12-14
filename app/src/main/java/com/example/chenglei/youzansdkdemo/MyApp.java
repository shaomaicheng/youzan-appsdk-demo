package com.example.chenglei.youzansdkdemo;

import android.app.Application;

import com.youzan.androidsdk.YouzanSDK;
import com.youzan.androidsdk.basic.YouzanBasicSDKAdapter;

/**
 * Created by chenglei on 2017/12/14.
 */

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        YouzanSDK.isDebug(true);
        YouzanSDK.init(getApplicationContext(), "demo", new YouzanBasicSDKAdapter());
    }
}
