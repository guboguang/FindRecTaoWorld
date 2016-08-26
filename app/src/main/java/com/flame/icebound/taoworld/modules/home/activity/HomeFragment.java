package com.flame.icebound.taoworld.modules.home.activity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;

import com.flame.icebound.taoworld.R;
import com.flame.icebound.taoworld.activity.BaseFragment;
import com.flame.icebound.taoworld.i.BaseCallBack;
import com.flame.icebound.taoworld.modules.home.adapter.ShareTopicAdapter;
import com.flame.icebound.taoworld.modules.home.bean.ShareTopic;
import com.flame.icebound.taoworld.modules.home.dao.HomeDao;
import com.flame.icebound.taoworld.widget.TitleBar;

import java.util.ArrayList;
import java.util.List;

import se.emilsjolander.stickylistheaders.StickyListHeadersListView;

/**
 * Created by Administrator on 2016/7/29.
 */
public class HomeFragment extends BaseFragment {

    private static final String TAG = "home";
    private TitleBar mTitle;
    private List<ShareTopic.RstBean.ShareListBean> mList;
    private StickyListHeadersListView mShareList;
    private ShareTopicAdapter mShareAdapter;
    private int page = 1;
    private SwipeRefreshLayout mRefresh;

    @Override
    protected int setLayout() {
        return R.layout.home_fragment_layout;
    }

    @Override
    protected void findViews(View view) {
        mTitle = (TitleBar) view.findViewById(R.id.tb_title);
        mShareList = (StickyListHeadersListView) view.findViewById(R.id.lv_share_list);
        mRefresh = (SwipeRefreshLayout) view.findViewById(R.id.srl_share);
    }

    @Override
    protected void initEvent() {
        //标题拍照分享点击监听
        mTitle.getIvRight().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CameraActivity.class);
                startActivityForResult(intent, 110);
            }
        });

        //设置下拉刷新
        mRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                page = 1;
                loadData();
            }

        });

        /**
         * 设置列表的滑动监听
         */
        mShareList.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
//                mShareList.getChildAt(mShareList.getChildCount()-1).getBottom()==mShareList.getBottom()-mShareList.getPaddingBottom()

                if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE) {
                    int lastVisibleItem = mShareList.getLastVisiblePosition();
                    if (lastVisibleItem == (mList.size() - 1) && mShareList.getChildCount() > 0) {
                        Log.e(TAG, "滑动更新");
                        //换页，刷新
                        page++;
                        loadData();
                    }
                   /* if(mShareList.getFirstVisiblePosition()==0){
                        Log.e("listview","第一页向上移动了");
                        mShareList.scrollTo(0,3);
                    }*/
                }
                Log.e(TAG, "滑动停止");
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem,
                                 int visibleItemCount, int totalItemCount) {

            }
        });
    }

    @Override
    protected void init() {
        //设置标题的文字样式
        mTitle.getTvTitle().setText("淘世界");
        mTitle.getTvTitle().setTextColor(Color.parseColor("#E61A5F"));
        mTitle.getTvTitle().setTextSize(22);
        mTitle.getTvTitle().setTypeface(Typeface.DEFAULT_BOLD);
        //设置标题的左右图标
        mTitle.setIvLeft(R.mipmap.tr_ic_filter_all_unselect);
        mTitle.setIvRight(R.mipmap.tr_icon_new_home_camera);

        mList = new ArrayList<>();
        //初始化话题分享列表
        mShareAdapter = new ShareTopicAdapter(getActivity(), mList);
        mShareList.setAdapter(mShareAdapter);
    }

    @Override
    protected void loadData() {
        Log.d("HOMEDAO", "loadData");
        /**
         * 加载网络数据
         */
        HomeDao.getShareList("GET", "http://221.228.216.23/user/orderShareNew/list?pageId=" + page, null, new BaseCallBack() {
            @Override
            public void success(Object data) {
                ShareTopic shareTopic = (ShareTopic) data;
                List<ShareTopic.RstBean.ShareListBean> tempList = shareTopic.getRst().getShareList();
                //有新数据，更新列表
                if (tempList.size() > 0) {
                    mList.addAll(tempList);
                    mShareAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void failed(int errorCode, Object data) {

            }
        });
    }
}
