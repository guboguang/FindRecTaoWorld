package com.flame.icebound.taoworld.modules.find.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import com.flame.icebound.taoworld.R;

/**
 * Created by hasee on 2016/7/29.
 */
public class CharacterView extends LinearLayout {


    private BrandView brandView1;
    private BrandView brandView2;
    private BrandView brandView3;
    private BrandView brandView4;

    private BrandLifeView findImageView1;
    private BrandLifeView findImageView2;
    private BrandLifeView findImageView3;
    private BrandLifeView findImageView4;
    private BrandLifeView[] brandLifeViews;

    public BrandView[] getBrandViews() {
        BrandView[] brandViews ={brandView1,brandView2,brandView3,brandView4};
        return brandViews;
    }

    public BrandLifeView[] getbrandLifeViews() {
        BrandLifeView[] brandLifeViews ={findImageView1,findImageView2,findImageView3,findImageView4};
        return brandLifeViews;
    }



    public BrandView getBrandView1() {
        return brandView1;
    }

    public BrandView getBrandView2() {
        return brandView2;
    }

    public BrandView getBrandView3() {
        return brandView3;
    }

    public BrandView getBrandView4() {
        return brandView4;
    }

    public CharacterView(Context context) {
        super(context);
        init(context,null);
    }

    public CharacterView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
    }

    private void init(Context context, AttributeSet attrs) {

        View view = View.inflate(context, R.layout.find_title_layout, this);

        brandView1 = (BrandView) view.findViewById(R.id.brand_view1);
        brandView2 = (BrandView) view.findViewById(R.id.brand_view2);
        brandView3 = (BrandView) view.findViewById(R.id.brand_view3);
        brandView4 = (BrandView) view.findViewById(R.id.brand_view4);

        findImageView1 = (BrandLifeView) view.findViewById(R.id.oneLife);
        findImageView2 = (BrandLifeView) view.findViewById(R.id.twoLife);
        findImageView3 = (BrandLifeView) view.findViewById(R.id.threeLife);
        findImageView4 = (BrandLifeView) view.findViewById(R.id.fourLife);

    }
}
