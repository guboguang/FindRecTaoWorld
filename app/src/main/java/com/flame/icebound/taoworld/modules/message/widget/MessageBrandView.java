package com.flame.icebound.taoworld.modules.message.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.flame.icebound.taoworld.R;

/**
 * 品质生活自定义控件
 * 一个ImageView 两个TextView;
 * Created by hasee on 2016/7/29.
 */
public class MessageBrandView extends RelativeLayout {

    private ImageView imageView;
    private TextView brand_tv1;
    private TextView brand_tv2;

    public TextView getBrand_tv2() {
        return brand_tv2;
    }

    public ImageView getImageView() {
        return imageView;
    }


    public TextView getBrand_tv1() {
        return brand_tv1;
    }

    public void setBrand_tv1(TextView brand_tv1) {
        this.brand_tv1 = brand_tv1;
    }

    public void setBrand_tv2(TextView brand_tv2) {
        this.brand_tv2 = brand_tv2;
    }

    public MessageBrandView(Context context) {
        super(context);
        init(context,null);
    }

    public MessageBrandView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        View view = View.inflate(context, R.layout.message_brand_view_layout,this);
        this.findView(view);
        this.setView();
    }

    private void setView() {
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

    }

    private  void findView(View view){

        imageView = (ImageView) view.findViewById(R.id.one_picture);
        brand_tv1 = (TextView) view.findViewById(R.id.brand_tv1);
        brand_tv2 = (TextView) view.findViewById(R.id.brand_tv2);
    }
}
