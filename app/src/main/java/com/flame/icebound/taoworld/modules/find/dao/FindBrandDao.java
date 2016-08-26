package com.flame.icebound.taoworld.modules.find.dao;

import com.flame.icebound.taoworld.i.BaseCallBack;
import com.flame.icebound.taoworld.modules.find.bean.Brandparent;
import com.flame.icebound.taoworld.modules.find.util.ParseHotBrandInfo;
import com.flame.icebound.taoworld.net.HttpUtil;

import java.util.List;

/**
 * Created by hasee on 2016/7/30.
 */
public class FindBrandDao {
    /**
     * 获取品牌热度
     */
    public static void getFindBrandList(final BaseCallBack callBack) {

        HttpUtil.doHttpReqeust("GET",
                "http://221.228.216.23/v5/find/index?_atype=android&_channel=NAMTest&_saveMode=0", null,
                new BaseCallBack() {
                    @Override
                    public void success(Object data) {
                        Brandparent brandparent= ParseHotBrandInfo.parseFindBrandList(data.toString());
                        List<Brandparent.BrandInfo> list = brandparent.getList();
                        callBack.success(list);
                    }

                    @Override
                    public void failed(int errorCode, Object data) {
                        callBack.failed(errorCode, data);
                    }
                });
    }
}
