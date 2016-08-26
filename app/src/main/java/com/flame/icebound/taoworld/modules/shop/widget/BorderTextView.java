package com.flame.icebound.taoworld.modules.shop.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/7/31.
 */
public class BorderTextView extends TextView {

    private Paint paint;

    public BorderTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.GRAY);
        paint.setAlpha(50);

    }

    @Override
    protected void onDraw(Canvas canvas) {


        super.onDraw(canvas);
        canvas.drawRect(0,0,getWidth(),getHeight(),paint);
    }
}
