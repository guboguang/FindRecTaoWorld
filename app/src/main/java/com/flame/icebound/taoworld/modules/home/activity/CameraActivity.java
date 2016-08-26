package com.flame.icebound.taoworld.modules.home.activity;

import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.flame.icebound.taoworld.R;
import com.flame.icebound.taoworld.activity.BaseActivity;
import com.flame.icebound.taoworld.modules.home.adapter.ChildAdapter;
import com.flame.icebound.taoworld.modules.home.adapter.GroupAdapter;
import com.flame.icebound.taoworld.modules.home.bean.ImageBean;
import com.flame.icebound.taoworld.modules.home.i.HomeProtocol;
import com.flame.icebound.taoworld.modules.home.util.TostUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CameraActivity extends BaseActivity {

    private static final String ALL_IMAGE_DIR = "相册胶卷";
    private HashMap<String, List<String>> mGruopMap = new HashMap<String, List<String>>();
    private List<ImageBean> list = new ArrayList<ImageBean>();
    private final static int SCAN_OK = 1;
    private ProgressDialog mProgressDialog;
    private GroupAdapter adapter;
    private ListView mGroupGridView;

    private GridView mGridView;
    private List<String> mGridList;
    private HashMap<String ,ChildAdapter> mGridViewAdapterList=new HashMap<>();


    /**
     * 显示大图片控件的宽高
     */
    private Point mPoint;
    private Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case SCAN_OK:
                    //关闭进度条
                    mProgressDialog.dismiss();
                    //所有图片初始化
                    mGridList = mGruopMap.get(ALL_IMAGE_DIR);
                    setGridViewAdapter(ALL_IMAGE_DIR,mGridList);
//                    loadSelectedImage(mGridList.get(0));
                    //图片文件夹初始化
                    list = subGroupOfImage(mGruopMap);
                    adapter = new GroupAdapter(CameraActivity.this, list, mGroupGridView);
                    mGroupGridView.setAdapter(adapter);
                    break;
            }
        }

    };
    private TextView mTitleName;
    private TextView mNext;

    private void setGridViewAdapter(String dirName,List<String> mGridList) {
        //判断是否已经存在适配器
        for (String name  : mGridViewAdapterList.keySet()) {
            if(name.equals(dirName)){
                mGridView.setAdapter(mGridViewAdapterList.get(name));
            }
        }
        ChildAdapter mGridAdapter = new ChildAdapter(CameraActivity.this, mGridList, mGridView,mImageView);
        mGridView.setAdapter(mGridAdapter);
        mGridViewAdapterList.put(dirName,mGridAdapter);
    }

    private boolean isHint = true;
    private ImageView mImageView;

    @Override
    protected int setLayout() {
        return R.layout.activity_camera;
    }

    @Override
    protected void findViews() {
        mGroupGridView = (ListView) findViewById(R.id.main_grid);
        mGridView = (GridView) findViewById(R.id.gv_all_image);
        mImageView = (ImageView) findViewById(R.id.iv_selected);
        mTitleName = (TextView) findViewById(R.id.tv_images);
        mNext = (TextView) findViewById(R.id.tv_next);
    }

    @Override
    protected void initEvent() {

        //图片文件夹的点击事件
        mGroupGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String folderName = list.get(position).getFolderName();
                List<String> mSubList = mGruopMap.get(folderName);
                setGridViewAdapter(folderName,mSubList);
                //设置标题名字
                mTitleName.setText(folderName);
                clickCamereList();
            }
        });

        //GridView的点击事件
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.e(HomeProtocol.TAG,mGridList.get(position)+"xxx");
//                loadSelectedImage(mGridList.get(position));
            }
        });
    }

    @Override
    protected void init() {

        mPoint = new Point(mImageView.getWidth(), mImageView.getHeight());
    }

    @Override
    protected void loadData() {
        getImages();
    }

    /**
     * 加载选择的图片进入大图框
     */
    private void loadSelectedImage(String path) {
//        Bitmap bitmap = NativeImageLoader.getInstance().loadNativeImage(path, null);
        Log.e("print-image", path);
        Bitmap bitmap = BitmapFactory.decodeFile(path);
        mImageView.setImageBitmap(bitmap);
    }

    /**
     * 头部标题的点击事件
     *
     * @param view
     */
    public void onClickTitle(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.iv_finish:
                finish();
                break;
            case R.id.tv_images:
                clickCamereList();
                break;
            case R.id.tv_next:
            //点击下一步
                ArrayList<String> selectedImages = (ArrayList<String>) getSelectedImages();
                if(selectedImages.size()>0){
                    if(selectedImages.size()>5){
                        TostUtils.ShowTost(this,"最多只能选择5张图");
                    }else {
                        Intent intent= new Intent(this,ImageEditActivity.class) ;
                        intent.putStringArrayListExtra("image",selectedImages);
                        startActivity(intent);
                    }

                }else {
                    TostUtils.ShowTost(this,"请选择图片");
                }
                break;
        }

    }

    private void clickCamereList() {
        if (isHint) {
            mGroupGridView.setVisibility(View.VISIBLE);
            isHint = false;
        } else {
            mGroupGridView.setVisibility(View.GONE);
            isHint = true;
        }
    }


    /**
     * 利用ContentProvider扫描手机中的图片，此方法在运行在子线程中
     */
    private void getImages() {
        //显示进度条
        mProgressDialog = ProgressDialog.show(this, null, "正在加载...");

        /**
         * 启动线程加载本地图片
         */
        new Thread(new Runnable() {
            @Override
            public void run() {
                Uri mImageUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                ContentResolver mContentResolver = CameraActivity.this.getContentResolver();
                //只查询jpeg和png的图片
                Cursor mCursor = mContentResolver.query(mImageUri, null,
                        MediaStore.Images.Media.MIME_TYPE + "=? or "
                                + MediaStore.Images.Media.MIME_TYPE + "=?",
                        new String[]{"image/jpeg", "image/png"}, MediaStore.Images.Media.DATE_MODIFIED);

                if (mCursor == null) {
                    return;
                }

                while (mCursor.moveToNext()) {
                    //获取图片的路径
                    String path = mCursor.getString(mCursor
                            .getColumnIndex(MediaStore.Images.Media.DATA));

                    //获取该图片的父路径名
                    String parentName = new File(path).getParentFile().getName();

                    //根据父路径名将图片放入到mGruopMap中
                    if (!mGruopMap.containsKey(parentName)) {
                        List<String> chileList = new ArrayList<String>();
                        chileList.add(path);
                        mGruopMap.put(parentName, chileList);
                    } else {
                        mGruopMap.get(parentName).add(path);
                    }
                }
                List<String> allImage = getAllImage(mGruopMap);
                mGruopMap.put(ALL_IMAGE_DIR,allImage);
                //通知Handler扫描图片完成
                mHandler.sendEmptyMessage(SCAN_OK);
                mCursor.close();
            }
        }).start();

    }


    /**
     * 组装分组界面GridView的数据源，因为我们扫描手机的时候将图片信息放在HashMap中
     * 所以需要遍历HashMap将数据组装成List
     *
     * @param mGruopMap
     * @return
     */
    private List<ImageBean> subGroupOfImage(HashMap<String, List<String>> mGruopMap) {
        if (mGruopMap.size() == 0) {
            return null;
        }
        List<ImageBean> list = new ArrayList<ImageBean>();
        List<String> allImageList = new ArrayList<>();
        Iterator<Map.Entry<String, List<String>>> it = mGruopMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, List<String>> entry = it.next();
            ImageBean mImageBean = new ImageBean();
            String key = entry.getKey();
            List<String> value = entry.getValue();
            allImageList.addAll(value);
            mImageBean.setFolderName(key);
            mImageBean.setImageCounts(value.size());
            mImageBean.setTopImagePath(value.get(0));//获取该组的第一张图片
            list.add(mImageBean);
        }
       /* //将所有图片合并成一个文件记录
        ImageBean allImage = new ImageBean();
        allImage.setFolderName(ALL_IMAGE_DIR);
        allImage.setImageCounts(allImageList.size());
        allImage.setTopImagePath(allImageList.get(0));//获取该组的第一张图片
        list.add(0, allImage);
        //将合并后的文件夹存入集合
        mGruopMap.put(allImage.getFolderName(), allImageList);*/
        return list;
    }

    /**
     * 获取所以图片的path
     * @param mGruopMap
     * @return
     */
    private List<String> getAllImage(HashMap<String, List<String>> mGruopMap) {
        List<String> mList = new ArrayList<>();
        for (String name : mGruopMap.keySet()) {
            mList.addAll(mGruopMap.get(name));
        }
        return mList;
    }

    private List<String> getSelectedImages(){
        List<String> selectedList=new ArrayList<>();
        for (String name : mGridViewAdapterList.keySet()) {
            List<Integer> selectItems = mGridViewAdapterList.get(name).getSelectItems();
            for (Integer position : selectItems) {
                //将选中的图片的path存入一个集合
                selectedList.add(mGruopMap.get(name).get(position));
            }
        }
        return selectedList;
    }

}
