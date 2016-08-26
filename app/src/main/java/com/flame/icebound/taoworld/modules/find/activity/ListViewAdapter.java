package com.flame.icebound.taoworld.modules.find.activity;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bigkoo.convenientbanner.CBPageAdapter;
import com.bigkoo.convenientbanner.CBViewHolderCreator;
import com.bigkoo.convenientbanner.ConvenientBanner;
import com.flame.icebound.taoworld.R;
import com.flame.icebound.taoworld.i.BaseCallBack;
import com.flame.icebound.taoworld.modules.find.bean.Banners;
import com.flame.icebound.taoworld.modules.find.bean.FindListInfo;
import com.flame.icebound.taoworld.modules.find.dao.BannersDao;
import com.flame.icebound.taoworld.util.ImageLoaderUtil;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hasee on 2016/8/8.
 */
public class ListViewAdapter extends RecyclerView.Adapter<ListViewAdapter.BaseViewHolder> {

    private List<FindListInfo.ShareListBean> list;
    private Context context;
    private View itemView;
    boolean flag = true;
    //保存图片ViewPager的集合
    private List<Banners.BannersBean> findlist;
    private ArrayList<String> localImages;

    public ListViewAdapter(List<FindListInfo.ShareListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        return list.get(position).getType();
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        if(flag==true) {
            itemView = LayoutInflater.from(context).inflate(
                    R.layout.find_banner_recycler_adapter, parent, false);
            flag = false;

            return new MyBannersDapter(itemView);
        }else {


            itemView = LayoutInflater.from(context).inflate(
                    R.layout.find_list_two_layout, parent, false);

            return new MyViewAdapter(itemView);
        }

    }

    private void loadViewPagerPicture() {

        findlist = new ArrayList<Banners.BannersBean>();
        BannersDao.getFindBannersViewPager(new BaseCallBack() {
            @Override
            public void success(Object data) {
                if (data != null) {
                    findlist.clear();
                    Banners b = (Banners) data;
                    findlist.addAll(b.getBanners());

                    String url = null;
                    for (int i = 0; i < findlist.size(); i++) {
                        url = findlist.get(i).getImg();
                        localImages.add(url);
                    }
                    Log.e("find","========findlist======="+findlist.size());
                }else {
                    Log.e("find","========data======="+data);
                }
            }
            @Override
            public void failed(int errorCode, Object data) {
            }
        });
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        if (position == 0) {
            loadViewPagerPicture();
            MyBannersDapter myBannersDapter = (MyBannersDapter) holder;
            //自定义你的Holder，实现更多复杂的界面，不一定是图片翻页，其他任何控件翻页亦可。
            localImages = new ArrayList<String>();

            CBViewHolderCreator<LocalImageHolderView> cbViewHolderCreator = new CBViewHolderCreator<LocalImageHolderView>() {
                @Override
                public LocalImageHolderView createHolder() {
                    return new LocalImageHolderView();
                }
            };

            myBannersDapter.convenientBanner.setPages(cbViewHolderCreator
                    , localImages)
                    //设置两个点图片作为翻页指示器，不设置则没有指示器，可以根据自己需求自行配合自己的指示器,不需要圆点指示器可用不设
                    .setPageIndicator(new int[]{R.drawable.find_viewpager_ture, R.drawable.find_viewpager_false})
                    //设置指示器的方向
                    .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL)
                    .startTurning(3000)
                    //.setCanLoop(!convenientBanner.isCanLoop());
                    //设置翻页的效果，不需要翻页效果可用不设
                    .setPageTransformer(ConvenientBanner.Transformer.DefaultTransformer);
        } else {
            Log.e("find", "=======review_detail========" + position);
            MyViewAdapter myViewAdapter = (MyViewAdapter) holder;
            String review_detail = list.get(position * 2).getReview_detail();
            myViewAdapter.list_tv1.setText(review_detail);
            myViewAdapter.list_tv3.setText(list.get(position * 2 + 1).getReview_detail());
            myViewAdapter.list_tv2.setText(list.get(position * 2).getUser_name());
            myViewAdapter.list_tv4.setText(list.get(position * 2 + 1).getUser_name());

            ImageLoader.getInstance().displayImage(list.get(position * 2).getImgs(), myViewAdapter.picture1);
            ImageLoader.getInstance().displayImage(list.get(position * 2).getUser_head(), myViewAdapter.picture2);
            ImageLoader.getInstance().displayImage(list.get(position * 2 + 1).getImgs(), myViewAdapter.picture4);
            ImageLoader.getInstance().displayImage(list.get(position * 2 + 1).getUser_head(), myViewAdapter.picture5);

        }

    }

    @Override
    public int getItemCount() {
        return list.size() / 2 + 1;
    }

    public class MyViewAdapter extends BaseViewHolder {

        private ImageView picture4;
        private ImageView picture5;
        private ImageView picture1;
        private ImageView picture2;

        private TextView list_tv2;
        private TextView list_tv1;
        private TextView list_tv3;
        private TextView list_tv4;

        public MyViewAdapter(View itemView) {
            super(itemView);

            this.picture1 = (ImageView) itemView.findViewById(R.id.list_picture1);
            picture2 = (ImageView) itemView.findViewById(R.id.list_picture2);
            picture4 = (ImageView) itemView.findViewById(R.id.list_picture4);
            picture5 = (ImageView) itemView.findViewById(R.id.list_picture5);
            Log.e("find", "======= picture1========" + picture1);
            list_tv1 = (TextView) itemView.findViewById(R.id.list_tv1);
            list_tv2 = (TextView) itemView.findViewById(R.id.list_tv2);
            list_tv3 = (TextView) itemView.findViewById(R.id.list_tv3);
            list_tv4 = (TextView) itemView.findViewById(R.id.list_tv4);
        }
    }

    public class MyBannersDapter extends BaseViewHolder {

        private ConvenientBanner convenientBanner;
        private CBViewHolderCreator<LocalImageHolderView> cbViewHolderCreator;
        //保存图片ViewPager的集合
        private List<Banners.BannersBean> findlist;

        public MyBannersDapter(View itemView) {
            super(itemView);
            convenientBanner = (ConvenientBanner) itemView.findViewById(R.id.convenientBanner);
            Log.e("find", "======= picture1========" + convenientBanner);
        }
    }

    public class BaseViewHolder extends RecyclerView.ViewHolder {
        public BaseViewHolder(View itemView) {
            super(itemView);
        }
    }

    public class LocalImageHolderView implements CBPageAdapter.Holder<String> {
        private ImageView imageView;

        @Override
        public View createView(Context context) {
            imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            return imageView;
        }

        @Override
        public void UpdateUI(Context context, int position, String data) {
            ImageLoader.getInstance().displayImage(data, imageView, ImageLoaderUtil.getDefaultOption());
        }
    }
}
