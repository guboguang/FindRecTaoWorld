package com.flame.icebound.taoworld.modules.home.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import java.util.List;

/**
 * Created by se7en on 16/7/11.
 */
public class ImagePagerAdapter extends PagerAdapter
{
    private List<RelativeLayout> imageViewList;

    public ImagePagerAdapter(List<RelativeLayout> imageViewList)
    {
        this.imageViewList=imageViewList;
    }

    @Override
    public int getCount()
    {
        return imageViewList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object)
    {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position)
    {
        RelativeLayout iv = imageViewList.get(position);
        container.addView(iv);
        return iv;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object)
    {
        container.removeView(imageViewList.get(position));
    }
}
