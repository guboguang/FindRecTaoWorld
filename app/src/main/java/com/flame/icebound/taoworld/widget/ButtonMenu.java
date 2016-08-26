package com.flame.icebound.taoworld.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.flame.icebound.taoworld.R;

/**
 * Created by Administrator on 2016/7/12.
 */
public class ButtonMenu extends LinearLayout {

    private int resPressId;
    private int resNormalId;
    private Fragment fragment;
    private String text;
    private ImageView ivIcon;
    private TextView tvText;

    public ButtonMenu(Context context) {
        this(context,null);
    }

    public ButtonMenu(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ButtonMenu(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs);
    }

    /**
     * 解析属性
     * @param context
     * @param attrs
     */
    private void init(Context context, AttributeSet attrs) {
        View view = View.inflate(context, R.layout.button_menu_layout,this);
        ivIcon = (ImageView) view.findViewById(R.id.iv_icon);
        tvText = (TextView) view.findViewById(R.id.tv_text);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ButtonMenu);
        resPressId = typedArray.getResourceId(R.styleable.ButtonMenu_icon_press, R.mipmap.ic_launcher);
        resNormalId = typedArray.getResourceId(R.styleable.ButtonMenu_icon_normal, R.mipmap.ic_launcher);
        text = typedArray.getString(R.styleable.ButtonMenu_text);
        //设置默认值
        tvText.setText(text);
        ivIcon.setImageResource(resNormalId);
    }

    /**
     * 选中菜单
     */
    public void selectMenu(){

        //改变文字颜色
        tvText.setTextColor(Color.RED);
        //更换图片
        ivIcon.setImageResource(resPressId);

    }

    /**
     * 取消菜单
     */
    public void unSelectMenu(){
        //改变文字颜色
        tvText.setTextColor(Color.BLACK);
        //更换图片
        ivIcon.setImageResource(resNormalId);

    }



    public void setFragment(Fragment fragment){
        this.fragment =fragment;
    }

    public Fragment getFragment() {
        return fragment;
    }
}
