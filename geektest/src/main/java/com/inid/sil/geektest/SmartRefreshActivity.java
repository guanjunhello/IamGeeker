package com.inid.sil.geektest;

import android.support.v7.widget.RecyclerView;

public class SmartRefreshActivity extends BaseActivity {

    RecyclerView recyclerview;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_smart_refresh;
    }

    @Override
    protected void initViews() {
        recyclerview = (RecyclerView) findViewById(R.id.recyclerview);
    }
}
