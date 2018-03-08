package com.inid.sil.geektest;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;

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
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        data = new ArrayList<>();
        data.add(new AppInfo("https://pp.myapp.com/ma_icon/0/icon_52574890_1518512742/96", "绝地求生 全军出击", "885.84M", "《绝地求生 全军出击》在移动端完成了原版端游《绝地求生》在玩法、地图、道具和画面上的经典还原",
                "http://imtt.dd.qq.com/16891/3D3A4361B5C881ED95D96737746FBBCA.apk?fsname=com.tencent.tmgp.pubgm_1.0.3.1.0_106.apk&csr=1bbd"));
        data.add(new AppInfo("https://pp.myapp.com/ma_icon/0/icon_97229_1519625513/96", "内涵段子", "20.39M", "注定是要成为2018年超火爆的内容社区！整个互联网有趣的人都在这里啦！",
                "http://imtt.dd.qq.com/16891/3D3A4361B5C881ED95D96737746FBBCA.apk?fsname=com.tencent.tmgp.pubgm_1.0.3.1.0_106.apk&csr=1bbd"));


        adapter = new AppDownloaderAdapter(data);
        recyclerView.setAdapter(adapter);


    }
}
