package com.inid.sil.geektest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.yanzhenjie.sofia.Sofia;

public class SofiaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sofia);

//        Sofia.with(this).statusBarDarkFont().invasionStatusBar();
        Sofia.with(this).statusBarLightFont().invasionStatusBar();

    }
}
