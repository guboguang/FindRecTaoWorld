package com.flame.icebound.taoworld.modules.shop.dao;

import com.flame.icebound.taoworld.i.BaseCallBack;
import com.flame.icebound.taoworld.modules.shop.bean.SortGoods;
import com.flame.icebound.taoworld.modules.shop.util.ParseShopSortInfo;
import com.flame.icebound.taoworld.net.HttpUtil;

/**
 * Created by Administrator on 2016/8/3.
 */
public class ShopSortInfoDao {

    public static void getSortGoodsList(final BaseCallBack baseCallBack){

        String url="http://221.228.216.23/v5/index/category_v1";
        HttpUtil.doHttpReqeust("GET", url, null, new BaseCallBack() {
            @Override
            public void success(Object data) {
                SortGoods sortGoods= ParseShopSortInfo.parseShopSortInfo((String) data);
                baseCallBack.success(sortGoods);
            }

            @Override
            public void failed(int errorCode, Object data) {

                baseCallBack.failed(errorCode,data);
            }
        });

    }
}
