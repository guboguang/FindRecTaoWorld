package com.flame.icebound.taoworld.modules.find.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import com.flame.icebound.taoworld.R;
import com.flame.icebound.taoworld.adapter.CommonAdapter;
import com.flame.icebound.taoworld.adapter.ViewHolder;
import com.flame.icebound.taoworld.modules.find.bean.FindListInfo;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hasee on 2016/7/29.
 */
public class FindListAdapter extends CommonAdapter<FindListInfo.ShareListBean> {

    private ArrayList<FindListInfo.ShareListBean> list;
    Context context;

    public FindListAdapter(Context context, List<FindListInfo.ShareListBean> mDatas, int itemLayoutId) {
        super(context, mDatas, itemLayoutId);
        this.context = context;
        this.list = (ArrayList<FindListInfo.ShareListBean>) mDatas;
    }

    @Override
    public void convert(ViewHolder helper, int position, FindListInfo.ShareListBean item) {

        FindListInfo.ShareListBean shareListBean = list.get(position*2);

        helper.setImageByUrl(R.id.list_picture4, shareListBean.getImgs());
        helper.setImageByUrlCir(R.id.list_picture5, shareListBean.getUser_head());

        helper.setText(R.id.list_tv3, shareListBean.getReview_detail());
        helper.setText(R.id.list_tv4, shareListBean.getUser_name());

        FindListInfo.ShareListBean shareListBean2 = list.get(position*2 + 1);

        helper.setImageByUrl(R.id.list_picture1, shareListBean2.getImgs());
        helper.setImageByUrlCir(R.id.list_picture2, shareListBean2.getUser_head());

        helper.setText(R.id.list_tv1, shareListBean2.getReview_detail());
        helper.setText(R.id.list_tv2, shareListBean2.getUser_name());

        final View left_view = helper.getView(R.id.myviewoflist_left);
        final View right_view = helper.getView(R.id.myviewoflist_right);

        final ImageView imageView3 = helper.getView(R.id.list_picture3);

        final ImageView imageView6 = helper.getView(R.id.list_picture6);

        right_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        left_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!imageView3.isSelected()) {

                    Intent intent = new Intent(context,DraftTest.class);
                    context.startActivity(intent);

                    imageView3.setSelected(true);
                } else {
                    imageView3.setSelected(false);
                }
            }
        });

        imageView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!imageView6.isSelected()) {
                    imageView6.setSelected(true);
                } else {
                    imageView6.setSelected(false);
                }
            }
        });


    }

}
