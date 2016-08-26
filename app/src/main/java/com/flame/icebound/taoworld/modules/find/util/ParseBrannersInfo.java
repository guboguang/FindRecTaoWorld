package com.flame.icebound.taoworld.modules.find.util;

import com.flame.icebound.taoworld.modules.find.bean.Banners;
import com.flame.icebound.taoworld.modules.find.bean.BaseInfo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * ViewPager数据
 * Created by hasee on 2016/7/30.
 */
public class ParseBrannersInfo {

    public static Banners parseBanners(String result)
    {
        Banners in=null;
        List<Banners.BannersBean> list = new ArrayList<Banners.BannersBean>();
        try
        {
            Banners.BannersBean info=null;

            JSONObject jsonObject = new JSONObject(result);
            JSONObject rst = jsonObject.getJSONObject("rst");
            JSONArray hotBrand = rst.getJSONArray("banners");

            for (int i = 0; i < hotBrand.length(); i++)
            {

                /**
                 * 在遍历中加入try-catch防止跳出循环
                 */
                try
                {
                    JSONObject subJson=hotBrand.getJSONObject(i);
                    info=new Banners.BannersBean();
                    in = new Banners();
                    ///品牌图片网址
                    info.setImage_path(subJson.getString("image_path"));

                    info.setCommonId(subJson.getString("commonId"));
                    info.setImg("http://img.taoshij.com"+subJson.getString("img"));
                    info.setJump_url("http://img.taoshij.com"+subJson.getString("jump_url"));
                    //图片的超级连接
                    info.setUrl(subJson.getString("url"));
                    list.add(info);

                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
            in.setBanners(list);
            in.setType(BaseInfo.Type.BANNERS);
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }

        return in;
    }
}
