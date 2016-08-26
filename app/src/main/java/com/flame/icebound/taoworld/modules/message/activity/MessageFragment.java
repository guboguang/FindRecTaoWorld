package com.flame.icebound.taoworld.modules.message.activity;

import android.view.View;
import android.widget.ImageView;

import com.flame.icebound.taoworld.R;
import com.flame.icebound.taoworld.activity.BaseFragment;
import com.flame.icebound.taoworld.modules.message.widget.MessageBrandView;

/**
 * Created by Administrator on 2016/7/29.
 */
public class MessageFragment extends BaseFragment {


    private MessageBrandView exercise;
    private MessageBrandView order;
    private MessageBrandView community;
    private ImageView image;

    @Override
    protected int setLayout() {
        return R.layout.message_fragment_layout;
    }

    @Override
    protected void findViews(View view) {

        exercise = (MessageBrandView) view.findViewById(R.id.exercise);
        order = (MessageBrandView) view.findViewById(R.id.order);
        community = (MessageBrandView) view.findViewById(R.id.community);

    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void init() {

        exercise.getImageView().setImageResource(R.drawable.icon_im_activity);
        order.getImageView().setImageResource(R.drawable.icon_im_social);
        community.getImageView().setImageResource(R.drawable.icon_im_trade);
        exercise.getBrand_tv1().setText("消息");
        exercise.getBrand_tv2().setText("羞答答的腮红涂在脸上，增加你的少女感");
        order.getBrand_tv1().setText("订单");
        order.getBrand_tv2().setText("您近期还没有订单消息");
        community.getBrand_tv1().setText("社区");
        community.getBrand_tv2().setText("您还没有分享消息");


    }

    @Override
    protected void loadData() {

    }
}
