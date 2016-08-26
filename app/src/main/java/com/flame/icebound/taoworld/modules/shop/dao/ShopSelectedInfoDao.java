package com.flame.icebound.taoworld.modules.shop.dao;

import com.flame.icebound.taoworld.i.BaseCallBack;
import com.flame.icebound.taoworld.modules.shop.bean.ShopSelectedInfo;
import com.flame.icebound.taoworld.modules.shop.util.ParseShopSelectedInfo;
import com.flame.icebound.taoworld.net.HttpUtil;

import java.util.List;

/**
 * Created by Administrator on 2016/7/31.
 */
public class ShopSelectedInfoDao {
    public static void getShopSelectedInfo(int pageSelected,final BaseCallBack baseCallBack){

        String url="http://221.228.216.23/v5/index/hotBuy_v2?type=new&pageId="+pageSelected;


        HttpUtil.doHttpReqeust("GET", url, null, new BaseCallBack() {
            @Override
            public void success(Object data) {

                List<ShopSelectedInfo.RstBean.StockListBean> list = ParseShopSelectedInfo.parseSelectedInfo((String) data);

                baseCallBack.success(list);

            }

            @Override
            public void failed(int errorCode, Object data) {

                baseCallBack.failed(errorCode,data);
            }
        });

    }

}
