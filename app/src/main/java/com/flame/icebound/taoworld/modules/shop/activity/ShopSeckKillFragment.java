package com.flame.icebound.taoworld.modules.shop.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.flame.icebound.taoworld.R;
import com.flame.icebound.taoworld.activity.BaseFragment;
import com.flame.icebound.taoworld.modules.home.util.TostUtils;
import com.flame.icebound.taoworld.modules.shop.bean.ShopTodayInfo;
import com.flame.icebound.taoworld.modules.shop.widget.SeckKill;
import com.flame.icebound.taoworld.util.ImageLoaderUtil;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/8/2.
 */
public class ShopSeckKillFragment extends BaseFragment {

    private SeckKill seckKillLeft;
    private LinearLayout liPiontGrounp;
    private static String url = "http://img.taoshij.com";
    private SeckKill seckKillCenter;
    private SeckKill seckKillRigth;

    @Override
    protected int setLayout() {

        return R.layout.shop_seckkill_fragment;
    }

    @Override
    protected void findViews(View view) {
        seckKillLeft = (SeckKill) view.findViewById(R.id.sk_shop_seckKill_left);
        seckKillCenter = (SeckKill) view.findViewById(R.id.sk_shop_seckKill_center);
        seckKillRigth = (SeckKill) view.findViewById(R.id.sk_shop_seckKill_rigth);
        liPiontGrounp = (LinearLayout) view.findViewById(R.id.li_shop_pointGrounp);

    }

    @Override
    protected void initEvent() {
        //seckKill点击监听
        seckKillLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TostUtils.ShowTost(getActivity(),"暂未开通");

            }
        });

        seckKillCenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        seckKillRigth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    @Override
    protected void init() {
        //拿到shopFragment传过来的数据
        Bundle bundle = getArguments();
        ArrayList<ShopTodayInfo.RstBean.SeckKillBean.StockInfoBean> listSeckKill
                = (ArrayList<ShopTodayInfo.RstBean.SeckKillBean.StockInfoBean>) bundle.getSerializable("listSeckKillForFragment");

        //初始化seckKill图片
        String mUrlLeft = url + listSeckKill.get(0).getImg();
        Log.e("print", "listSeckKill=========" + listSeckKill.get(0).getBuyerName());
        Log.e("print", "listSeckKillName=========" + listSeckKill.get(0).getName());
        ImageLoader.getInstance().displayImage(mUrlLeft, seckKillLeft.getIvSeckKill(), ImageLoaderUtil.getDefaultOption());
        //初始化seckill其他信息
        seckKillLeft.getTvSeckKillDiscount().setText(listSeckKill.get(0).getDiscount());
        seckKillLeft.getTvSeckKillPriceOut().setText(listSeckKill.get(0).getPriceOut());
        seckKillLeft.getTvSeckKillOriginPrice().setText(listSeckKill.get(0).getOriginPrice());
        seckKillLeft.getTvSeckKillName().setText(listSeckKill.get(0).getName());

        //初始化seckKill图片
        String mUrlCenter = url + listSeckKill.get(1).getImg();
        ImageLoader.getInstance().displayImage(mUrlCenter, seckKillCenter.getIvSeckKill(), ImageLoaderUtil.getDefaultOption());
        //初始化seckill其他信息
        seckKillCenter.getTvSeckKillDiscount().setText(listSeckKill.get(1).getDiscount());
        seckKillCenter.getTvSeckKillPriceOut().setText(listSeckKill.get(1).getPriceOut());
        seckKillCenter.getTvSeckKillOriginPrice().setText(listSeckKill.get(1).getOriginPrice());
        seckKillCenter.getTvSeckKillName().setText(listSeckKill.get(1).getName());

        Log.e("print", "listSeckKillName=========" + listSeckKill.get(1).getName());
        //初始化seckKill图片
        String mUrlRigth = url + listSeckKill.get(2).getImg();
        ImageLoader.getInstance().displayImage(mUrlRigth, seckKillRigth.getIvSeckKill(), ImageLoaderUtil.getDefaultOption());
        //初始化seckill其他信息
        seckKillRigth.getTvSeckKillDiscount().setText(listSeckKill.get(2).getDiscount());
        seckKillRigth.getTvSeckKillPriceOut().setText(listSeckKill.get(2).getPriceOut());
        seckKillRigth.getTvSeckKillOriginPrice().setText(listSeckKill.get(2).getOriginPrice());
        seckKillRigth.getTvSeckKillName().setText(listSeckKill.get(2).getName());

    }

    @Override
    protected void loadData() {

    }
}
