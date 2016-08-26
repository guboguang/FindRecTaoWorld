package com.flame.icebound.taoworld.modules.shop.dao;

import com.flame.icebound.taoworld.i.BaseCallBack;
import com.flame.icebound.taoworld.modules.shop.bean.ShopTodayInfo;
import com.flame.icebound.taoworld.modules.shop.util.ParseShopTodayInfo;
import com.flame.icebound.taoworld.net.HttpUtil;

/**
 * Created by Administrator on 2016/7/30.
 */
public class ShopTodayInfoDao {

    public static void getShopTodayInfoList(final BaseCallBack baseCallBack){

        String url="http://221.228.216.23/v5/index/indexNew?_atype=android&_channel=NAMTest&_saveMode" +
                "=0&_msys=4.4.2&_app=tsj&_at=21aa7452a4993cc7&_network=2&_av=569&_fs=NAMTest100&_newdid" +
                "=b31de827e96b84c2925caebd0bc716fb&_version=5.6.9.1333&source=ANDROID_5.6.9.1333_" +
                "AMCustomer_NAMTest100&_swidth=720&_did2=1dbed48d-fe65-4a8c-a3ac-23f188b49c07&_sdklevel=19&minfo=" +
                "MI%2B2&_did=864394102875087&tid=IX-beETUTnKEUomax4ofiQ&_t=1469858909&dvid=864394102875087 ";

        HttpUtil.doHttpReqeust("GET", url, null, new BaseCallBack() {
            @Override
            public void success(Object data) {

                ShopTodayInfo shopTodayInfo = ParseShopTodayInfo.parseShopTodayInfo((String) data);

                baseCallBack.success(shopTodayInfo);

            }

            @Override
            public void failed(int errorCode, Object data) {

               baseCallBack.failed(errorCode,data);
            }
        });

    }
}
