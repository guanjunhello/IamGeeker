package com.inid.sil.studynotes;

import android.app.Application;

import com.blankj.utilcode.util.Utils;

/**
 * created by Guan at 2018/3/26 0026 下午 5:28
 * description:
 */
public class StudyNotesApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);
    }
}
