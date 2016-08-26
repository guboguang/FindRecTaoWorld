package com.flame.icebound.taoworld.modules.shop.bean;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.bigkoo.convenientbanner.CBPageAdapter;
import com.flame.icebound.taoworld.util.ImageLoaderUtil;
import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * Created by Administrator on 2016/8/2.
 */
public class NewWorkImageHolderView implements CBPageAdapter.Holder<String> {

    private ImageView img;

    @Override
    public View createView(Context context) {
        img = new ImageView(context);
        img.setScaleType(ImageView.ScaleType.FIT_XY);
        return img;
    }

    @Override
    public void UpdateUI(Context context, int position, String data) {

        ImageLoader.getInstance().displayImage(data,img, ImageLoaderUtil.getDefaultOption());
    }
}
