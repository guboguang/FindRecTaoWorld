package com.qianfeng.recyclerviewmultylayout;

import android.app.Application;

import cn.jpush.android.api.JPushInterface;

/**
 * Created by se7en on 16/7/25.
 */
public class NewsApplication extends Application
{
    @Override
    public void onCreate()
    {
        super.onCreate();
        JPushInterface.init(this);
        JPushInterface.setDebugMode(true);
    }
}
