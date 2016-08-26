package com.flame.icebound.taoworld.modules.shop.util;

import com.flame.icebound.taoworld.modules.shop.bean.SortGoods;
import com.google.gson.Gson;

/**
 * Created by Administrator on 2016/8/3.
 */
public class ParseShopSortInfo {

    public static SortGoods parseShopSortInfo(String result){

        Gson gson=new Gson();
        SortGoods sortGoods=gson.fromJson(result,SortGoods.class);

        return sortGoods;
    }
}
