package com.flame.icebound.taoworld.modules.find.util;

import com.flame.icebound.taoworld.modules.find.bean.HotFourCategory;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hasee on 2016/7/30.
 */
public class ParseHotFourCategoryInfo {
    public static List<HotFourCategory.HotFourCategoryBean> parseFindHotFourCategory(String result)
    {
        List<HotFourCategory.HotFourCategoryBean> list = new ArrayList<HotFourCategory.HotFourCategoryBean>();
        try
        {
            HotFourCategory.HotFourCategoryBean info=null;
            JSONObject jsonObject = new JSONObject(result);
            JSONObject rst = jsonObject.getJSONObject("rst");
            JSONArray hotFourCategory = rst.getJSONArray("hotFourCategory");

            for (int i = 0; i < hotFourCategory.length(); i++)
            {

                /**
                 * 在遍历中加入try-catch防止跳出循环
                 */
                try
                {
                    JSONObject subJson=hotFourCategory.getJSONObject(i);
                    info=new HotFourCategory.HotFourCategoryBean();
                    ///品牌图片网址
                    info.setImage_path("http://img.taoshij.com"+subJson.getString("image_path"));

                    info.setCommonId(subJson.getString("commonId"));
                    info.setOneTitle(subJson.getString("oneTitle"));

                    //图片的超级连接
                    info.setUrl(subJson.getString("url"));

                    list.add(info);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
        return list;
    }
}
