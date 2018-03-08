package com.inid.sil.geektest;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * created by Guan at 2018/3/8 0008 下午 3:22
 * description:
 */
public class AppDownloaderAdapter extends BaseQuickAdapter<AppInfo, BaseViewHolder> implements View.OnClickListener {
    public AppDownloaderAdapter(@Nullable List<AppInfo> data) {
        super(R.layout.adapter_app_downloader, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, AppInfo item) {
        ImageView iv_icon = helper.getView(R.id.iv_icon);
        Glide.with(mContext).load(item.getIcon()).into(iv_icon);

        helper.setText(R.id.tv_name, item.getName());
        helper.setText(R.id.tv_size, item.getSize());
        helper.setText(R.id.tv_description, item.getDescription());

        Button btn_download = helper.getView(R.id.btn_download);
        btn_download.setTag(helper.getLayoutPosition());
        btn_download.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

    }
}
