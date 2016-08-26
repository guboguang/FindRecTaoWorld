package com.flame.icebound.taoworld.modules.home.dao;

import android.util.Log;

import com.flame.icebound.taoworld.i.BaseCallBack;
import com.flame.icebound.taoworld.modules.home.bean.ShareTopic;
import com.flame.icebound.taoworld.modules.home.net.ParseHomeShareInfo;
import com.flame.icebound.taoworld.net.HttpUtil;

import java.util.HashMap;

/**
 * Created by Administrator on 2016/7/30.
 */
public class HomeDao {

    private static final String TAG = "HOMEDAO";

    public static void getShareList(String method, String url, HashMap<String,String> params, final BaseCallBack callBack){

        HttpUtil.doHttpReqeust(method, url, params, new BaseCallBack() {
            @Override
            public void success(Object data) {
                Log.e(TAG,data.toString());
                ShareTopic shareTopic = ParseHomeShareInfo.parseHomeShareList(data.toString());
                Log.e(TAG,shareTopic.getRst().getShareList().get(0).toString());
                callBack.success(shareTopic);
            }

            @Override
            public void failed(int errorCode, Object data) {
                callBack.failed(errorCode,data);
                Log.d(TAG,"失败"+data.toString());
            }
        });
    }
}
