package com.inid.sil.geektest;

import android.support.v7.widget.RecyclerView;

import com.gcssloop.widget.PagerGridLayoutManager;
import com.gcssloop.widget.PagerGridSnapHelper;

public class PagerLayoutActivity extends BaseActivity implements PagerGridLayoutManager.PageListener {

    RecyclerView recyclerview;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_pager_layout;
    }

    @Override
    protected String setTitle() {
        return "PagerLayout";
    }

    @Override
    protected void initViews() {
        recyclerview = (RecyclerView) findViewById(R.id.recyclerview);

        // 1.水平分页布局管理器
        PagerGridLayoutManager layoutManager = new PagerGridLayoutManager(
                1, 1, PagerGridLayoutManager.HORIZONTAL);
        layoutManager.setPageListener(this);    // 设置页面变化监听器
        recyclerview.setLayoutManager(layoutManager);

        // 2.设置滚动辅助工具
        PagerGridSnapHelper pageSnapHelper = new PagerGridSnapHelper();
        pageSnapHelper.attachToRecyclerView(recyclerview);

        // 可选(如果觉得快速滚动不够灵敏，可以调整该数值，默认为1000，数值越小越灵敏)
        pageSnapHelper.setFlingThreshold(600);

        HorizontalCardAdapter2 adapter = new HorizontalCardAdapter2();
        recyclerview.setAdapter(adapter);
    }

    @Override
    public void onPageSizeChanged(int pageSize) {

    }

    @Override
    public void onPageSelect(int pageIndex) {

    }
}
