package com.inid.sil.geektest;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * created by Guan at 2018/2/28 0028 下午 4:47
 * description:
 */
public class XAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public XAdapter( @Nullable List<String> data) {
        super(R.layout.adapter_x_item, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.tv_x, item);
    }
}
