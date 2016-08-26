package com.flame.icebound.taoworld.modules.find.util;

import com.flame.icebound.taoworld.modules.find.bean.BaseInfo;
import com.flame.icebound.taoworld.modules.find.bean.Brandparent;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * 品牌热度
 * Created by hasee on 2016/7/30.
 */
public class ParseHotBrandInfo {
    public static Brandparent parseFindBrandList(String result)
    {
        Brandparent brandparent =null;
        List<Brandparent.BrandInfo> list = new ArrayList<Brandparent.BrandInfo>();
        try
        {
            Brandparent.BrandInfo info=null;
            brandparent = new Brandparent();

            JSONObject jsonObject = new JSONObject(result);
            JSONObject rst = jsonObject.getJSONObject("rst");
            JSONArray hotBrand = rst.getJSONArray("hotBrand");

            for (int i = 0; i < hotBrand.length(); i++)
            {

                /**
                 * 在遍历中加入try-catch防止跳出循环
                 */
                try
                {
                    JSONObject subJson=hotBrand.getJSONObject(i);
                    info=new Brandparent.BrandInfo();
                    ///品牌图片网址
                    info.setImage_path(subJson.getString("image_path"));

                    info.setFollowCount(subJson.getString("followCount"));
                    //品牌名称
                    info.setText_content(subJson.getString("text_content"));

                    //图片的超级连接
                    info.setUrl(subJson.getString("url"));
                    //点击统计
                    info.setFollowCount(subJson.getString("followCount"));

                    list.add(info);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }

            brandparent.setList(list);
            brandparent.setType(BaseInfo.Type.BRANDINFO);
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
        return brandparent;
    }
}
