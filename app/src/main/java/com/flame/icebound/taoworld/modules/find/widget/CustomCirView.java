package com.flame.icebound.taoworld.modules.find.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by hasee on 2016/8/6.
 */
public class CustomCirView extends View {

    private Bitmap bitmap;
    private float mCenterX;
    private float mCenterY;
    private float mRadius;

    public CustomCirView(Context context) {
        this(context,null);
    }

    public CustomCirView(Context context, AttributeSet attrs) {
        super(context,attrs,0);
    }

    private void init(Context context, AttributeSet attrs, float i) {
    }

    public CustomCirView(Context context, AttributeSet attrs,int mRadius) {
        super(context,attrs,mRadius);
    }



    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(bitmap.getWidth(),bitmap.getHeight());
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(bitmap,0,0,null);
    }
}
