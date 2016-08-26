package com.flame.icebound.taoworld.modules.shop.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.flame.icebound.taoworld.R;
import com.flame.icebound.taoworld.modules.shop.bean.ShopTodayInfo;
import com.flame.icebound.taoworld.util.ImageLoaderUtil;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by Administrator on 2016/7/31.
 */
public class RecyclerviewStockAdapter extends RecyclerView.Adapter<RecyclerviewStockAdapter.BaseViewHolder> {

    List<ShopTodayInfo.RstBean.TopicListBean.StockInfoBean> list;
    Context context;
    private View itemView;
    private static String url="http://img.taoshij.com";


    public RecyclerviewStockAdapter(Context context, List<ShopTodayInfo.RstBean.TopicListBean.StockInfoBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        itemView = LayoutInflater.from(context).inflate(R.layout.shop_adapter_stock_info,parent,false);

        return new BaseViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        //将网络图片映射给itemView
        String mUrl=url+list.get(position).getImgs().get(0);
        ImageLoader.getInstance().displayImage(mUrl,holder.ivStock, ImageLoaderUtil.getDefaultOption());
        //设置其余信息
        holder.tvStockBrandName.setText(list.get(position).getBrand_name());
        holder.tvStockName.setText(list.get(position).getName());
        holder.tvStockPrice.setText("$"+list.get(position).getPriceout());
        holder.tvStockDisscountName.setText(list.get(position).getDiscountName());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class BaseViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivStock;
        private TextView tvStockBrandName;
        private TextView tvStockName;
        private TextView tvStockPrice;
        private TextView tvStockDisscountName;
        public BaseViewHolder(View itemView) {
            super(itemView);

             ivStock=(ImageView) itemView.findViewById(R.id.iv_stock);
             tvStockBrandName= (TextView) itemView.findViewById(R.id.tv_stock_brand_name);
             tvStockName= (TextView) itemView.findViewById(R.id.tv_stock_name);
             tvStockPrice= (TextView) itemView.findViewById(R.id.tv_stock_price);
             tvStockDisscountName= (TextView) itemView.findViewById(R.id.tv_stock_disscountName);
        }
    }
}
