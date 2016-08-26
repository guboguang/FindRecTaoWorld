package com.flame.icebound.taoworld.modules.find.widget;

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
public class BrandLifeView extends RelativeLayout {

    private ImageView imageView;
    private TextView brand_tv1;

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public void setStringTv1(String tv1) {
        brand_tv1.setText(tv1);
    }

    public BrandLifeView(Context context) {
        super(context);
        init(context,null);
    }

    public BrandLifeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        View view = View.inflate(context, R.layout.hot_four_category_layout,this);
        this.findView(view);
        this.setView();
    }

    private void setView() {
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

    }

    private  void findView(View view){
        imageView = (ImageView) view.findViewById(R.id.category_one);
        brand_tv1 = (TextView) view.findViewById(R.id.life);
    }
}
