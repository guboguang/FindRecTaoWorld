package com.flame.icebound.taoworld.modules.home.adapter;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.GridView;
import android.widget.ImageView;

import com.flame.icebound.taoworld.R;
import com.flame.icebound.taoworld.modules.home.util.NativeImageLoader;
import com.flame.icebound.taoworld.modules.home.widget.MyImageView;
import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ObjectAnimator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ChildAdapter extends BaseAdapter {

    //获取屏幕高度

    private Point mPoint = new Point(0, 0);//用来封装ImageView的宽和高的对象
    /**
     * 用来存储图片的选中情况
     */
    private HashMap<Integer, Boolean> mSelectMap = new HashMap<Integer, Boolean>();
    private GridView mGridView;
    private List<String> list;
    protected LayoutInflater mInflater;
    private ImageView mImageView;
    private Context mContext;

    public ChildAdapter(Context context, List<String> list, GridView mGridView, ImageView mImageView) {
        this.list = list;
        this.mGridView = mGridView;
        mInflater = LayoutInflater.from(context);
        this.mImageView = mImageView;
        this.mContext = context;
    }

    /**
     * 加载选择的图片进入大图框
     */
    private void loadSelectedImage(String path) {
        Log.e("print-image", path);
        Bitmap bitmap = BitmapFactory.decodeFile(path);
        mImageView.setImageBitmap(bitmap);
    }

    @Override
    public int getCount() {
        return list.size() + 1;
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }


    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        //设置大图显示
        if(position==1){
            loadSelectedImage(list.get(0));
        }
        final ViewHolder viewHolder;

        if (convertView == null || convertView instanceof ImageView) {
            convertView = mInflater.inflate(R.layout.item_image_grild_view, null);
            viewHolder = new ViewHolder();
            viewHolder.mImageView = (MyImageView) convertView.findViewById(R.id.iv_pic);
            viewHolder.mCheckBox = (CheckBox) convertView.findViewById(R.id.cb_select);
            //使item的控件的高度一致
            AbsListView.LayoutParams param = new AbsListView.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    mGridView.getWidth() / 4);
            convertView.setLayoutParams(param);
            //用来监听ImageView的宽和高  
            viewHolder.mImageView.setOnMeasureListener(new MyImageView.OnMeasureListener() {

                @Override
                public void onMeasureSize(int width, int height) {
                    mPoint.set(width, height);
                }
            });
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            viewHolder.mImageView.setImageResource(R.mipmap.ic_launcher);
        }

        //第一个item的图片
        if(position==0){
            viewHolder.mCheckBox.setVisibility(View.GONE);
            viewHolder.mImageView.setImageResource(R.mipmap.transformer_ic_camera);
            viewHolder.mImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            return  convertView;
        }

        //其余item
        viewHolder.mCheckBox.setVisibility(View.VISIBLE);
        viewHolder.mImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

        String path = list.get(position - 1);
        viewHolder.mImageView.setTag(path);
        //图片的点击监听
        viewHolder.mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //图片点击后复选框为true
                viewHolder.mCheckBox.setChecked(true);
            }
        });

        //复选框的点击监听
        viewHolder.mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    loadSelectedImage(list.get(position - 1));
                    addAnimation(mImageView);
                }
                //如果是未选中的CheckBox,则添加动画
                if (!mSelectMap.containsKey(position - 1) || !mSelectMap.get(position - 1)) {
                    addAnimation(viewHolder.mCheckBox);
                }
                mSelectMap.put(position - 1, isChecked);
            }
        });

        viewHolder.mCheckBox.setChecked(mSelectMap.containsKey(position - 1) ? mSelectMap.get(position - 1) : false);

        //利用NativeImageLoader类加载本地图片
        Bitmap bitmap = NativeImageLoader.getInstance().loadNativeImage(path, mPoint, new NativeImageLoader.NativeImageCallBack() {

            @Override
            public void onImageLoader(Bitmap bitmap, String path) {
                ImageView mImageView = (ImageView) mGridView.findViewWithTag(path);
                if (bitmap != null && mImageView != null) {
                    mImageView.setImageBitmap(bitmap);
                }
            }
        });

        if (bitmap != null) {
            viewHolder.mImageView.setImageBitmap(bitmap);
        } else {
            viewHolder.mImageView.setImageResource(R.mipmap.ic_launcher);
        }

        return convertView;
    }

    /**
     * 给CheckBox加点击动画，利用开源库nineoldandroids设置动画
     *
     * @param view
     */
    private void addAnimation(View view) {
        float[] vaules = new float[]{0.5f, 0.6f, 0.7f, 0.8f, 0.9f, 1.0f, 1.1f, 1.2f, 1.3f, 1.25f, 1.2f, 1.15f, 1.1f, 1.0f};
        AnimatorSet set = new AnimatorSet();
        set.playTogether(ObjectAnimator.ofFloat(view, "scaleX", vaules),
                ObjectAnimator.ofFloat(view, "scaleY", vaules));
        set.setDuration(150);
        set.start();
    }


    /**
     * 获取选中的Item的position
     *
     * @return
     */
    public List<Integer> getSelectItems() {
        List<Integer> list = new ArrayList<Integer>();
        for (Iterator<Map.Entry<Integer, Boolean>> it = mSelectMap.entrySet().iterator(); it.hasNext(); ) {
            Map.Entry<Integer, Boolean> entry = it.next();
            if (entry.getValue()) {
                list.add(entry.getKey());
            }
        }
        return list;
    }


    public static class ViewHolder {
        public MyImageView mImageView;
        public CheckBox mCheckBox;
    }


}  