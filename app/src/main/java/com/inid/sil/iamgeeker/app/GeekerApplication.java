package com.inid.sil.iamgeeker.app;

import android.app.Application;

import com.blankj.utilcode.util.Utils;

/**
 * author: $USER_NAME
 * created on: 2018/2/27 0027 下午 3:16
 * description:
 */
public class GeekerApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Utils.init(this);
    }
}
