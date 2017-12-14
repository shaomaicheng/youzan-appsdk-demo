package com.example.chenglei.youzansdkdemo;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.youzan.androidsdk.basic.YouzanBrowser;
import com.youzan.androidsdk.event.AbsAuthEvent;
import com.youzan.androidsdk.ui.YouzanClient;

/**
 * Created by chenglei on 2017/12/14.
 */

public class YouzanFragment extends Fragment {

    private YouzanBrowser youzanBrowser;
    private Prefer prefer;

    public static YouzanFragment getInstance() {
        return new YouzanFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
            return inflater.inflate(R.layout.frag_main,container,  false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);


        youzanBrowser = getActivity().findViewById(R.id.yz_browser);
        prefer = new Prefer(getActivity());

        setupYouzanView(youzanBrowser);

        youzanBrowser.loadUrl("https://kdt.im/QXTyoh");

    }

    private void setupYouzanView(YouzanClient client) {
        client.subscribe(new AbsAuthEvent() {
            @Override
            public void call(Context context, boolean need) {
                if (need) {
                    if (!prefer.isLogined()) {
                        startActivityForResult(new Intent(getActivity(), LoginActivity.class), 10);
                    } else {

                    }
                } else {
                    // request token
                }
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (10 == requestCode) {
            if (resultCode == -1) {
                prefer.setLogin(true);
            } else {
                if (!youzanBrowser.syncNot()) {
                    ((YouzanActivity)getActivity()).onBackPressed();
                }
            }
        } else {
        }

    }
    public boolean pageGoBack() {
        return youzanBrowser.pageGoBack();
    }
}
