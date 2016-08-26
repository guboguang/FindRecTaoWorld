package com.flame.icebound.taoworld.modules.find.activity;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import com.bigkoo.convenientbanner.CBPageAdapter;
import com.bigkoo.convenientbanner.CBViewHolderCreator;
import com.bigkoo.convenientbanner.ConvenientBanner;
import com.flame.icebound.taoworld.R;
import com.flame.icebound.taoworld.activity.BaseFragment;
import com.flame.icebound.taoworld.i.BaseCallBack;
import com.flame.icebound.taoworld.modules.find.adapter.FindListAdapter;
import com.flame.icebound.taoworld.modules.find.bean.Banners;
import com.flame.icebound.taoworld.modules.find.bean.Brandparent;
import com.flame.icebound.taoworld.modules.find.bean.FindListInfo;
import com.flame.icebound.taoworld.modules.find.bean.HotFourCategory;
import com.flame.icebound.taoworld.modules.find.dao.BannersDao;
import com.flame.icebound.taoworld.modules.find.dao.FindBrandDao;
import com.flame.icebound.taoworld.modules.find.dao.FindListDao;
import com.flame.icebound.taoworld.modules.find.dao.HotFourCategoryDao;
import com.flame.icebound.taoworld.modules.find.widget.BrandLifeView;
import com.flame.icebound.taoworld.modules.find.widget.BrandView;
import com.flame.icebound.taoworld.modules.find.widget.CharacterView;
import com.flame.icebound.taoworld.util.ImageLoaderUtil;
import com.flame.icebound.taoworld.util.ThreadTask;
import com.nostra13.universalimageloader.core.ImageLoader;
import org.xutils.DbManager;
import org.xutils.ex.DbException;
import org.xutils.x;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/29.
 */
public class FindFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener, AbsListView.OnScrollListener, View.OnClickListener {

    private SwipeRefreshLayout swipe_refresh;
    private ListView listView;
    private FindListAdapter findListAdapter;
    private CharacterView characterView;
    private int page = 1;
    private boolean isCompelete = true;
    private ConvenientBanner convenientBanner;
    //Banners框架用到的集合
    private List<String> localImages;

    //保存图片ViewPager的集合
    private List<Banners.BannersBean> findlist;

    private ArrayList<FindListInfo.ShareListBean> list;
    private DbManager db;
    private CBViewHolderCreator<LocalImageHolderView> cbViewHolderCreator;


    @Override
    protected int setLayout() {
        return R.layout.find_fragment_layout;
    }

    protected void operateDb() {
        File file = new File("/sdcard/xutils/taoWord");
        if (!file.exists()) {
            file.mkdirs();
        }
        DbManager.DaoConfig config = new DbManager.DaoConfig()
                .setDbVersion(1)
                .setDbDir(file)
                .setDbName("find")
                .setDbUpgradeListener(new DbManager.DbUpgradeListener() {
                    @Override
                    public void onUpgrade(DbManager db, int oldVersion, int newVersion) {
                        //数据库版本更新操作
                    }
                });
        db = x.getDb(config);

    }

    //读取数据库操作。
    protected void loadDataDb() {

        ThreadTask.getInstance().executorDBThread(new Runnable() {

            @Override
            public void run() {
                try {

                    List<Banners.BannersBean> all = db.findAll(Banners.BannersBean.class);

                        if (all != null) {
                            final List<Banners.BannersBean> finalAll = all;
                            getActivity().runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    findlist.clear();
                                    findlist.addAll(finalAll);

                                    //更新convenientBanner数据
                                    setViewPagerPicture();

                                }
                            });

                            findlist.addAll(all);

                        }

                } catch (DbException e) {
                    e.printStackTrace();
                }
            }


        }, ThreadTask.ThreadPeriod.PERIOD_HIGHT);
        // ThreadTask.ThreadPeriod.PERIOD_HIGHT 线程优先级。
    }


        @Override
        protected void findViews (View view){

            listView = (ListView) view.findViewById(R.id.listView);
            swipe_refresh = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh);

        }

        @Override
        protected void initEvent () {
            swipe_refresh.setOnRefreshListener(this);
            listView.setOnScrollListener(this);


        }

    private void setViewPagerPicture() {

        //自定义你的Holder，实现更多复杂的界面，不一定是图片翻页，其他任何控件翻页亦可。
        localImages = new ArrayList<String>();

        String url = null;
        for (int i = 0; i < findlist.size(); i++) {
            url = findlist.get(i).getImg();
            localImages.add(url);
        }
        cbViewHolderCreator = new CBViewHolderCreator<LocalImageHolderView>() {
            @Override
            public LocalImageHolderView createHolder() {
                return new LocalImageHolderView();
            }
        };

        convenientBanner.setPages(cbViewHolderCreator
        , localImages)
        //设置两个点图片作为翻页指示器，不设置则没有指示器，可以根据自己需求自行配合自己的指示器,不需要圆点指示器可用不设
        .setPageIndicator(new int[]{R.drawable.find_viewpager_ture, R.drawable.find_viewpager_false})
                //设置指示器的方向
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL)
                .startTurning(3000)
                //.setCanLoop(!convenientBanner.isCanLoop());
                //设置翻页的效果，不需要翻页效果可用不设
                .setPageTransformer(ConvenientBanner.Transformer.DefaultTransformer);

    }

    @Override
    protected void init() {


        //添加ListView头部；
        LayoutInflater from = LayoutInflater.from(getActivity());
        View inflate = from.inflate(R.layout.find_list_header_layout, null);
        characterView = (CharacterView) inflate.findViewById(R.id.character_view);
        convenientBanner = (ConvenientBanner) inflate.findViewById(R.id.convenientBanner);
        listView.addHeaderView(inflate);

        //创建数据库
        operateDb();


        findlist = new ArrayList<Banners.BannersBean>();
        page = 1;
        setCharacterView();
        list = new ArrayList<FindListInfo.ShareListBean>();
        findListAdapter = new FindListAdapter(getActivity(), list, R.layout.find_list_two_layout);
        listView.setAdapter(findListAdapter);
    }

    private void setCharacterView() {
    }

    @Override
    protected void loadData() {
        loadDataDb();
        //读取ViewPager图片网络数据
        loadViewPagerPicture();

        //读取品质生活图片
        HotFourCategoryDao.getFindHotFourCategory(new BaseCallBack() {

            private ImageView image;
            BrandLifeView[] brandLifeViews = characterView.getbrandLifeViews();

            @Override
            public void success(Object data) {
                List<HotFourCategory.HotFourCategoryBean> list = (List<HotFourCategory.HotFourCategoryBean>) data;
                for (int i = 0; i < list.size(); i++) {

                    image = brandLifeViews[i].getImageView();
                    image.setScaleType(ImageView.ScaleType.FIT_XY);
                    ImageLoader.getInstance().displayImage(list.get(i).getImage_path(), image);
                    brandLifeViews[i].setImageView(image);
                    brandLifeViews[i].setStringTv1(list.get(i).getOneTitle());
                }
            }

            @Override
            public void failed(int errorCode, Object data) {

            }
        });


        loadDataDb();

        //读取ViewPager图片网络数据
        loadViewPagerPicture();


        //设置品牌热度的数据
        this.setHotBrand();
        //设置商品列表信息
        setShopListView();
    }

    private void loadViewPagerPicture() {
        BannersDao.getFindBannersViewPager(new BaseCallBack() {
            @Override
            public void success(Object data) {

                if (data != null) {
                    findlist.clear();
                    Banners b = (Banners) data;
                    findlist.addAll(b.getBanners());
                    //数据库保存数据
                    saveViewPagerDb();

                    if (page == 1) {
                        //数据库保存数据
                        saveViewPagerDb();
                    }

                    if (data == null) {
                        //读取数据库数据；
                        loadDataDb();

                    }

                    //设置findViewPager图片
                    setViewPagerPicture();

                }

            }


            @Override
            public void failed(int errorCode, Object data) {

            }


        });
    }

    private void setShopListView() {

        FindListDao.getFindList(page, new BaseCallBack() {
            @Override
            public void success(Object data) {

                //停止刷新
                swipe_refresh.setRefreshing(false);
                // 在当前这个需求以page==1来判断是否需要将list清空(page==1意味下拉刷新)
                if (page == 1) {
                    list.clear();
                }

                if (data != null) {
                    ArrayList<FindListInfo.ShareListBean> data1 = (ArrayList<FindListInfo.ShareListBean>) data;
                    list.addAll(data1);
                    findListAdapter.setCount((list.size() + 1) / 2);
                    findListAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void failed(int errorCode, Object data) {

            }
        });
    }

    private void saveViewPagerDb() {
        ThreadTask.getInstance().executorDBThread(new Runnable() {
            @Override
            public void run() {
                try {
                    db.delete(Banners.BannersBean.class);
                    db.save(findlist);

                } catch (DbException e) {
                    e.printStackTrace();
                }
            }
        }, ThreadTask.ThreadPeriod.PERIOD_HIGHT);
    }

    private void setHotBrand() {
        FindBrandDao.getFindBrandList(new BaseCallBack() {

            private BrandView[] brandViews;

            @Override
            public void success(Object data) {
                brandViews = characterView.getBrandViews();
                ArrayList<Brandparent.BrandInfo> list = (ArrayList<Brandparent.BrandInfo>) data;

                for (int i = 0; i < brandViews.length; i++) {

                    Brandparent.BrandInfo brandInfo = list.get(i);

                    brandViews[i].setStringTv1(brandInfo.getText_content());
                    brandViews[i].setStringTv2("粉丝：" + brandInfo.getFollowCount());

                    ImageView imageView = brandViews[i].getImageView();
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    ImageLoader.getInstance().displayImage("http://img.taoshij.com" + brandInfo.getImage_path(), imageView);
                    brandViews[i].setImageView(imageView);
                }
            }

            @Override
            public void failed(int errorCode, Object data) {

            }
        });
    }

    //下拉刷新
    @Override
    public void onRefresh() {
        Toast.makeText(getActivity(), "正在刷新请稍候", Toast.LENGTH_SHORT).show();
        isCompelete = false;
        page = 1;
        loadData();
        swipe_refresh.setRefreshing(false);

    }

    //下拉加载
    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {

        if (scrollState == SCROLL_STATE_IDLE) {
            int lastPosition = listView.getLastVisiblePosition();
            if (lastPosition == (list.size() + 1) / 2
                    && listView.getChildCount() > 0
                    && listView.getChildAt(listView.getChildCount() - 1)
                    .getBottom() == listView.getBottom()
                    - listView.getPaddingBottom()) {

                page++;
                setShopListView();
            }
        }
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

    }

    @Override
    public void onClick(View v) {

    }

    //  convenientBanner.setManualPageable(false);//设置不能手动影响

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
