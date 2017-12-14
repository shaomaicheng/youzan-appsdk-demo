package com.example.chenglei.youzansdkdemo;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.youzan.androidsdk.basic.YouzanBrowser;

/**
 * Created by chenglei on 2017/12/14.
 */

public class YouzanActivity extends Activity {
    YouzanFragment fragment;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        fragment = YouzanFragment.getInstance();

        getFragmentManager()
                .beginTransaction()
                .replace(R.id.frag_main, fragment)
                .commit();
    }

    @Override
    public void onBackPressed() {
        if (!fragment.pageGoBack()) {
            super.onBackPressed();
        } else {
            Log.e("---------", "h5 page back");
        }
    }
}
