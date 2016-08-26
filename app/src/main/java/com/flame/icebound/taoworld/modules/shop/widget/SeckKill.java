package com.flame.icebound.taoworld.modules.shop.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.flame.icebound.taoworld.R;

/**
 * Created by Administrator on 2016/8/2.
 */
public class SeckKill extends LinearLayout{

    private ImageView ivSeckKill;
    private TextView tvSeckKillDiscount;
    private TextView tvSeckKillPriceOut;
    private TextView tvSeckKillOriginPrice;
    private TextView tvSeckKillName;
    private BorderTextView tvSeckKillGoBuy;
    private View view;

    public SeckKill(Context context) {
        super(context);
        initView(context,null);
    }

    public SeckKill(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    private void initView(Context context, AttributeSet attrs) {
        view = View.inflate(context, R.layout.shop_seekkill_good,this);
        ivSeckKill = (ImageView) view.findViewById(R.id.iv_shop_seckKill);
        tvSeckKillDiscount = (TextView) view.findViewById(R.id.tv_shop_seckKill_discount);
        tvSeckKillPriceOut = (TextView) view.findViewById(R.id.tv_shop_seckKill_priceOut);
        tvSeckKillOriginPrice = (TextView) view.findViewById(R.id.tv_shop_seckKill_originPrice);
        tvSeckKillName = (TextView) view.findViewById(R.id.tv_shop_seckKill_name);
        tvSeckKillGoBuy = (BorderTextView) view.findViewById(R.id.tv_shop_seckKill_goBuy);
    }

    public ImageView getIvSeckKill() {
        return ivSeckKill;
    }

    public void setIvSeckKill(ImageView ivSeckKill) {
        this.ivSeckKill = ivSeckKill;
    }

    public TextView getTvSeckKillDiscount() {
        return tvSeckKillDiscount;
    }

    public void setTvSeckKillDiscount(TextView tvSeckKillDiscount) {
        this.tvSeckKillDiscount = tvSeckKillDiscount;
    }

    public BorderTextView getTvSeckKillGoBuy() {
        return tvSeckKillGoBuy;
    }

    public void setTvSeckKillGoBuy(BorderTextView tvSeckKillGoBuy) {
        this.tvSeckKillGoBuy = tvSeckKillGoBuy;
    }

    public TextView getTvSeckKillName() {
        return tvSeckKillName;
    }

    public void setTvSeckKillName(TextView tvSeckKillName) {
        this.tvSeckKillName = tvSeckKillName;
    }

    public TextView getTvSeckKillOriginPrice() {
        return tvSeckKillOriginPrice;
    }

    public void setTvSeckKillOriginPrice(TextView tvSeckKillOriginPrice) {
        this.tvSeckKillOriginPrice = tvSeckKillOriginPrice;
    }

    public TextView getTvSeckKillPriceOut() {
        return tvSeckKillPriceOut;
    }

    public void setTvSeckKillPriceOut(TextView tvSeckKillPriceOut) {
        this.tvSeckKillPriceOut = tvSeckKillPriceOut;
    }
}
