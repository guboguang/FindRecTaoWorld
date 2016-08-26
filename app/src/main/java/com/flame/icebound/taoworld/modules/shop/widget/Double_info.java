package com.flame.icebound.taoworld.modules.shop.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.flame.icebound.taoworld.R;

/**
 * Created by Administrator on 2016/7/30.
 */
public class Double_info extends RelativeLayout {

    private View view;
    private ImageView doubleImg;
    private TextView doubleName;
    private TextView doublePrice;
    private TextView doubleCollection;
    private TextView doublePace;
    private Paint paint;
    private ImageView doubleCountryImg;

    public Double_info(Context context, AttributeSet attrs) {
        super(context, attrs);

        initview(context, attrs);
    }

    public ImageView getDoubleCountryImg() {
        return doubleCountryImg;
    }

    public void setDoubleCountryImg(ImageView doubleCountryImg) {
        this.doubleCountryImg = doubleCountryImg;
    }

    private void initview(Context context, AttributeSet attrs) {

        view = View.inflate(context, R.layout.double_info,this);
        doubleImg = (ImageView) findViewById(R.id.double_img);
        doubleName = (TextView) findViewById(R.id.double_name);
        doublePrice = (TextView) findViewById(R.id.double_price);
        doubleCollection = (TextView) findViewById(R.id.double_collection);
        doublePace = (TextView) findViewById(R.id.double_place);
        doubleCountryImg = (ImageView) findViewById(R.id.double_countryImg);

        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.RED);


    }

    @Override
    protected void onDraw(Canvas canvas) {


        measure(0, 0);
        canvas.drawRect(0,0,getMeasuredWidth(),getMeasuredHeight(),paint);
        super.onDraw(canvas);
    }

    public TextView getDoublePrice() {
        return doublePrice;
    }

    public void setDoublePrice(TextView doublePrice) {
        this.doublePrice = doublePrice;
    }

    public TextView getDoublePace() {
        return doublePace;
    }

    public void setDoublePace(TextView doublePace) {
        this.doublePace = doublePace;
    }

    public TextView getDoubleName() {
        return doubleName;
    }

    public void setDoubleName(TextView doubleName) {
        this.doubleName = doubleName;
    }

    public ImageView getDoubleImg() {
        return doubleImg;
    }

    public void setDoubleImg(ImageView doubleImg) {
        this.doubleImg = doubleImg;
    }

    public TextView getDoubleCollection() {
        return doubleCollection;
    }

    public void setDoubleCollection(TextView doubleCollection) {
        this.doubleCollection = doubleCollection;
    }






}
