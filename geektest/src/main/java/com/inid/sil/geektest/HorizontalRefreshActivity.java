package com.inid.sil.geektest;

import android.os.Handler;

import com.blankj.utilcode.util.ToastUtils;
import com.inid.sil.geektest.discretescrollview.DSVOrientation;
import com.inid.sil.geektest.discretescrollview.DiscreteScrollView;
import com.inid.sil.geektest.discretescrollview.transform.ScaleTransformer;
import com.inid.sil.geektest.pullleftrefresh.PullLeftToRefreshLayout;

public class HorizontalRefreshActivity extends BaseActivity {

    PullLeftToRefreshLayout pullLeftRefresh;
    DiscreteScrollView recyclerview;
    private HorizontalCardAdapter horizontalCardAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_horizontal_refresh;
    }

    @Override
    protected void initViews() {
        pullLeftRefresh = (PullLeftToRefreshLayout) findViewById(R.id.pullLeftRefresh);
        recyclerview = (DiscreteScrollView) findViewById(R.id.recyclerview);

        pullLeftRefresh.setOnRefreshListener(new PullLeftToRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                ToastUtils.showLong("加载更多...");
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        horizontalCardAdapter.addMoreBgColor();
                    }
                }, 1000);
            }
        });

        recyclerview.setOrientation(DSVOrientation.HORIZONTAL);
        horizontalCardAdapter = new HorizontalCardAdapter();
        recyclerview.setAdapter(horizontalCardAdapter);
        recyclerview.setItemTransformer(new ScaleTransformer.Builder()
                .setMinScale(1.0f)
                .build());
    }
}
