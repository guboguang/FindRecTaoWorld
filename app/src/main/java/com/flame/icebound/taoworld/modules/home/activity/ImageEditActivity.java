package com.flame.icebound.taoworld.modules.home.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.flame.icebound.taoworld.R;
import com.flame.icebound.taoworld.activity.BaseActivity;
import com.flame.icebound.taoworld.modules.home.bean.ImageTagInfo;
import com.flame.icebound.taoworld.modules.home.util.NativeImageLoader;
import com.flame.icebound.taoworld.modules.home.util.TostUtils;
import com.flame.icebound.taoworld.modules.home.widget.ImageTagView;

import java.util.ArrayList;

public class ImageEditActivity extends BaseActivity  {


    private int[] imageId;
    private ArrayList<String> selectImage;
    private ImageView mSelectImage;
    private EditText mBrand;
    private EditText mLocation;
    private EditText mPrice;
    private LinearLayout mAddTag;
    private FrameLayout mTagContainer;

    @Override
    protected int setLayout() {
        Intent intent = getIntent();
        selectImage = intent.getStringArrayListExtra("image");
        return R.layout.activity_image_edit;
    }

    @Override
    protected void findViews() {
        imageId = new int[]{R.id.iv_one, R.id.iv_two, R.id.iv_three, R.id.iv_four, R.id.iv_five};
        mSelectImage = (ImageView) findViewById(R.id.iv_selected);
        //标签容器
        mTagContainer = (FrameLayout) findViewById(R.id.fl_label);
        mAddTag = (LinearLayout) findViewById(R.id.ll_add_tag);
        mBrand = (EditText) findViewById(R.id.ed_brand);
        mLocation = (EditText) findViewById(R.id.ed_location);
        mPrice = (EditText) findViewById(R.id.ed_price);

    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void init() {
        for (int i = 0; i < selectImage.size(); i++) {
            ImageView mImage = (ImageView) findViewById(imageId[i]);
            mImage.setVisibility(View.VISIBLE);
            final String path = selectImage.get(i);
            loadImage(path, mImage);
            //设置点击事件
            mImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    loadImage(path, mSelectImage);
                }
            });
        }
        //初始化大图
        loadImage(selectImage.get(0), mSelectImage);
        TextView tvDrag= (TextView) findViewById(R.id.tv_drag);
      /*  //添加拖拽
        View.OnTouchListener mTouchList = new MyOnTouchListener(tvDrag);
        tvDrag.setOnTouchListener(mTouchList);*/
    }

    private void loadImage(String path, ImageView imageView) {
        Bitmap bitmap = NativeImageLoader.getInstance().loadNativeImage(path,
                new Point(imageView.getWidth(), imageView.getHeight()), null);
        imageView.setImageBitmap(bitmap);
    }

    @Override
    protected void loadData() {

    }

    /**
     * 头部标题的点击事件
     *
     * @param view
     */
    public void onClickTitle(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_next:
                break;
            // 添加标签
            case R.id.tv_tag:
                addTag();
                break;
            // 添加贴纸
            case R.id.tv_paster:
                break;
            // 添加滤镜
            case R.id.tv_filter:
                break;
            // 取消添加
            case R.id.tv_cancle:
                mAddTag.setVisibility(View.GONE);
                clearAddTag();
                break;
            // 完成添加
            case R.id.tv_ok:
                finashAddTag();
                break;
        }

    }

    /**
     * 完成添加标签
     */
    private void finashAddTag() {
        String brand = mBrand.getText().toString();
        String location = mLocation.getText().toString();
        String price = mPrice.getText().toString();
        if (TextUtils.isEmpty(brand)) {
            TostUtils.ShowTost(this, "品牌不能为空");
            return;
        }
        mAddTag.setVisibility(View.GONE);
        clearAddTag();
        ImageTagInfo mTagInfo = new ImageTagInfo(brand, price, location, new ImageTagInfo.Position(0.5, 0.5));
        final ImageTagView view = (ImageTagView) View.inflate(this, R.layout.item_home_image_tag, null);
        view.setImageTag(mTagInfo);
        //添加拖拽
       /* View.OnTouchListener mTouchList = new MyOnTouchListener(view);
        view.setOnTouchListener(mTouchList);*/
        mTagContainer.addView(view);
    }

    private void clearAddTag() {
        mBrand.setText("");
        mLocation.setText("");
        mPrice.setText("");
    }

    /**
     * 给商品添加标签
     */
    private void addTag() {
        //编辑页可见
        mAddTag.setVisibility(View.VISIBLE);

    }


}

/**
 * ImageTag的触摸事件
 */
class MyOnTouchListener implements View.OnTouchListener {
    View mView;
    int downX = 0;
    int downY = 0;
    public MyOnTouchListener(View mView) {
        this.mView = mView;
    }

    //Tag的触摸监听
    @Override
    public boolean onTouch(View v, MotionEvent event) {

        //执行拖拽事件
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                //记录手指点下的位置
                downX = (int) event.getRawX();
                downY = (int) event.getRawY();
                break;
            case MotionEvent.ACTION_MOVE:
                int x = (int)event.getRawX();
                int y = (int)event.getRawY();
                int distanceX = x - downX;
                int distanceY = y - downY;

                // 得到imageView最开始的各顶点的坐标
                int l = mView.getLeft();
                int r = mView.getRight();
                int t = mView.getTop();
                int b = mView.getBottom();
                // 更改imageView在窗体的位置
                mView.layout(l + distanceX, t + distanceY, r + distanceX, b + distanceY);
                // 获取移动后的位置
                downX = (int) event.getRawX();
                downY = (int) event.getRawY();
                break;
        }
        //持续传递触摸事件
        return true;

    }
}
