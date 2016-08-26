package com.flame.icebound.taoworld.modules.home.net;

import com.flame.icebound.taoworld.modules.home.bean.ShareTopic;
import com.google.gson.Gson;

/**
 * Created by Administrator on 2016/7/30.
 */
public class ParseHomeShareInfo {

    public static ShareTopic parseHomeShareList(String str){

        Gson gson = new Gson();
        ShareTopic shareTopic = gson.fromJson(str, ShareTopic.class);

        return shareTopic;
    }
}
