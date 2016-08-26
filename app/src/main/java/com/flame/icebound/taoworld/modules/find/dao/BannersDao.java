package com.flame.icebound.taoworld.modules.find.dao;

import com.flame.icebound.taoworld.i.BaseCallBack;
import com.flame.icebound.taoworld.modules.find.bean.Banners;
import com.flame.icebound.taoworld.modules.find.util.ParseBrannersInfo;
import com.flame.icebound.taoworld.net.HttpUtil;

/**
 * viewPager图片
 * Created by hasee on 2016/7/30.
 */
public class BannersDao {
    /**
     * 获取viewPager图片数据
     */
    public static void getFindBannersViewPager(final BaseCallBack callBack) {

        HttpUtil.doHttpReqeust("GET",
                "http://221.228.216.23/v5/find/index?_atype=android&_channel=NAMTest&_saveMode=0", null,
                new BaseCallBack() {
                    @Override
                    public void success(Object data) {

                        Banners banners = ParseBrannersInfo.parseBanners(data.toString());
                        callBack.success(banners);
                    }

                    @Override
                    public void failed(int errorCode, Object data) {
                        callBack.failed(errorCode, data);
                    }
                });
    }
}
