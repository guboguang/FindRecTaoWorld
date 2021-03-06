package com.flame.icebound.taoworld.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by se7en on 16/7/11.
 */
public class WelComePagerAdapter extends PagerAdapter
{
    private List<ImageView> imageViewList;

    public WelComePagerAdapter(List<ImageView> imageViewList)
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
        ImageView iv = imageViewList.get(position);
        container.addView(iv);
        return iv;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object)
    {
        container.removeView(imageViewList.get(position));
    }
}
