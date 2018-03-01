package com.inid.sil.geektest;

import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;

import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;

public class XRecyclerViewActivity extends BaseActivity implements XRecyclerView.LoadingListener {

    XRecyclerView xrecyclerview;
    MyAdapter mAdapter;
    ArrayList<String> mDatas;
    int page = 0;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_xrecycler_view;
    }

    @Override
    protected void initViews() {
        xrecyclerview = (XRecyclerView) findViewById(R.id.xrecyclerview);
        xrecyclerview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        xrecyclerview.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        xrecyclerview.setLoadingMoreProgressStyle(ProgressStyle.BallRotate);
        xrecyclerview.getDefaultRefreshHeaderView().setRefreshTimeVisible(false);

        xrecyclerview.getDefaultFootView().setLoadingHint("加载更多...");
        xrecyclerview.getDefaultFootView().setNoMoreHint("没有更多数据");

        xrecyclerview.setLoadingListener(this);
        mDatas = new ArrayList<>();
        mAdapter = new MyAdapter(mDatas);
        xrecyclerview.setAdapter(mAdapter);
        xrecyclerview.refresh();
    }


    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                page = 0;
                mDatas.clear();
                for (int i = 0; i < 10; i++) {
                    mDatas.add("new item - "+i);
                }
                mAdapter.notifyDataSetChanged();
                xrecyclerview.refreshComplete();
            }
        }, 1000);
    }

    @Override
    public void onLoadMore() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                page++;
                if(page>1){
                    xrecyclerview.setNoMore(true);
                    return;
                }
                for (int i = 0; i < 10; i++) {
                    mDatas.add("more item - "+i);
                }
                mAdapter.notifyDataSetChanged();
                xrecyclerview.loadMoreComplete();
            }
        }, 1000);
    }
}
