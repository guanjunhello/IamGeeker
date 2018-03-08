package com.inid.sil.geektest;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Gravity;
import android.widget.TextView;

/**
 * created by Guan at 2018/3/8 0008 上午 11:12
 * description:
 */
public class ToolbarHelper {

    public static void addMiddleTitle(Context context, CharSequence title, Toolbar toolbar) {

        TextView textView = new TextView(context);
        textView.setTextColor(Color.WHITE);
        textView.setTextSize(18);
        textView.setMaxLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        textView.setText(title);

        Toolbar.LayoutParams params = new Toolbar.LayoutParams(Toolbar.LayoutParams.WRAP_CONTENT, Toolbar.LayoutParams.WRAP_CONTENT);
        params.gravity = Gravity.CENTER_HORIZONTAL;
        toolbar.addView(textView, params);

    }
}
