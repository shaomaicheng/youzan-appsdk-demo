package com.example.chenglei.youzansdkdemo;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by chenglei on 2017/12/14.
 */

public class Prefer {

    private static final String SIGN_SP_NAME = "COM.YOUZAN.SDK.TEST.PREFERENCE";
    private static final String SP_KEY_LOGIN = "account.access_token";

    private SharedPreferences mSP;
    private SharedPreferences.Editor mEditor;

    public Prefer(Context context) {
        Context appCtx = context.getApplicationContext();
        if (appCtx != null) {
            context = appCtx;
        }
        mSP = context.getSharedPreferences(SIGN_SP_NAME, Context.MODE_PRIVATE);
        mEditor = mSP.edit();
    }

    public boolean isLogined() {
        return mSP.getBoolean(SP_KEY_LOGIN, false);
    }

    public void setLogin(boolean value) {
        mEditor.putBoolean(SP_KEY_LOGIN, value);
        mEditor.commit();
    }

    public void clear() {
        mEditor.clear().commit();
    }
}
