package com.inid.sil.geektest;

import android.os.Handler;
import android.support.design.widget.AppBarLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

public class MDActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener, BaseQuickAdapter.RequestLoadMoreListener {

    AppBarLayout appbar;
    Toolbar toolbar;
    RecyclerView recyclerview;
    SwipeRefreshLayout swiperefresh;
    private List<String> datas;
    private XAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_md;
    }

    @Override
    protected void initViews() {
        swiperefresh = (SwipeRefreshLayout) findViewById(R.id.swiperefresh);
        appbar = (AppBarLayout) findViewById(R.id.appbar);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        recyclerview = (RecyclerView) findViewById(R.id.recyclerview);



        swiperefresh.setColorSchemeColors(ContextCompat.getColor(this, R.color.colorPrimary));
        swiperefresh.setOnRefreshListener(this);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        datas = new ArrayList<>();
        adapter = new XAdapter(datas);
        recyclerview.setAdapter(adapter);

        swiperefresh.setRefreshing(true);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                datas.clear();
                for (int i = 0; i < 20; i++) {
                    datas.add("first item "+i+" ( page = " +page+" )");
                }
                swiperefresh.setRefreshing(false);
                adapter.notifyDataSetChanged();
            }
        }, 1000);

        adapter.setEnableLoadMore(true);
        adapter.setOnLoadMoreListener(this, recyclerview);
    }

    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                datas.clear();
                page = 0;
                for (int i = 0; i < 20; i++) {
                    datas.add("refresh item "+i+" ( page = " +page+" )");
                }
                swiperefresh.setRefreshing(false);
                adapter.setNewData(datas);
            }
        }, 1000);
    }

    int page = 0;

    @Override
    public void onLoadMoreRequested() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                page++;
                if(page>2){
                    adapter.loadMoreEnd();
                    return;
                }
                for (int i = 0; i < 5; i++) {
                    datas.add("more item "+i+" ( page = " +page+" )");
                }
                adapter.notifyDataSetChanged();
                adapter.loadMoreComplete();
            }
        }, 1000);
    }
}
