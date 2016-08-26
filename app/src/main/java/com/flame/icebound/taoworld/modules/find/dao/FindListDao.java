package com.flame.icebound.taoworld.modules.find.dao;

import com.flame.icebound.taoworld.i.BaseCallBack;
import com.flame.icebound.taoworld.modules.find.bean.FindListInfo;
import com.flame.icebound.taoworld.modules.find.util.ParseFindListInfo;
import com.flame.icebound.taoworld.net.HttpUtil;

import java.util.HashMap;
import java.util.List;

/**
 * listView详情
 * Created by hasee on 2016/7/30.
 */
public class FindListDao {
    /**
     * 获取游戏列表的数据
     */
    public static void getFindList(int page,final BaseCallBack callBack)
    {
        HashMap<String, String> params = null;
        //params.put("platform", "2");
        //params.put("page", page + "");
        HttpUtil.doHttpReqeust("GET",
                "http://221.228.216.23/user/hotShare/list?pageId="+page, params,
                new BaseCallBack()
                {
                    @Override
                    public void success(Object data)
                    {
                        FindListInfo findListInfo = ParseFindListInfo.parseFindList(data.toString());
                        List<FindListInfo.ShareListBean> list= findListInfo.getShareList();
                        callBack.success(list);
                    }

                    @Override
                    public void failed(int errorCode, Object data)
                    {
                        callBack.failed(errorCode, data);
                    }
                });
    }
}
