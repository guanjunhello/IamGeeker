package com.inid.sil.geektest;

import android.support.v7.widget.LinearLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.blankj.utilcode.util.ToastUtils;
import com.inid.sil.geektest.horizontalrefreshlayout.HorizontalRefreshLayout;
import com.inid.sil.geektest.horizontalrefreshlayout.RefreshCallBack;
import com.inid.sil.geektest.horizontalrefreshlayout.refreshhead.LoadingRefreshHeader;
import com.inid.sil.geektest.horizontalrefreshlayout.refreshhead.MaterialRefreshHeader;
import com.inid.sil.geektest.horizontalrefreshlayout.refreshhead.NiceRefreshHeader;
import com.inid.sil.geektest.rv_gallery.AnimManager;
import com.inid.sil.geektest.rv_gallery.GalleryRecyclerView;


public class HorizontalRefreshActivity3 extends BaseActivity implements RefreshCallBack {

    HorizontalRefreshLayout refreshLayout;
    GalleryRecyclerView recyclerview;
    private HorizontalCardAdapter2 horizontalCardAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_horizontal_refresh3;
    }

    @Override
    protected void initViews() {
        refreshLayout = (HorizontalRefreshLayout) findViewById(R.id.refreshLayout);
        recyclerview = (GalleryRecyclerView) findViewById(R.id.recyclerview);


        refreshLayout.setRefreshCallback(this);
        refreshLayout.setRefreshHeader(new LoadingRefreshHeader(this), HorizontalRefreshLayout.LEFT);
        refreshLayout.setRefreshHeader(new LoadingRefreshHeader(this), HorizontalRefreshLayout.RIGHT);

        horizontalCardAdapter = new HorizontalCardAdapter2();
        recyclerview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerview.setAdapter(horizontalCardAdapter);


        recyclerview.initFlingSpeed(2000)                                   // 设置滑动速度（像素/s）
                .initPageParams(0, 20)     							 // 设置页边距和左右图片的可见宽度，单位dp
                .setAnimFactor(0f)                                   // 设置切换动画的参数因子
                .setAnimType(AnimManager.ANIM_BOTTOM_TO_TOP)            // 设置切换动画类型，目前有AnimManager.ANIM_BOTTOM_TO_TOP和目前有AnimManager.ANIM_TOP_TO_BOTTOM
                .setOnItemClickListener(new GalleryRecyclerView.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        ToastUtils.showShort(""+(position+1));
                    }
                });                          // 设置点击事件
    }

    @Override
    public void onLeftRefreshing() {
        refreshLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                ToastUtils.showShort("刷新完成");
                refreshLayout.onRefreshComplete();
                horizontalCardAdapter.refreshBgColor();
            }
        }, 1000);
    }

    @Override
    public void onRightRefreshing() {
        refreshLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                ToastUtils.showShort("加载更多完成");
                refreshLayout.onRefreshComplete();
                horizontalCardAdapter.addMoreBgColor();
            }
        }, 1000);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        ToastUtils.showShort(hasCapture+"");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_refresh_head_type, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_LoadingRefreshHeader:
                refreshLayout.setRefreshHeader(new LoadingRefreshHeader(this), HorizontalRefreshLayout.LEFT);
                refreshLayout.setRefreshHeader(new LoadingRefreshHeader(this), HorizontalRefreshLayout.RIGHT);
                break;
            case R.id.action_MaterialRefreshHeader:
                refreshLayout.setRefreshHeader(new MaterialRefreshHeader(HorizontalRefreshLayout.LEFT), HorizontalRefreshLayout.LEFT);
                refreshLayout.setRefreshHeader(new MaterialRefreshHeader(HorizontalRefreshLayout.RIGHT), HorizontalRefreshLayout.RIGHT);
                break;
            case R.id.action_NiceRefreshHeader:
                refreshLayout.setRefreshHeader(new NiceRefreshHeader(this), HorizontalRefreshLayout.LEFT);
                refreshLayout.setRefreshHeader(new NiceRefreshHeader(this), HorizontalRefreshLayout.RIGHT);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
