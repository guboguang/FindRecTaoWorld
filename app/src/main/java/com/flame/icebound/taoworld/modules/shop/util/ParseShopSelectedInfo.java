package com.flame.icebound.taoworld.modules.shop.util;

import com.flame.icebound.taoworld.modules.shop.bean.ShopSelectedInfo;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/31.
 */
public class ParseShopSelectedInfo {

    public static List<ShopSelectedInfo.RstBean.StockListBean> parseSelectedInfo(String result){
        List<ShopSelectedInfo.RstBean.StockListBean> list=new ArrayList<>();

        Gson gson=new Gson();

        ShopSelectedInfo shopSelectedInfo=gson.fromJson(result,ShopSelectedInfo.class);
        list=shopSelectedInfo.getRst().getStockList();


        return list;

    }
}
