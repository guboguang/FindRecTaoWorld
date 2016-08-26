package com.flame.icebound.taoworld.modules.find.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.flame.icebound.taoworld.R;

/**
 * Created by hasee on 2016/7/29.
 */
public class MyViewOfList extends LinearLayout {

    private ImageView imageView1;
    private TextView name;
    private TextView number;
    private ImageView imageView2;
    private ImageView imageView3;

    public ImageView getImageView1() {
        return imageView1;
    }

    public void setImageView1(ImageView imageView1) {
        this.imageView1 = imageView1;
    }

    public TextView getName() {
        return name;
    }

    public void setName(TextView name) {
        this.name = name;
    }

    public TextView getNumber() {
        return number;
    }

    public void setNumber(TextView number) {
        this.number = number;
    }

    public ImageView getImageView2() {
        return imageView2;
    }
    public ImageView getImageView3() {
        return imageView3;
    }

    public void setImageView2(ImageView imageView2) {
        this.imageView2 = imageView2;
    }
    public void setImageView3(ImageView imageView3) {
        this.imageView3 = imageView3;
    }

    public MyViewOfList(Context context) {
        super(context);
        init(context,null);
    }

    public MyViewOfList(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        View view = View.inflate(context, R.layout.find_list_custom_layout, this);

        findView(view);


    }

    private void findView(View view) {

        imageView1 = (ImageView) view.findViewById(R.id.list_picture1);
        imageView2 = (ImageView) view.findViewById(R.id.list_picture2);
        imageView3 = (ImageView) view.findViewById(R.id.list_picture3);
        name = (TextView) view.findViewById(R.id.list_tv1);
        number = (TextView) view.findViewById(R.id.list_tv2);
    }
}
