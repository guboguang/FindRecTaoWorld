package com.flame.icebound.taoworld.modules.home.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.flame.icebound.taoworld.modules.home.bean.ImageTagInfo;

/**
 * Created by Administrator on 2016/8/1.
 */
public class ImageTagView extends RelativeLayout {


    private float moveDis = 80.0f;
    //图形距离边界的距离
    private float edge = 6.0f;
    //白色边的大小
    private float edgeDis = 8.0f;
    //点的半径
    private float paintR = 3.0f;
    private float centerR = 15.0f;
    private float centerX = edge + centerR;
    private float centerY = edge + moveDis;
    /**
     * 画笔和路径
     */
    private Paint mPaint;
    private Path path;
    private ImageTagInfo mTag;
    private OnClickIamgeTagListener mListener;
    private Paint mTextPaint;
    //三个子控件
    private TextView mBrand;
    private TextView mLocation;
    private TextView mPrice;
    //子控件的位置
    private RectF mBrandRect;
    private RectF mLocationRect;
    private RectF mPriceRect;
    //定义path路径，确定可触摸点
    private Path mPath = new Path();
    //可拖拽区域矩形
    private RectF mTouchRect;
    private int mHeight;
    private int mWith;
    //是否可以拖拽
    private boolean isDragable;
    private int downX;
    private int downY;

    /**
     * 定义回调监听
     */
    public interface OnClickIamgeTagListener {
        //点击品牌
        void onClickBrand();

        //点击了位置
        void onClickLocation();
    }

    public ImageTagView(Context context) {
        this(context, null);
    }

    public ImageTagView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ImageTagView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPain();
    }



    public void setImageTag(ImageTagInfo tag, OnClickIamgeTagListener clickIamgeTagListener) {
        this.mTag = tag;
        this.mListener = clickIamgeTagListener;
        mBrand.setText(mTag.getName());
        mLocation.setText(mTag.getLocation());
        mPrice.setText(mTag.getPrice());
        //通知绘制
//        invalidate();
    }

    public void setImageTag(ImageTagInfo tag) {
        this.setImageTag(tag, null);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //执行拖拽事件
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                //记录手指点下的位置
                downX = (int) event.getRawX();
                downY = (int) event.getRawY();
                break;
            case MotionEvent.ACTION_MOVE:
                int x = (int)event.getRawX();
                int y = (int)event.getRawY();
                if(isInThouchREct(x,y)){
                    int distanceX = x - downX;
                    int distanceY = y - downY;
                    // 更改圆心中心位置
                    centerX+=distanceX;
                    centerY+=distanceY;
                }
                // 获取移动后的位置
                downX = (int) event.getRawX();
                downY = (int) event.getRawY();
                invalidate();
                break;
        }
        //持续传递触摸事件
        return true;

    }

    /**
     * 判断触摸点是否在可拖拽范围内
     *
     * @param x
     * @param y
     * @return
     */
    private boolean isInThouchREct(float x, float y) {
        if (x > mTouchRect.left && x < mTouchRect.right && y > mTouchRect.top && y < mTouchRect.bottom) {
            return true;
        }
        return false;
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mBrand = (TextView) getChildAt(0);
        mLocation = (TextView) getChildAt(1);
        mPrice = (TextView) getChildAt(2);

        Log.e("print", "onFinishInflate");
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mHeight = getMeasuredHeight();
        mWith = getMeasuredWidth();
        if (mTag != null) {
            centerX = (float) (mWith * mTag.getPosition().getX());
            centerY = (float) (mHeight * mTag.getPosition().getY());
        }
    }

    /**
     * 初始化画笔
     */
    private void initPain() {
        mPaint = new Paint();

        mPaint.setAntiAlias(true);
        mPaint.setDither(true);
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(1);
        path = new Path();
        //绘制字体画笔
        mTextPaint = new Paint();
        mTextPaint.setAntiAlias(true);
        mTextPaint.setDither(true);
        mTextPaint.setColor(Color.WHITE);
        mTextPaint.setStyle(Paint.Style.STROKE);
        mTextPaint.setStrokeWidth(2);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        threePaint(canvas);
        Log.e("print", "onDraw");
        if (mTag != null) {
            if (!TextUtils.isEmpty(mTag.getPrice()) && !TextUtils.isEmpty(mTag.getLocation()) && !
                    TextUtils.isEmpty(mTag.getName())) {
                //三个选项
                threePaint(canvas);
                //设置三个点的可触摸路径
                mTouchRect = new RectF(centerX, centerY - moveDis, mWith, centerY + moveDis);

            } else if (TextUtils.isEmpty(mTag.getPrice()) && TextUtils.isEmpty(mTag.getLocation())) {
                //一个点
                mBrandRect = drawText(mTag.getName(), centerX + centerR + 3 + edge, centerY);
                mTouchRect = new RectF(centerX, centerY - mBrand.getHeight() / 2, mWith, centerY + mBrand.getHeight() / 2);
            } else {
                //两个点
                twoPaint(canvas);
                mTouchRect = new RectF(centerX, centerY - moveDis / 2, mWith, centerY + moveDis / 2);
            }
        }
        //画中心的圆
        drawCerterCircle(canvas);

        layoutContent();
    }

    /**
     * 设置三个点时的路径
     */
    private void setThreePointPath() {
        //矩形的左上点
        mPath.moveTo(centerX, centerY - moveDis);
        //左下点
        mPath.lineTo(centerX, centerY + 2 * moveDis);
        //右下点
        mPath.lineTo(mWith, centerY + 2 * moveDis);
        //右上点
        mPath.lineTo(mWith, centerY - moveDis);
    }

    private void drawCerterCircle(Canvas canvas) {
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.WHITE);
        canvas.drawCircle(centerX, centerY, centerR + edgeDis, mPaint);
        mPaint.setColor(Color.parseColor("#aaff0000"));
        canvas.drawCircle(centerX, centerY, centerR, mPaint);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.BLACK);
    }

    private void layoutContent() {
        //位置参数不为空，则重新摆放控件
        if (mBrandRect != null) {
            Log.e("print", "layoutContent");
            int l = (int) mBrandRect.left;
            int t = (int) mBrandRect.top - mBrand.getHeight() / 2;
            int r = l + mBrand.getWidth();
            int b = t + mBrand.getHeight();

            Log.e("layout", "l=" + l);
            Log.e("layout", "t=" + t);
            Log.e("layout", "r= " + r);
            Log.e("layout", "b= " + b);

            mBrand.layout(l, t, r, b);
        }


        if (mLocationRect != null) {
            int l = (int) mLocationRect.left;
            int t = (int) mLocationRect.top - mLocation.getHeight() / 2;
            int r = l + mLocation.getWidth();
            int b = t + mLocation.getHeight();

            Log.e("layout", "mLocation");
            Log.e("layout", "l=" + l);
            Log.e("layout", "t=" + t);
            Log.e("layout", "r= " + r);
            Log.e("layout", "b= " + b);

            mLocation.layout(l, t, r, b);
        }

        if (mPriceRect != null) {
            int l = (int) mPriceRect.left;
            int t = (int) mPriceRect.top - mPrice.getHeight() / 2;
            int r = l + mPrice.getWidth();
            int b = t + mPrice.getHeight();
            mPrice.layout(l, t, r, b);
        }


    }

    /**
     * 绘制两个点
     *
     * @param canvas
     */
    private void twoPaint(Canvas canvas) {
        //上部分
        initPath();
        path.lineTo(centerX + moveDis / 2, centerY - moveDis / 2);
        path.lineTo(centerX + moveDis, centerY - moveDis / 2);
        canvas.drawPath(path, mPaint);
        //或空心点
        canvas.drawCircle(centerX + moveDis + paintR, centerY - moveDis / 2, paintR, mPaint);
        mBrandRect = drawText(mTag.getName(), centerX + moveDis + 2 * paintR + edge, centerY - moveDis / 2);

        //下部分
        initPath();
        path.lineTo(centerX + moveDis / 2, centerY + moveDis / 2);
        path.lineTo(centerX + moveDis, centerY + moveDis / 2);
        canvas.drawPath(path, mPaint);
        //或空心点
        canvas.drawCircle(centerX + moveDis + paintR, centerY + moveDis / 2, paintR, mPaint);
        if (TextUtils.isEmpty(mTag.getPrice())) {
            mLocationRect = drawText(mTag.getLocation(), centerX + moveDis + 2 * paintR + edge, centerY + moveDis / 2);
        } else {
            mPriceRect = drawText(mTag.getPrice(), centerX + moveDis + 2 * paintR + edge, centerY + moveDis / 2);
        }
    }

    private void threePaint(Canvas canvas) {
        Log.e("print", "threePaint");
        //上部分
        initPath();
        path.lineTo(centerX, centerY - moveDis);
        path.lineTo(centerX + moveDis, centerY - moveDis);
        canvas.drawPath(path, mPaint);
        //或空心点
        canvas.drawCircle(centerX + moveDis + paintR, centerY - moveDis, paintR, mPaint);
        //绘制文本
        mBrandRect = drawText(mTag.getName(), centerX + moveDis + 2 * paintR + edge, centerY - moveDis);

        //中间部分
        initPath();
        path.lineTo(centerX + moveDis, centerY);
        canvas.drawPath(path, mPaint);
        canvas.drawCircle(centerX + moveDis + paintR, centerY, paintR, mPaint);
        //绘制文本
        mLocationRect = drawText(mTag.getLocation(), centerX + moveDis + 2 * paintR + edge, centerY);
        //下部分
        initPath();
        path.lineTo(centerX, centerY + moveDis);
        path.lineTo(centerX + moveDis, centerY + moveDis);
        canvas.drawPath(path, mPaint);
        //或空心点
        canvas.drawCircle(centerX + moveDis + paintR, centerY + moveDis, paintR, mPaint);

        //绘制文本
        mPriceRect = drawText(mTag.getPrice(), centerX + moveDis + 2 * paintR + edge, centerY + moveDis);

    }


    private RectF drawText(String name, float x, float y) {
        // 获取文本的高度
        Rect bounds = new Rect();// 矩形
        mPaint.getTextBounds(name, 0, name.length(), bounds);
        int textHeight = bounds.height();
        return new RectF(x, y, 0, 0);

    }

    private void initPath() {
        path.reset();
        path.moveTo(centerX, centerY);
    }

    public void setDragable(boolean dragable) {
        isDragable = dragable;
    }
}
