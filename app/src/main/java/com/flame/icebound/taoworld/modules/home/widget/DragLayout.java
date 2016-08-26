package com.flame.icebound.taoworld.modules.home.widget;

import android.content.Context;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

/**
 * Created by Administrator on 2016/7/20.
 */
public class DragLayout extends FrameLayout {

    private static final String TAG = "TAG";
    private ViewDragHelper mDragHelper;
    private int mWidth;
    private int mHeight;

    public DragLayout(Context context) {
        this(context, null);
    }

    public DragLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DragLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mDragHelper = ViewDragHelper.create(this, mCallback);
    }

    ViewDragHelper.Callback mCallback = new ViewDragHelper.Callback() {
        //尝试捕捉
        @Override
        public boolean tryCaptureView(View child, int pointerId) {
           /* //只允许Tag移动
            if(child instanceof  ImageTagView){
                return  true;
            }*/
            return false;
        }

        //尝试捕捉成功后回调
        @Override
        public void onViewCaptured(View capturedChild, int activePointerId) {
            super.onViewCaptured(capturedChild, activePointerId);

        }

        @Override
        public int getViewVerticalDragRange(View child) {
            return super.getViewVerticalDragRange(child);
        }

        //根据建议移动值，修正将要移动到的位置，此时View还没有移动，横向移动
        @Override
        public int clampViewPositionHorizontal(View child, int left, int dx) {
            return super.clampViewPositionHorizontal(child, left, dx);
        }

        //Y方向的移动
        @Override
        public int clampViewPositionVertical(View child, int top, int dy) {
            return super.clampViewPositionVertical(child, top, dy);
        }

        //changedView移动

        @Override
        public void onViewPositionChanged(View changedView, int left, int top, int dx, int dy) {
            super.onViewPositionChanged(changedView, left, top, dx, dy);
            invalidate();
        }


    };

    //传递触摸事件
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
            return mDragHelper.shouldInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mDragHelper.processTouchEvent(event);
        //持续传递
        return true;
    }

    //子控件完全添加后的回调方法，此时可以获取子控件
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
    }

    //尺寸变化的时候回调
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        //获取控件的宽高
        mWidth = getMeasuredWidth();
        mHeight = getMeasuredHeight();

    }

}
