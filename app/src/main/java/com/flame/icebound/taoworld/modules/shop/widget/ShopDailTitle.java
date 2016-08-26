package com.flame.icebound.taoworld.modules.shop.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.flame.icebound.taoworld.R;

/**
 * Created by Administrator on 2016/8/5.
 */
public class ShopDailTitle extends RelativeLayout {

    private ImageView ivShopTitleLeft;
    private ImageView ivShopTitleSecond;
    private ImageView ivShopTitleThird;
    private ImageView ivShopTitleForth;
    private ImageView ivShopTitleRigth;
    private View view;

    public ShopDailTitle(Context context) {
        super(context);
        initView(context, null);
    }

    public ShopDailTitle(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    public ImageView getIvShopTitleForth() {
        return ivShopTitleForth;
    }

    public void setIvShopTitleForth(ImageView ivShopTitleForth) {
        this.ivShopTitleForth = ivShopTitleForth;
    }

    public ImageView getIvShopTitleThird() {
        return ivShopTitleThird;
    }

    public void setIvShopTitleThird(ImageView ivShopTitleThird) {
        this.ivShopTitleThird = ivShopTitleThird;
    }

    public ImageView getIvShopTitleSecond() {
        return ivShopTitleSecond;
    }

    public void setIvShopTitleSecond(ImageView ivShopTitleSecond) {
        this.ivShopTitleSecond = ivShopTitleSecond;
    }

    public ImageView getIvShopTitleRigth() {
        return ivShopTitleRigth;
    }

    public void setIvShopTitleRigth(ImageView ivShopTitleRigth) {
        this.ivShopTitleRigth = ivShopTitleRigth;
    }

    public ImageView getIvShopTitleLeft() {
        return ivShopTitleLeft;
    }

    public void setIvShopTitleLeft(ImageView ivShopTitleLeft) {
        this.ivShopTitleLeft = ivShopTitleLeft;
    }

    private void initView(Context context, AttributeSet attrs) {
        view = View.inflate(context, R.layout.shop_titlebar, this);
        ivShopTitleLeft = (ImageView) findViewById(R.id.shop_title_left);
        ivShopTitleSecond = (ImageView) findViewById(R.id.shop_title_second);
        ivShopTitleThird = (ImageView) findViewById(R.id.shop_title_third);
        ivShopTitleForth = (ImageView) findViewById(R.id.shop_title_forth);
        ivShopTitleRigth = (ImageView) findViewById(R.id.shop_title_rigth);

    }
}
