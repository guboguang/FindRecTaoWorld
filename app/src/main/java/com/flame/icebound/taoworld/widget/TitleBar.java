package com.flame.icebound.taoworld.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.flame.icebound.taoworld.R;


/**
 * Created by Administrator on 2016/7/12.
 */
public class TitleBar extends RelativeLayout {

    private TextView tvTitle;
    private ImageView ivLeft;
    private ImageView ivRight;
    private RelativeLayout rlSearch;
    //定义监听器属性
    private  OnLeftImageListener onLeftImageListener;
    private  OnRightImageListener onRightImageListener;
    private  OnSearchListener onSearchListener;
    private TextView tvSearch;


    public TitleBar(Context context) {
        super(context);
    }

    public TitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
    }

    public TitleBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs);
    }

    public TextView getTvSearch() {
        return tvSearch;
    }

    /**
     * 初始化视图
     */
    private void init(Context context, AttributeSet attrs) {
        View view =View.inflate(context, R.layout.title_bar_layout,this);
        rlSearch = (RelativeLayout) view.findViewById(R.id.rl_search);
        tvTitle = (TextView) view.findViewById(R.id.tv_title);
        ivLeft = (ImageView) view.findViewById(R.id.iv_left);
        ivRight = (ImageView) view.findViewById(R.id.iv_right);
        tvSearch = (TextView) view.findViewById(R.id.tv_search);
    }

    public void setOnLeftImageListener(OnLeftImageListener onLeftImageListener) {
        this.onLeftImageListener = onLeftImageListener;
    }

    public void setOnRightImageListener(OnRightImageListener onRightImageListener) {
        this.onRightImageListener = onRightImageListener;
    }

    public void setOnSearchListener(OnSearchListener onSearchListener) {
        ivLeft.setVisibility(VISIBLE);
        tvTitle.setVisibility(GONE);
        ivRight.setVisibility(GONE);
        rlSearch.setVisibility(VISIBLE);
        this.onSearchListener = onSearchListener;


    }

    //定义监听器接口
    public  interface OnLeftImageListener{
        void click(View v);
    }
    public  interface OnRightImageListener{
        void click(View v);
    }
    public  interface OnSearchListener{
        void click(View v);
    }


    public void setTvTitle(TextView tvTitle) {
        this.tvTitle = tvTitle;
    }

    public void setIvLeft(int resId) {
        this.ivLeft.setImageResource(resId);
    }

    public void setIvRight(int resId) {
        this.ivRight.setImageResource(resId);
    }

    public TextView getTvTitle() {
        return tvTitle;
    }

    public ImageView getIvLeft() {
        return ivLeft;
    }

    public ImageView getIvRight() {
        return ivRight;
    }

    public RelativeLayout getRlSearch() {
        return rlSearch;
    }


}
