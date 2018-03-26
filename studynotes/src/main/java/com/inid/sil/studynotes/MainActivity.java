package com.inid.sil.studynotes;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.gcssloop.widget.PagerGridLayoutManager;
import com.gcssloop.widget.PagerGridSnapHelper;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements PagerGridLayoutManager.PageListener, BaseQuickAdapter.OnItemClickListener {

    RecyclerView recyclerview;
    List<BookInfo> bookInfos;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViews() {
        recyclerview = findViewById(R.id.recyclerview);

        bookInfos = new ArrayList<>();
        List<NoteInfo> java_notes = new ArrayList<>();
        java_notes.add(new NoteInfo("String源码分析", "String源码分析.md"));
        bookInfos.add(new BookInfo(getString(R.string.book_java), java_notes));
        bookInfos.add(new BookInfo(getString(R.string.book_firstline), null));
        bookInfos.add(new BookInfo(getString(R.string.book_androidhero), null));
        bookInfos.add(new BookInfo(getString(R.string.book_androidarticle), null));
        bookInfos.add(new BookInfo(getString(R.string.book_designpattern), null));

        // 1.水平分页布局管理器
        PagerGridLayoutManager layoutManager = new PagerGridLayoutManager(
                4, 3, PagerGridLayoutManager.HORIZONTAL);
        layoutManager.setPageListener(this);    // 设置页面变化监听器
        recyclerview.setLayoutManager(layoutManager);

        // 2.设置滚动辅助工具
        PagerGridSnapHelper pageSnapHelper = new PagerGridSnapHelper();
        pageSnapHelper.attachToRecyclerView(recyclerview);

        // 可选(如果觉得快速滚动不够灵敏，可以调整该数值，默认为1000，数值越小越灵敏)
        pageSnapHelper.setFlingThreshold(600);

        MainAdapter adapter = new MainAdapter(bookInfos);
        recyclerview.setAdapter(adapter);
        adapter.setOnItemClickListener(this);
    }

    @Override
    public void onPageSizeChanged(int pageSize) {

    }

    @Override
    public void onPageSelect(int pageIndex) {

    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        if(bookInfos.get(position).getNoteInfos()==null||bookInfos.get(position).getNoteInfos().size()==0){
            ToastUtils.showShort("暂无笔记");
        }else {

        }
    }
}
