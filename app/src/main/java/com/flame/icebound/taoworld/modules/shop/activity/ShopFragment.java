package com.flame.icebound.taoworld.modules.shop.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.convenientbanner.CBViewHolderCreator;
import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.OnItemClickListener;
import com.daidingkang.SnapUpCountDownTimerView;
import com.flame.icebound.taoworld.R;
import com.flame.icebound.taoworld.activity.BaseFragment;
import com.flame.icebound.taoworld.i.BaseCallBack;
import com.flame.icebound.taoworld.modules.shop.adapter.RecyclerviewAdapter;
import com.flame.icebound.taoworld.modules.shop.adapter.ShopPageAdapter;
import com.flame.icebound.taoworld.modules.shop.bean.BaseItemInfo;
import com.flame.icebound.taoworld.modules.shop.bean.DoubleGoodsInfo;
import com.flame.icebound.taoworld.modules.shop.bean.NewWorkImageHolderView;
import com.flame.icebound.taoworld.modules.shop.bean.ShopSelectedInfo;
import com.flame.icebound.taoworld.modules.shop.bean.ShopTodayInfo;
import com.flame.icebound.taoworld.modules.shop.bean.SortGoods;
import com.flame.icebound.taoworld.modules.shop.bean.SortItemInfo;
import com.flame.icebound.taoworld.modules.shop.bean.TextItemInfo;
import com.flame.icebound.taoworld.modules.shop.dao.ShopSelectedInfoDao;
import com.flame.icebound.taoworld.modules.shop.dao.ShopSortInfoDao;
import com.flame.icebound.taoworld.modules.shop.dao.ShopTodayInfoDao;
import com.flame.icebound.taoworld.widget.TitleBar;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/29.
 */
public class ShopFragment extends BaseFragment {

    private TitleBar tvTitle;
    private RecyclerView shopRecyclerView;
    private SwipeRefreshLayout refreshLayout;
    private List<BaseItemInfo> list;
    private RecyclerviewAdapter mAdapter;
    private int pageSelected = 1;
    private LinearLayoutManager linearLayoutManager;
    private ConvenientBanner cbBanner;
    private ShopTodayInfo shopTodayInfo;
    private static String url = "http://img.taoshij.com";
    private ViewPager vpSeckKill;
    private List<ShopTodayInfo.RstBean.TopicListBean> tempList;
    private View mHeader;
    private SnapUpCountDownTimerView rushBuyCountDownTimerView;
    private TextView tvItemCenter;


    @Override
    protected int setLayout() {
        return R.layout.shop_fragment_layout;
    }

    @Override
    protected void findViews(View view) {

        tvTitle = (TitleBar) view.findViewById(R.id.title_bar);
        shopRecyclerView = (RecyclerView) view.findViewById(R.id.shop_recyclerview);
        refreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.shop_refresh);

    }

    @Override
    protected void initEvent() {
        //刷新监听
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                pageSelected = 1;
                loadData();
            }
        });

        shopRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

        });

        //上拉加载
        shopRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

            private int lastVisibleItemPosition;

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE && lastVisibleItemPosition
                        == mAdapter.getItemCount() - 1 && shopRecyclerView.getChildCount() > 0) {
                    pageSelected++;
                    loadSelectedGoods();
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                lastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();

            }
        });

    }


    @Override
    protected void init()  {

        tvTitle.getTvTitle().setVisibility(View.INVISIBLE);
        tvTitle.getRlSearch().setVisibility(View.VISIBLE);
        list = new ArrayList<>();

        //设置shopRecyclerView适配器
        mAdapter = new RecyclerviewAdapter(getActivity(), list);

        //初始化shopRecyclerView
        linearLayoutManager = new LinearLayoutManager(getActivity());
        shopRecyclerView.setLayoutManager(linearLayoutManager);
        //初始化头部视图数据

        mHeader = View.inflate(getActivity(), R.layout.shop_recyclerview_header, null);
        //得到头部视图控件
        cbBanner = (ConvenientBanner) mHeader.findViewById(R.id.cb_banner);
        vpSeckKill = (ViewPager) mHeader.findViewById(R.id.vp_shop_seckKill);

        rushBuyCountDownTimerView = (SnapUpCountDownTimerView) mHeader.findViewById(R.id.RushBuyCountDownTimerView);
        tvItemCenter = (TextView) mHeader.findViewById(R.id.tv_item_center);

        //给recycler设置头部
        mAdapter.setmHeaderView(mHeader);
        shopRecyclerView.setAdapter(mAdapter);

    }

    @Override
    protected void loadData() {


        //下载解析数据
        ShopTodayInfoDao.getShopTodayInfoList(new BaseCallBack() {
            @Override
            public void success(Object data) {
                if (pageSelected == 1) {
                    list.clear();

                }
                shopTodayInfo = (ShopTodayInfo) data;
                tempList = shopTodayInfo.getRst().getTopicList();

                if (tempList != null) {
                    tvTitle.getTvSearch().setText(shopTodayInfo.getRst().getSearchInput().getTip());
                    //下载分类信息
                    loadSortGoods();

                    //给集合元素设置type
                    for (int i = 0; i < tempList.size(); i++) {
                        tempList.get(i).setType(BaseItemInfo.ShopTpyes.SHOP_TYPE_TODAY);
                    }
                    list.addAll(tempList);

                    //头部轮图设置并获得网络数据源
                    initTopBannerList(cbBanner, shopTodayInfo);
                    //初始化vpSeckKill数据源
                    initvpSeckKill(shopTodayInfo, tempList);

                    //设置抢购时间，倒计时实现
                    initTime();
                    mAdapter.notifyDataSetChanged();
                }


            }



            @Override
            public void failed(int errorCode, Object data) {

                //网络返回失败停止刷新
                refreshLayout.setRefreshing(false);

            }
        });


        //下载全球精选
        loadSelectedGoods();
    }

    //头部轮图设置获得网络数据源
    private void initTopBannerList(final ConvenientBanner convenientBanner, final ShopTodayInfo shopTodayInfo) {

        List<String> bannerList = new ArrayList<>();//头部轮图
        for (int i = 0; i < shopTodayInfo.getRst().getBannerList().size(); i++) {

            Log.e("print", "shopTodayInfobannerList=====" + shopTodayInfo.getRst().getBannerList().get(i).getImage_path());
            //获得图片网址集合
            bannerList.add(url + shopTodayInfo.getRst().getBannerList().get(i).getImage_path());
            Log.e("print", "bannerList========" + bannerList.get(i));
        }


        convenientBanner.setPages(new CBViewHolderCreator<NewWorkImageHolderView>() {

            @Override
            public NewWorkImageHolderView createHolder() {

                return new NewWorkImageHolderView();
            }
            //设置两个点图片作为翻页指示器
        }, bannerList).setPageIndicator(new int[]{R.mipmap.ic_page_indicator, R.mipmap.ic_page_indicator_focused})
                //设置指示器方向
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL)
                //图片点击事件跳转详情页网页
                .setOnItemClickListener(new OnItemClickListener() {
                    @Override
                    public void onItemClick(int position) {
                        //把网址传递过去
                        Log.e("print","跳转？？？？？？？？？？？？？");
                        Intent intent=new Intent(ShopFragment.this.getActivity(),BannerActivity.class);
                        intent.putExtra("url",shopTodayInfo.getRst().getBannerList().get(position).getCommonId());
                        startActivity(intent);
                    }
                });

    }

    ////初始化vpSeckKill数据源
    private void initvpSeckKill(ShopTodayInfo shopTodayInfo, List<ShopTodayInfo.RstBean.TopicListBean> tempList) {
        //初始化SeckKill，ViewPager数据
        List<ShopTodayInfo.RstBean.SeckKillBean.StockInfoBean> listSeckKill = shopTodayInfo.getRst().getSeckKill().getStockInfo();
        List<Fragment> listSeckKillFragment = new ArrayList<>();
        List<ShopTodayInfo.RstBean.SeckKillBean.StockInfoBean> listSeckKillForFragment = null;
        for (int i = 0; i < (listSeckKill.size() + 2) / 3; i++) {
            ShopSeckKillFragment shopSeckKillFragment = new ShopSeckKillFragment();
            listSeckKillForFragment = new ArrayList<ShopTodayInfo.RstBean.SeckKillBean.StockInfoBean>();
            Log.e("print", "listSeckKillForFragment=====" + listSeckKillForFragment.size());
            for (int j = 0 + i * 3; j < 3 + i * 3; j++) {

                listSeckKillForFragment.add(listSeckKill.get(j));
            }

            Bundle bundle = new Bundle();
            bundle.putSerializable("listSeckKillForFragment", (Serializable) listSeckKillForFragment);
            shopSeckKillFragment.setArguments(bundle);
            listSeckKillFragment.add(shopSeckKillFragment);
        }

        Log.e("print", "listSeckKillFragment数量=====" + listSeckKillFragment.size());
        //设置SeckKill，ViewPager,适配器
        FragmentManager fm = getActivity().getSupportFragmentManager();
        ShopPageAdapter mShopPageAdapter = new ShopPageAdapter(fm, listSeckKillFragment);
        vpSeckKill.setAdapter(mShopPageAdapter);

    }

    //下载分类信息
    private void loadSortGoods() {

        ShopSortInfoDao.getSortGoodsList(new BaseCallBack() {
            @Override
            public void success(Object data) {
                SortGoods sortGoods = (SortGoods) data;
                Log.e("print", "SortGoods================" + data);
                if (sortGoods != null) {
                    SortItemInfo sortItemInfo = new SortItemInfo();
                    sortItemInfo.setType(BaseItemInfo.ShopTpyes.SHOP_TYPE_SORT);

                    if(shopTodayInfo.getRst().getGroupBuying().size()>0){
                        sortItemInfo.setGroupBuyingBean(shopTodayInfo.getRst().getGroupBuying().get(0));
                    }

                    sortItemInfo.setSortGoods(sortGoods);
                    list.add(0, sortItemInfo);
                }
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void failed(int errorCode, Object data) {

                refreshLayout.setRefreshing(false);
            }
        });
    }

    private void loadSelectedGoods() {
        //全球精选数据
        ShopSelectedInfoDao.getShopSelectedInfo(pageSelected, new BaseCallBack() {
            @Override
            public void success(Object data) {

                refreshLayout.setRefreshing(false);//停止刷新
                List<ShopSelectedInfo.RstBean.StockListBean> stockListBeanList = (List<ShopSelectedInfo.RstBean.StockListBean>) data;
                //需要的基类的子类
                List<DoubleGoodsInfo> doubleGoodsInfoList = new ArrayList<DoubleGoodsInfo>();

                if (pageSelected >= 4) {//大于4页已经到底部
                    Toast.makeText(getActivity(), "没有数据了哦", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (stockListBeanList != null) {

                    int a = 0;//判断商品个数是奇数还是偶数

                    if (stockListBeanList.size() % 2 != 0) {
                        a = 1;
                    }
                    for (int i = 0; i < stockListBeanList.size() / 2 + a; i++) {
                        DoubleGoodsInfo doubleGoodsInfo = new DoubleGoodsInfo();
                        doubleGoodsInfo.setLeftStockListBean(stockListBeanList.get(i * 2));

                        if (i * 2 != stockListBeanList.size() - 1) {//如果是商品个数为奇数，则没有右边商品信息
                            doubleGoodsInfo.setRigthStockListBean(stockListBeanList.get(i * 2 + 1));
                        }
                        doubleGoodsInfo.setType(BaseItemInfo.ShopTpyes.SHOP_TYPE_DOUBLE);
                        doubleGoodsInfoList.add(doubleGoodsInfo);
                    }


                    if (pageSelected == 1) {
                        TextItemInfo textItemInfo = new TextItemInfo();
                        textItemInfo.setLeftText("全球精选");
                        textItemInfo.setRigthText("猜你喜欢");
                        textItemInfo.setType(BaseItemInfo.ShopTpyes.SHOP_TYPE_SINGLE_TEXT);
                        list.add(textItemInfo);
                    }

                    list.addAll(doubleGoodsInfoList);

                    mAdapter.notifyDataSetChanged();

                }

            }

            @Override
            public void failed(int errorCode, Object data) {

                refreshLayout.setRefreshing(false);
            }
        });


    }

    //设置抢购时间，倒计时实现
    private void initTime() {
        tvItemCenter.setText(shopTodayInfo.getRst().getSeckKill().getHour()+"抢购中");
        SimpleDateFormat formatter=new SimpleDateFormat("HH:mm:ss");
        Long time=Long.parseLong(shopTodayInfo.getRst().getSeckKill().getEndTime())-Long.parseLong(shopTodayInfo.getRst().getSeckKill().getStartTime());
        Log.e("print","Time++++++++++++++++++++++++++"+time);
        String endtime = formatter.format(time);
        String[] split = endtime.split(":");
        rushBuyCountDownTimerView.setTime(Integer.parseInt(split[0]),Integer.parseInt(split[1]),Integer.parseInt(split[2]));
        rushBuyCountDownTimerView.start();
    }
    @Override
    public void onResume() {
        super.onResume();
        cbBanner.startTurning(3000);
    }

    @Override
    public void onPause() {
        super.onPause();
        cbBanner.stopTurning();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //计时取消
        rushBuyCountDownTimerView.stop();
    }
}

