package com.qianfeng.recyclerviewmultylayout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{

    private List<BaseInfo> list;

    private RecyclerView recyclerView;

    private RecyclerMultyAdapter adapter;


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }


    @Override
    public void startActivityForResult(Intent intent, int requestCode, Bundle options) {
        super.startActivityForResult(intent, requestCode, options);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // EventBus.getDefault().register(this);
        Observer.getInstance().registWatcher(new ImageWatcher(Observer.Type.IMAGE));
        Observer.getInstance().registWatcher(new VideoWatcher(Observer.Type.VIDEO));

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        list = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new RecyclerMultyAdapter(this, list);
        recyclerView.setAdapter(adapter);
        loadData();
        Intent intent = new Intent();

    }

    private void loadData()
    {
        addSingleLeft(R.mipmap.pic1, "asdfafd", "asdassdd");
        addDouble(R.mipmap.pic5, R.mipmap.pic2);
        addThree(R.mipmap.pic6, R.mipmap.pic4, R.mipmap.pic8);
        addSingleFull(R.mipmap.pic7, "asdfafd");
        addSingleLeft(R.mipmap.pic3, "asdfafd", "asdassdd");
        addThree(R.mipmap.pic5, R.mipmap.pic3, R.mipmap.pic1);
        addSingleFull(R.mipmap.pic4, "asdfafd");
        addSingleLeft(R.mipmap.pic8, "asdfafd", "asdassdd");
        addSingleFull(R.mipmap.bg, "asdfafd");
        addThree(R.mipmap.pic4, R.mipmap.pic5, R.mipmap.pic6);
        addDouble(R.mipmap.pic2, R.mipmap.pic8);
        adapter.notifyDataSetChanged();
    }

    private void addSingleLeft(int imgUrl, String title, String content)
    {
        SingleLeftInfo info = new SingleLeftInfo();
        info.setType(BaseInfo.NewsTypes.NEWS_TYPE_SINGLE_LEFT);
        info.setImgUrl(imgUrl);
        info.setTitle(title);
        info.setContent(content);
        list.add(info);
    }

    private void addSingleFull(int imgUrl, String title)
    {
        SingleFullInfo info = new SingleFullInfo();
        info.setType(BaseInfo.NewsTypes.NEWS_TYPE_SINGLE_FULL);
        info.setImgUrl(imgUrl);
        info.setTitle(title);
        list.add(info);
    }

    private void addDouble(int leftImg, int rightImg)
    {
        DoubleImageInfo info = new DoubleImageInfo();
        info.setType(BaseInfo.NewsTypes.NEWS_TYPE_DOUBLE);
        info.setImgLeftUrl(leftImg);
        info.setImgRightUrl(rightImg);
        list.add(info);
    }

    private void addThree(int imgUrlLeft, int imgUrlCenter, int imgUrlRight)
    {
        ThreeImageInfo info = new ThreeImageInfo();
        info.setType(BaseInfo.NewsTypes.NEWS_TYPE_THREE);
        info.setImgLeftUrl(imgUrlLeft);
        info.setImgCenterUrl(imgUrlCenter);
        info.setImgRightUrl(imgUrlRight);
        list.add(info);
    }

    @Subscribe
    public void onEvent(BaseInfo info)
    {
        // TODO 将数据填充到界面
        list.add(0, info);
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        // EventBus.getDefault().unregister(this);
        // Observer.getInstance().unRegistWatcher(this);
    }

    public class ImageWatcher extends Observer.Watcher
    {

        public ImageWatcher(int type)
        {
            super(type);
        }

        @Override
        void update(Object info)
        {
            // TODO 将数据填充到界面
            list.add(0, (BaseInfo) info);
            adapter.notifyDataSetChanged();
        }
    }

    public class VideoWatcher extends Observer.Watcher
    {

        public VideoWatcher(int type)
        {
            super(type);
        }

        @Override
        void update(Object info)
        {
            // TODO 将数据填充到界面
            list.add(0, (BaseInfo) info);
            adapter.notifyDataSetChanged();
        }
    }

}
