package com.inid.sil.geektest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * created by Guan at 2018/3/13 0013 上午 10:28
 * description:
 */
public class MyGradientView extends View {

    public MyGradientView(Context context) {
        super(context);
    }

    public MyGradientView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyGradientView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //获取View的宽高
        int width = getWidth();
        int height = getHeight();

        int colorStart = getResources().getColor(R.color.colorPrimary);
        int color1 = getResources().getColor(R.color.accent);
        int colorEnd = getResources().getColor(R.color.colorPrimary);

        Paint paint = new Paint();
//        LinearGradient backGradient = new LinearGradient(0, 0, 0, height, new int[]{colorStart, color1 ,colorEnd}, null, Shader.TileMode.CLAMP);
        LinearGradient backGradient = new LinearGradient(0, 0, width, 0, new int[]{colorStart, color1 ,colorEnd}, null, Shader.TileMode.CLAMP);
        paint.setShader(backGradient);
        canvas.drawRect(0, 0, width, height, paint);
    }
}
