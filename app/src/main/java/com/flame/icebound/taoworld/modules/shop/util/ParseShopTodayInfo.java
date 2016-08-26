package com.flame.icebound.taoworld.modules.shop.util;

import com.flame.icebound.taoworld.modules.shop.bean.ShopTodayInfo;
import com.google.gson.Gson;

/**
 * Created by Administrator on 2016/7/31.
 */
public class ParseShopTodayInfo {

    public static ShopTodayInfo parseShopTodayInfo(String result){


        Gson gson=new Gson();

        ShopTodayInfo shopTodayInfo=gson.fromJson(result,ShopTodayInfo.class);


        return shopTodayInfo;

    }
}
