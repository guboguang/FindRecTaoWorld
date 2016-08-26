package com.flame.icebound.taoworld.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



/**
 * Created by se7en on 16/7/11.
 */
public abstract class BaseFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(setLayout(), container, false);
        findViews(view);
        initEvent();
        init();
        loadData();
        return view;
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
    protected abstract void findViews(View view);

    /**
     * 初始化事件
     */
    protected abstract void initEvent();

    /**
     * 界面或数据的初始化
     */
    protected abstract void init() ;

    /**
     * 加载数据
     */
    protected abstract void loadData();
}
