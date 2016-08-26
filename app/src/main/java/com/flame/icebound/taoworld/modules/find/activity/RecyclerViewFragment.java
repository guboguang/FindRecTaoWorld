package com.flame.icebound.taoworld.modules.find.activity;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.flame.icebound.taoworld.R;
import com.flame.icebound.taoworld.activity.BaseFragment;
import com.flame.icebound.taoworld.i.BaseCallBack;
import com.flame.icebound.taoworld.modules.find.bean.FindListInfo;
import com.flame.icebound.taoworld.modules.find.dao.FindListDao;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {

    private List<FindListInfo.ShareListBean> list;
    private RecyclerView recyclerView;
    private int page;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected int setLayout() {
        return R.layout.find_activity_recycler_view;
    }

    @Override
    protected void findViews(View view) {

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe);
    }

    @Override
    protected void initEvent() {
        swipeRefreshLayout.setOnRefreshListener(this);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

            }

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }
        });


    }

    @Override
    protected void init() {

    }

    @Override
    protected void loadData() {
        //startActivityForResult(new Intent(getActivity(), NewActivity.class),  1);
        page = 1;
        list = new ArrayList<FindListInfo.ShareListBean>();
        FindListDao.getFindList(page, new BaseCallBack() {
            @Override
            public void success(Object data) {
                list = (List<FindListInfo.ShareListBean>) data;
                list.addAll(list);
                ListViewAdapter listViewAdapter = new ListViewAdapter(list, getActivity());
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                recyclerView.setLayoutManager(linearLayoutManager);
                recyclerView.setAdapter(listViewAdapter);

            }

            @Override
            public void failed(int errorCode, Object data) {

            }
        });

    }

    @Override
    public void onRefresh() {
        list.clear();
        page = 1;
        loadData();
        swipeRefreshLayout.setRefreshing(false);
    }

}
