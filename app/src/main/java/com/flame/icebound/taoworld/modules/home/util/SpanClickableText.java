package com.flame.icebound.taoworld.modules.home.util;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.text.style.UnderlineSpan;
import android.view.View;

/**
 * Created by Administrator on 2016/7/31.
 */
public class SpanClickableText extends SpannableString{


    public SpanClickableText(CharSequence source) {
        super(source);
    }


    public void setSpanForClick(Object what, int start, int end, int textColor, int flags) {
        super.setSpan(what, start, end, flags);
        //去掉可点击文字的下划线，及字体颜色
        if(textColor!=0){
            super.setSpan(new NoUnderlineSpan(textColor),start, end, flags);
        }else {
            super.setSpan(new NoUnderlineSpan(),start, end, flags);
        }
    }

    /**
     * 部分文字的点击事件响应
     */
    public class SpanTextClickListener extends ClickableSpan implements View.OnClickListener {
        private final View.OnClickListener mListener;
        public SpanTextClickListener(View.OnClickListener l) {
            mListener = l;
        }
        @Override
        public void onClick(View v) {
            mListener.onClick(v);
        }
    }

    /**
     * 取消下划线
     */
    public class NoUnderlineSpan extends UnderlineSpan {

        private  int textColor;
        public NoUnderlineSpan() {
            this.textColor = Color.GRAY;
        }
        public NoUnderlineSpan(int textColor) {
            this.textColor = textColor;
        }
        @Override

        public void updateDrawState(TextPaint ds) {

            ds.setColor(textColor);

            //设置可点击文本的字体颜色

            ds.setUnderlineText(false);

        }
    }
}
