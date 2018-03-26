package com.inid.sil.studynotes;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * created by Guan at 2018/3/26 0026 下午 4:47
 * description:
 */
public class MainAdapter extends BaseQuickAdapter<BookInfo, BaseViewHolder> {

    private List<Integer> bgColors;
    private List<Integer> bgColors2;

    public MainAdapter(@Nullable List<BookInfo> data) {
        super(R.layout.adapter_main, data);
        bgColors = new ArrayList<>();
        bgColors2 = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            int r = new Random().nextInt(185);
            int g = new Random().nextInt(185);
            int b = new Random().nextInt(185);

            bgColors.add(Color.rgb(r, g, b));
            bgColors2.add(Color.rgb(r+70, g+70, b+70));
        }
    }

    @Override
    protected void convert(BaseViewHolder helper, BookInfo item) {
        TextView tv_book_name = helper.getView(R.id.tv_book_name);
        tv_book_name.setText(item.getName());

        View view_flag = helper.getView(R.id.view_flag);
        int colors[] = { bgColors.get(helper.getLayoutPosition()), bgColors2.get(helper.getLayoutPosition()) };
        GradientDrawable bg = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, colors);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            view_flag.setBackground(bg);
        }else {
            view_flag.setBackgroundDrawable(bg);
        }
    }
}
