package com.flame.icebound.taoworld.modules.shop.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * Created by Administrator on 2016/8/3.
 */
public class MyGirdView extends GridView {
    public MyGirdView(Context context) {
        super(context);
    }

    public MyGirdView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthSpec, int heightSpec) {

        int expandSpec=MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,MeasureSpec.AT_MOST);
        super.onMeasure(widthSpec, expandSpec);
    }
}
