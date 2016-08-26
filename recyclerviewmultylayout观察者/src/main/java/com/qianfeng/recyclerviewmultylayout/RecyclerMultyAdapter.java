package com.qianfeng.recyclerviewmultylayout;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by se7en on 16/7/20.
 */
public class RecyclerMultyAdapter extends
        RecyclerView.Adapter<RecyclerMultyAdapter.BaseViewHolder>
{
    private List<BaseInfo> list;

    private Context context;

    public RecyclerMultyAdapter(Context context, List<BaseInfo> list)
    {
        this.context = context;
        this.list = list;
    }




    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View itemView = null;
        switch (viewType)
        {
            case BaseInfo.NewsTypes.NEWS_TYPE_SINGLE_LEFT:
                itemView = LayoutInflater.from(context).inflate(
                        R.layout.adapter_single_left, parent, false);
                return new SingleLeftViewHolder(itemView);

            case BaseInfo.NewsTypes.NEWS_TYPE_SINGLE_FULL:
                itemView = LayoutInflater.from(context).inflate(
                        R.layout.adapter_single_full, parent, false);
                return new SingleFullViewHolder(itemView);

            case BaseInfo.NewsTypes.NEWS_TYPE_DOUBLE:
                itemView = LayoutInflater.from(context).inflate(
                        R.layout.adapter_double, parent, false);
                return new DoubleViewHolder(itemView);

            case BaseInfo.NewsTypes.NEWS_TYPE_THREE:
                itemView = LayoutInflater.from(context).inflate(
                        R.layout.adapter_three, parent, false);
                return new ThreeViewHolder(itemView);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position)
    {
        switch (list.get(position).getType())
        {
            case BaseInfo.NewsTypes.NEWS_TYPE_SINGLE_LEFT:
                SingleLeftViewHolder singleLeftViewHolder = (SingleLeftViewHolder) holder;
                SingleLeftInfo singleLeftInfo = (SingleLeftInfo) list
                        .get(position);
                singleLeftViewHolder.tvTitle.setText(singleLeftInfo.getTitle());
                singleLeftViewHolder.tvContent.setText(singleLeftInfo
                        .getContent());
                singleLeftViewHolder.setImageUrl(R.id.iv_icon,
                        singleLeftInfo.getImgUrl());
                break;
            case BaseInfo.NewsTypes.NEWS_TYPE_SINGLE_FULL:
                SingleFullViewHolder singleFullViewHolder = (SingleFullViewHolder) holder;
                SingleFullInfo singleFulltInfo = (SingleFullInfo) list
                        .get(position);
                singleFullViewHolder.tvTitle
                        .setText(singleFulltInfo.getTitle());
                singleFullViewHolder.setImageUrl(R.id.iv_icon,
                        singleFulltInfo.getImgUrl());
                break;
            case BaseInfo.NewsTypes.NEWS_TYPE_DOUBLE:
                DoubleViewHolder doubleViewHolder = (DoubleViewHolder) holder;
                DoubleImageInfo doubleImageInfo = (DoubleImageInfo) list
                        .get(position);
                doubleViewHolder.setImageUrl(R.id.iv_icon_left,
                        doubleImageInfo.getImgLeftUrl());
                doubleViewHolder.setImageUrl(R.id.iv_icon_right,
                        doubleImageInfo.getImgRightUrl());
                break;
            case BaseInfo.NewsTypes.NEWS_TYPE_THREE:
                ThreeViewHolder threeViewHolder = (ThreeViewHolder) holder;
                ThreeImageInfo threeImageInfo = (ThreeImageInfo) list
                        .get(position);
                threeViewHolder.setImageUrl(R.id.iv_icon_left,
                        threeImageInfo.getImgLeftUrl());
                threeViewHolder.setImageUrl(R.id.iv_icon_center,
                        threeImageInfo.getImgCenterUrl());
                threeViewHolder.setImageUrl(R.id.iv_icon_right,
                        threeImageInfo.getImgRightUrl());
                break;
        }
    }

    @Override
    public int getItemCount()
    {
        return list.size();
    }

    //设置类型；
    @Override
    public int getItemViewType(int position)
    {
        return list.get(position).getType();
    }

    public class BaseViewHolder extends RecyclerView.ViewHolder
    {
        public BaseViewHolder(View itemView)
        {
            super(itemView);
        }

        public void setImageUrl(int viewId, int resId)
        {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = false;
            options.inSampleSize = 4;
            Bitmap bitmap = BitmapFactory.decodeResource(
                    context.getResources(), resId, options);
            ((ImageView) itemView.findViewById(viewId)).setImageBitmap(bitmap);
        }
    }

    public class SingleLeftViewHolder extends BaseViewHolder
    {
        public ImageView ivIcon;

        public TextView tvTitle, tvContent;

        public SingleLeftViewHolder(View itemView)
        {
            super(itemView);
            ivIcon = (ImageView) itemView.findViewById(R.id.iv_icon);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            tvContent = (TextView) itemView.findViewById(R.id.tv_content);
        }
    }

    public class SingleFullViewHolder extends BaseViewHolder
    {
        public ImageView ivIcon;

        public TextView tvTitle;

        public SingleFullViewHolder(View itemView)
        {
            super(itemView);
            ivIcon = (ImageView) itemView.findViewById(R.id.iv_icon);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }

    public class DoubleViewHolder extends BaseViewHolder
    {
        public ImageView ivIconLeft, ivIconRight;

        public DoubleViewHolder(View itemView)
        {
            super(itemView);
            ivIconLeft = (ImageView) itemView.findViewById(R.id.iv_icon_left);
            ivIconRight = (ImageView) itemView.findViewById(R.id.iv_icon_right);
        }
    }

    public class ThreeViewHolder extends BaseViewHolder
    {
        public ImageView ivIconLeft, ivIconCenter, ivIconRight;

        public ThreeViewHolder(View itemView)
        {
            super(itemView);
            ivIconLeft = (ImageView) itemView.findViewById(R.id.iv_icon_left);
            ivIconCenter = (ImageView) itemView
                    .findViewById(R.id.iv_icon_center);
            ivIconRight = (ImageView) itemView.findViewById(R.id.iv_icon_right);
        }
    }

}
