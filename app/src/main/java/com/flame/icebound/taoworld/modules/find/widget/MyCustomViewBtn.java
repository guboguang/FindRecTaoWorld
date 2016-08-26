package com.flame.icebound.taoworld.modules.find.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.flame.icebound.taoworld.R;

/**
 * Created by hasee on 2016/8/5.
 */
public class MyCustomViewBtn extends View {

    private float lastX = 0;
    private float lastY = 0;
    private Bitmap bitmap;

    private int widthPixels;

    private int heightPixels;
    private float distanceX;
    private float distanceY;

    @Override
    public float getX() {
        return lastX;
    }

    public void setX(int x) {
        this.lastY = x;
    }

    @Override
    public float getY() {
        return lastY;
    }

    public void setY(int y) {
        this.lastY = y;
    }

    public MyCustomViewBtn(Context context) {
        super(context);
        init(context, null);
    }

    public MyCustomViewBtn(Context context, int x, int y) {
        super(context);
        this.lastX = x;
        this.lastY = y;
        init(context, null);
    }

    public MyCustomViewBtn(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyCustomViewBtn);

        int color = typedArray.getColor(R.styleable.MyCustomViewBtn_color_circle, Color.BLUE);
        int resourceId = typedArray.getResourceId(R.styleable.MyCustomViewBtn_icon_drag, R.mipmap.icon_brand);
        int anInt = typedArray.getInt(R.styleable.MyCustomViewBtn_dot_num, 2);

        bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.icon_new_home_like);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        //不管用户设置多大尺寸，都要固定值

        widthPixels = getResources().getDisplayMetrics().widthPixels;
        heightPixels = getResources().getDisplayMetrics().heightPixels;

        setMeasuredDimension(bitmap.getWidth(), bitmap.getHeight());


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int action = event.getAction();

        boolean ispen = false;

        switch (action) {
            case MotionEvent.ACTION_DOWN:

                float endX = event.getRawX();
                float endY = event.getRawY();

                if(endX>=lastX&&endX<=lastX+bitmap.getWidth()&&endY<lastY+bitmap.getHeight()&&endY>lastY){
                   Log.e("find","=====================");
                    ispen = true;
                }else {
                    ispen = false;
                    return false;
                }

            case MotionEvent.ACTION_MOVE:

                if(ispen) {

                    distanceX = event.getRawX() - lastX;
                    distanceY = event.getRawY() - lastY;

                    invalidate();
                    return true;
                }
                break;

            case MotionEvent.ACTION_UP:

                if(ispen) {
                    lastX = event.getRawX();
                    lastY = event.getRawY();
                    return true;
                }
                break;
        }
        return true;

    }

    @Override
    protected void onDraw(Canvas canvas) {

        Log.e("find", "===========onDraw===========" + canvas);
        Log.e("find", "===========onDraw===lastX========" + lastX);
        Log.e("find", "===========onDraw===lastlastY========" + lastY);
        canvas.drawBitmap(bitmap, distanceX, distanceY, null);

    }
}
