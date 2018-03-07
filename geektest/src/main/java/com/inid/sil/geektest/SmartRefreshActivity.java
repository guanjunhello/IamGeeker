package com.inid.sil.geektest;

import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;

public class SmartRefreshActivity extends BaseActivity implements OnRefreshListener, BaseQuickAdapter.RequestLoadMoreListener {

    RecyclerView recyclerview;
    private RefreshLayout refreshLayout;
    ArrayList<String> dataList = new ArrayList<>();
    private XAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_smart_refresh;
    }

    @Override
    protected void initViews() {
        recyclerview = (RecyclerView) findViewById(R.id.recyclerview);
        refreshLayout = (RefreshLayout)findViewById(R.id.refreshlayout);
        refreshLayout.setDragRate(0.4f);

        refreshLayout.setOnRefreshListener(this);
        refreshLayout.setEnableLoadMore(false);
        adapter = new XAdapter(dataList);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        recyclerview.setAdapter(adapter);

        refreshLayout.autoRefresh();

        adapter.setOnLoadMoreListener(this, recyclerview);
    }

    int page = 0;
    @Override
    public void onRefresh(final RefreshLayout refreshLayout) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                page = 0;
                dataList.clear();
                for (int i = 0; i < 10; i++) {
                    dataList.add("new item - "+i);
                }
                adapter.setNewData(dataList);
                refreshLayout.finishRefresh();
            }
        }, 1000);
    }


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
                for (int i = 0; i < 10; i++) {
                    dataList.add("( " +page+" )"+"more item - "+i);
                }
                adapter.notifyDataSetChanged();
                adapter.loadMoreComplete();
            }
        }, 1000);
    }
}
