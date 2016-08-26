package com.qianfeng.recyclerviewmultylayout;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import cn.jpush.android.api.JPushInterface;

/**
 * Created by se7en on 16/7/25.
 */
public class NewsReceiver extends BroadcastReceiver
{
    @Override
    public void onReceive(Context context, Intent intent)
    {
        String action = intent.getAction();
        if ("cn.jpush.android.intent.MESSAGE_RECEIVED".equals(action))
        {
            // TODO 处理服务器发送过来的通知
            Bundle bundle = intent.getExtras();
            String extras = bundle.getString(JPushInterface.EXTRA_EXTRA);
            Log.i("info", extras);
            try
            {
                JSONObject jsonObject = new JSONObject(extras);
                int type = jsonObject.getInt("type");
                BaseInfo info = null;
                switch (type)
                {
                    case BaseInfo.NewsTypes.NEWS_TYPE_SINGLE_LEFT:
                        info = new SingleLeftInfo();
                        ((SingleLeftInfo) info).setTitle(jsonObject
                                .getString("title"));
                        ((SingleLeftInfo) info).setContent(jsonObject
                                .getString("content"));
                        ((SingleLeftInfo) info).setImgUrl(R.mipmap.pic1);
                        break;
                    case BaseInfo.NewsTypes.NEWS_TYPE_SINGLE_FULL:
                        break;
                    case BaseInfo.NewsTypes.NEWS_TYPE_DOUBLE:
                        break;
                    case BaseInfo.NewsTypes.NEWS_TYPE_THREE:
                        break;
                }
                // 判断一个json字符串中是否包含key为id的键值对
                if (jsonObject.has("id"))
                {
                    info.setId(jsonObject.getString("id"));
                }
                info.setType(type);
//                EventBus.getDefault().post(info);
                //模拟网络数据中的模块类型是 Observer.Type.IMAGE
                Observer.getInstance().post(info, Observer.Type.IMAGE);
            }
            catch (JSONException e)
            {
                e.printStackTrace();
            }
        }
    }
}
