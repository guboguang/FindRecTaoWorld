package com.flame.icebound.taoworld.modules.find.dao;

import com.flame.icebound.taoworld.i.BaseCallBack;
import com.flame.icebound.taoworld.modules.find.bean.HotFourCategory;
import com.flame.icebound.taoworld.modules.find.util.ParseHotFourCategoryInfo;
import com.flame.icebound.taoworld.net.HttpUtil;

import java.util.List;

/**
 * 品牌热度
 * Created by hasee on 2016/7/30.
 */
public class HotFourCategoryDao {
    /**
     * 获取游戏列表的数据
     */
    public static void getFindHotFourCategory(final BaseCallBack callBack) {

        HttpUtil.doHttpReqeust("GET",
                "http://221.228.216.23/v5/find/index?_atype=android&_channel=NAMTest&_saveMode=0", null,
                new BaseCallBack() {
                    @Override
                    public void success(Object data) {
                        List<HotFourCategory.HotFourCategoryBean> list = ParseHotFourCategoryInfo.parseFindHotFourCategory(data.toString());
                        callBack.success(list);
                    }

                    @Override
                    public void failed(int errorCode, Object data) {
                        callBack.failed(errorCode, data);
                    }
                });
    }
}
