package com.flame.icebound.taoworld.modules.shop.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.flame.icebound.taoworld.R;
import com.flame.icebound.taoworld.modules.find.adapter.CommonAdapter;
import com.flame.icebound.taoworld.modules.find.adapter.ViewHolder;
import com.flame.icebound.taoworld.modules.shop.bean.BaseItemInfo;
import com.flame.icebound.taoworld.modules.shop.bean.DoubleGoodsInfo;
import com.flame.icebound.taoworld.modules.shop.bean.ShopTodayInfo;
import com.flame.icebound.taoworld.modules.shop.bean.SortGoods;
import com.flame.icebound.taoworld.modules.shop.bean.SortItemInfo;
import com.flame.icebound.taoworld.modules.shop.bean.TextItemInfo;
import com.flame.icebound.taoworld.modules.shop.widget.Double_info;
import com.flame.icebound.taoworld.modules.shop.widget.MyGirdView;
import com.flame.icebound.taoworld.util.ImageLoaderUtil;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by Administrator on 2016/7/30.
 */
public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.BaseViewHolder> {

    public static final int TYPE_HEADER = 8;  //说明是带有Header的
    public static final int TYPE_FOOTER = 9;  //说明是带有Footer的
   // public static final int TYPE_NORMAL = 10;  //说明是不带有header和footer的

    private List<BaseItemInfo> list;
    private Context context;
    private View itemView;
    private static String url = "http://img.taoshij.com";
    private RecyclerviewStockAdapter mAdapter;
    private String mUrl;
    //设置头部，footer
    private View mHeaderView;
    private View mFooterView;

    public View getmHeaderView() {
        return mHeaderView;
    }

    public void setmHeaderView(View mHeaderView) {
        this.mHeaderView = mHeaderView;
        notifyItemInserted(0);
    }

    public View getmFooterView() {
        return mFooterView;
    }

    public void setmFooterView(View mFooterView) {
        this.mFooterView = mFooterView;
        notifyItemInserted(getItemCount()-1);
    }

    public RecyclerviewAdapter(Context context, List<BaseItemInfo> list) {
        this.context = context;
        this.list = list;
    }

    //根据不同类型Type,设置不同item条目的布局文件
    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case TYPE_HEADER://如果有头部则创建头部视图
                if(mHeaderView!=null&&viewType==TYPE_HEADER){
                    return new BaseViewHolder(mHeaderView);
                }

            case TYPE_FOOTER://如果有尾部则创建尾部视图
                if(mFooterView!=null&&viewType==TYPE_FOOTER){
                    return new BaseViewHolder(mFooterView);
                }

            case BaseItemInfo.ShopTpyes.SHOP_TYPE_TODAY:
                itemView = LayoutInflater.from(context).inflate(R.layout.shop_adapter_today_info, parent, false);

                return new ShopTodayViewHolder(itemView);
            case BaseItemInfo.ShopTpyes.SHOP_TYPE_DOUBLE:

                itemView = LayoutInflater.from(context).inflate(R.layout.shop_adapter_double_info, null, false);

                return new DoubleViewHolder(itemView);

            case BaseItemInfo.ShopTpyes.SHOP_TYPE_SINGLE_TEXT:

                itemView = LayoutInflater.from(context).inflate(R.layout.shop_adapter_text_info, null, false);
                return new TextViewHolder(itemView);

            case BaseItemInfo.ShopTpyes.SHOP_TYPE_SORT:

                itemView=LayoutInflater.from(context).inflate(R.layout.shop_adapter_sort_info,null,false);

                return new SortViewHolder(itemView);
        }


        return null;
    }

    //给每个item设置值，通过viewholer
    @Override
    public void onBindViewHolder(final BaseViewHolder holder, int position) {
        if(getItemViewType(position)==TYPE_HEADER||getItemViewType(position)==TYPE_FOOTER){
            return;
        }else {

            switch (getItemViewType(position)) {

                case BaseItemInfo.ShopTpyes.SHOP_TYPE_TODAY:
                    ShopTodayViewHolder todayHolder = (ShopTodayViewHolder) holder;
                    //将网络图片设置到itemView中

                        ShopTodayInfo.RstBean.TopicListBean topicListBean = (ShopTodayInfo.RstBean.TopicListBean) list.get(position - 1);
                        mUrl = url + topicListBean.getImg();
                        ImageLoader.getInstance().displayImage(mUrl, todayHolder.iv, ImageLoaderUtil.getDefaultOption());

                        //初始化itemView里Recyclerview
                        List<ShopTodayInfo.RstBean.TopicListBean.StockInfoBean> stockList = topicListBean.getStockInfo();
                        mAdapter = new RecyclerviewStockAdapter(context, stockList);
                        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
                        layoutManager.setOrientation(OrientationHelper.HORIZONTAL);
                        todayHolder.todayRecyclerView.setLayoutManager(layoutManager);
                        todayHolder.todayRecyclerView.setAdapter(mAdapter);

                        //initEvent()


                    break;
                case BaseItemInfo.ShopTpyes.SHOP_TYPE_DOUBLE:
                    DoubleViewHolder doubleViewHolder = (DoubleViewHolder) holder;
                    //获取stockListBean对象，得到里面数据
                    DoubleGoodsInfo doubleGoodsInfo = (DoubleGoodsInfo) list.get(position-1);
                    //获取图片路径
                    mUrl = url + doubleGoodsInfo.getLeftStockListBean().getImgs().get(0);

                    //初始化左边视图 doubleViewHolder.doubleLeft.getDoubleImg()为自定控件里的ImageView
                    ImageLoader.getInstance().displayImage(mUrl, doubleViewHolder.doubleLeft.getDoubleImg(), ImageLoaderUtil.getDefaultOption());
                    //商品名字
                    doubleViewHolder.doubleLeft.getDoubleName().setText(doubleGoodsInfo.getLeftStockListBean().getName());
                    //商品价格
                    doubleViewHolder.doubleLeft.getDoublePrice().setText(doubleGoodsInfo.getLeftStockListBean().getPriceout());
                    doubleViewHolder.doubleLeft.getDoubleCollection().setText("收藏" + doubleGoodsInfo.getLeftStockListBean().getSold_amount());
                    doubleViewHolder.doubleLeft.getDoublePace().setText(doubleGoodsInfo.getLeftStockListBean().getCountry_name());
                    //设置国家小国旗图片
                    String countryImgLeft = url + doubleGoodsInfo.getLeftStockListBean().getCountry_flag();
                    ImageLoader.getInstance().displayImage(countryImgLeft, doubleViewHolder.doubleLeft.getDoubleCountryImg(), ImageLoaderUtil.getDefaultOption());

                    //初始化右边边视图，需判断listsize()为奇数时doubleGoodsInfo是否有RigthStockListBean
                    if (doubleGoodsInfo.getRigthStockListBean() != null) {

                        //获取图片路径
                        mUrl = url + doubleGoodsInfo.getRigthStockListBean().getImgs().get(0);

                        //初始化右边边视图 doubleViewHolder.doubleLeft.getDoubleImg()为自定控件里的ImageView
                        ImageLoader.getInstance().displayImage(mUrl, doubleViewHolder.doubleRigth.getDoubleImg(), ImageLoaderUtil.getDefaultOption());
                        //商品名字
                        doubleViewHolder.doubleRigth.getDoubleName().setText(doubleGoodsInfo.getRigthStockListBean().getName());
                        //商品价格
                        doubleViewHolder.doubleRigth.getDoublePrice().setText(doubleGoodsInfo.getRigthStockListBean().getPriceout());
                        doubleViewHolder.doubleRigth.getDoubleCollection().setText("收藏" + doubleGoodsInfo.getRigthStockListBean().getSold_amount());
                        doubleViewHolder.doubleRigth.getDoublePace().setText(doubleGoodsInfo.getRigthStockListBean().getCountry_name());
                        //设置国家小国旗图片
                        String countryImgRigth = url + doubleGoodsInfo.getRigthStockListBean().getCountry_flag();
                        ImageLoader.getInstance().displayImage(countryImgRigth, doubleViewHolder.doubleRigth.getDoubleCountryImg(), ImageLoaderUtil.getDefaultOption());

                    }
                    break;
                case BaseItemInfo.ShopTpyes.SHOP_TYPE_SINGLE_TEXT:

                    TextViewHolder textViewHolder = (TextViewHolder) holder;
                    TextItemInfo textItemInfo = (TextItemInfo) list.get(position-1);
                    textViewHolder.textLeft.setText(textItemInfo.getLeftText());
                    textViewHolder.textRigth.setText(textItemInfo.getRigthText());

                    break;
                case BaseItemInfo.ShopTpyes.SHOP_TYPE_SORT:
                    SortViewHolder sortViewHolder = (SortViewHolder) holder;
                    SortItemInfo sortItemInfo = (SortItemInfo) list.get(position-1);

                    //图片展示
                    if(sortItemInfo.getGroupBuyingBean()!=null){
                        mUrl = url + sortItemInfo.getGroupBuyingBean().getImage_path();
                        ImageLoader.getInstance().displayImage(mUrl, sortViewHolder.ivSort, ImageLoaderUtil.getDefaultOption());

                    }else{
                        sortViewHolder.ivSort.setVisibility(View.GONE);
                    }

                    final List<SortGoods.RstBean> RstBeanlist = sortItemInfo.getSortGoods().getRst();
                    CommonAdapter<SortGoods.RstBean> mGirdAdapter = new CommonAdapter<SortGoods.RstBean>(context, RstBeanlist, R.layout.shop_adapter_for_sort_girdview) {

                        @Override
                        public void convert(ViewHolder helper, int position, SortGoods.RstBean item) {

                            SortGoods.RstBean rstBean = RstBeanlist.get(position);
                            helper.setImageByUrl(R.id.iv_sort_gridview, url + rstBean.getImage_path());
                            helper.setText(R.id.tv_sort_onetitle, rstBean.getOneTitle());
                            helper.setText(R.id.tv_sort_content, rstBean.getText_content());
                        }
                    };

                    sortViewHolder.gvSort.setAdapter(mGirdAdapter);

                    break;

            }
        }

    }

    @Override
    public int getItemCount() {

        if(mHeaderView!=null&&mFooterView!=null){
            return  list.size()+2;
        }
        if(mHeaderView!=null&&mFooterView==null){
            return list.size()+1;
        }
        if(mFooterView!=null&&mHeaderView==null){
            return list.size()+1;
        }else {
            return list.size();
        }

    }

    //根据list位置设置item条目类型
    @Override
    public int getItemViewType(int position) {

        if(mHeaderView==null&&mFooterView==null){
            return list.get(position-1).getType();
        }
        if(position==0){
            return TYPE_HEADER;
        }
        if(position==getItemCount()-1){
            return TYPE_FOOTER;
        }

        return list.get(position-1).getType();
    }

    public class BaseViewHolder extends RecyclerView.ViewHolder {


        public BaseViewHolder(View itemView) {
            super(itemView);
            if(itemView==mHeaderView){
                return;
            }
            if(itemView==mFooterView){
                return;
            }

        }
    }

    public class ShopTodayViewHolder extends BaseViewHolder {

        private ImageView iv;
        private RecyclerView todayRecyclerView;

        public ShopTodayViewHolder(View itemView) {
            super(itemView);
            iv = (ImageView) itemView.findViewById(R.id.iv_adapter_more);
            todayRecyclerView = (RecyclerView) itemView.findViewById(R.id.rc_adapter_more);

        }

    }

    public class DoubleViewHolder extends BaseViewHolder {


        private Double_info doubleLeft;
        private Double_info doubleRigth;

        public DoubleViewHolder(View itemView) {
            super(itemView);
            doubleLeft = (Double_info) itemView.findViewById(R.id.double_info_left);
            doubleRigth = (Double_info) itemView.findViewById(R.id.double_info_rigth);
        }

    }

    public class TextViewHolder extends BaseViewHolder {

        private TextView textLeft;
        private TextView textRigth;

        public TextViewHolder(View itemView) {
            super(itemView);
            textLeft = (TextView) itemView.findViewById(R.id.text_left);
            textRigth = (TextView) itemView.findViewById(R.id.text_rigth);
        }
    }

    public class SortViewHolder extends  BaseViewHolder{

        private  ImageView ivSort;
        private  TextView tvMore;
        private MyGirdView gvSort;

        public SortViewHolder(View itemView) {
            super(itemView);
            ivSort = (ImageView) itemView.findViewById(R.id.iv_sort);
            tvMore = (TextView) itemView.findViewById(R.id.tv_today_more);
            gvSort = (MyGirdView) itemView.findViewById(R.id.gv_sort);
        }
    }
}
