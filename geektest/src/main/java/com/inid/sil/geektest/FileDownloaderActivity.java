package com.inid.sil.geektest;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.header.FalsifyHeader;

import java.util.ArrayList;
import java.util.List;

public class FileDownloaderActivity extends BaseActivity {

    RecyclerView recyclerView;

    List<AppInfo> data;
    private AppDownloaderAdapter adapter;
    SmartRefreshLayout refreshLayout;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_file_downloader;
    }

    @Override
    protected String setTitle() {
        return "FileDownloader";
    }

    @Override
    protected void initViews() {
        refreshLayout = (SmartRefreshLayout) findViewById(R.id.refreshLayout);

        refreshLayout.setDragRate(0.3f);
        refreshLayout.setRefreshHeader(new FalsifyHeader(this));
        refreshLayout.setEnableOverScrollDrag(true);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        data = new ArrayList<>();
        data.add(new AppInfo("https://pp.myapp.com/ma_icon/0/icon_52574890_1518512742/96", "绝地求生 全军出击", "《绝地求生 全军出击》在移动端完成了原版端游《绝地求生》在玩法、地图、道具和画面上的经典还原", "885.84M",
                "http://imtt.dd.qq.com/16891/3D3A4361B5C881ED95D96737746FBBCA.apk?fsname=com.tencent.tmgp.pubgm_1.0.3.1.0_106.apk&csr=1bbd"));
        data.add(new AppInfo("https://pp.myapp.com/ma_icon/0/icon_97229_1519625513/96", "内涵段子", "注定是要成为2018年超火爆的内容社区！整个互联网有趣的人都在这里啦！", "20.39M",
                "http://imtt.dd.qq.com/16891/EF7030510CC2D4E8925494339DB4889E.apk?fsname=com.ss.android.essay.joke_6.8.9_689.apk&csr=1bbd"));

        adapter = new AppDownloaderAdapter(data);
        recyclerView.setAdapter(adapter);


    }
}
