package com.flame.icebound.taoworld.modules.find.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Created by hasee on 2016/8/1.
 */
public class MyLineLayout extends LinearLayout {

    public MyLineLayout(Context context) {
        super(context);
    }

    public MyLineLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return super.onInterceptTouchEvent(ev);
    }
}
