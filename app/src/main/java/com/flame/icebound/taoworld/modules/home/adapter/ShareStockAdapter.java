package com.flame.icebound.taoworld.modules.home.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.flame.icebound.taoworld.R;
import com.flame.icebound.taoworld.modules.home.bean.ShareTopic;
import com.flame.icebound.taoworld.modules.home.i.HomeProtocol;
import com.flame.icebound.taoworld.modules.home.util.TostUtils;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

public class ShareStockAdapter extends BaseAdapter {
  
    private List<ShareTopic.RstBean.ShareListBean.ShareStockListBean> mList;
    private LayoutInflater inflater;
    private int itemCount = HomeProtocol.STOCK_DEF_COUNT;
  private Context mContext;
    public ShareStockAdapter(Context context, List<ShareTopic.RstBean.ShareListBean.ShareStockListBean> list) {
        this.mList = list;
        this.mContext=context;
        inflater = LayoutInflater.from(context);  
    }  
  
    @Override  
    public int getCount() {  
        // 这里是关键  
        // 如果数据数量大于1，只显示1条数据。这里数量自己定义。
        // 否则，显示全部数量。  
        if (mList.size() > itemCount)
        {  
            return itemCount;  
        }else   
        {  
            return mList.size();
        }  
    }  
  
    @Override  
    public Object getItem(int position) {  
        return mList.get(position);
    }  
  
    @Override  
    public long getItemId(int position) {  
        return position;  
    }  
  
    @Override  
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;  
        if (convertView == null) {
            viewHolder = new ViewHolder();  
            convertView = inflater.inflate(R.layout.item_home_stock, null);
            viewHolder.tvStockName = (TextView) convertView.findViewById(R.id.tv_stock_name);
            viewHolder.tvStockPrice= (TextView) convertView.findViewById(R.id.tv_stock_price);
            viewHolder.ivIcon= (ImageView) convertView.findViewById(R.id.iv_icon);
            convertView.setTag(viewHolder);  
        }else   
        {  
            viewHolder = (ViewHolder) convertView.getTag();  
        }
        //获取分享商品
        ShareTopic.RstBean.ShareListBean.ShareStockListBean shareStock = mList.get(position);
        final ShareTopic.RstBean.ShareListBean.ShareStockListBean.StockInfoBean stockInfo = shareStock.getStockInfo();
        //名称
        viewHolder.tvStockName.setText(stockInfo.getName());
        Log.e(HomeProtocol.TAG,"StockName="+ viewHolder.tvStockName.getText().toString());
        //价格
        viewHolder.tvStockPrice.setText(stockInfo.getPriceout_unit()+stockInfo.getPriceout());
        //图片
        ImageLoader.getInstance().displayImage(HomeProtocol.IMGURL+stockInfo.getImg(),viewHolder.ivIcon);
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TostUtils.ShowTost(mContext,"StockName="+stockInfo.getName());
            }
        });
//        convertView.invalidate();
        return convertView;  
    }  
      
    class ViewHolder  
    {  
        TextView tvStockName;
        TextView tvStockPrice;
        ImageView ivIcon;
    }
      
    /** 
     * 点击后设置Item的数量 
     * @param number 
     */  
    public void addItemNum(int number)  
    {  
        itemCount = number;  
    }  
}  