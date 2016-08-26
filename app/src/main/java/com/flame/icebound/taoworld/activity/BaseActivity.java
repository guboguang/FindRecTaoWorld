package com.flame.icebound.taoworld.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

/**
 * Created by se7en on 16/7/11.
 */
public abstract class BaseActivity extends FragmentActivity
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(setLayout());
        findViews();
        initEvent();
        init();
        loadData();
    }

    /**
     * 设置布局
     * 
     * @return
     */
    protected abstract int setLayout();

    /**
     * 初始化控件
     */
    protected abstract void findViews();

    /**
     * 初始化事件
     */
    protected abstract void initEvent();

    /**
     * 界面或数据的初始化
     */
    protected abstract void init();

    /**
     * 加载数据
     */
    protected abstract void loadData();
}
