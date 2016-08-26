package com.flame.icebound.taoworld.modules.find.util;

import android.util.Log;

import com.flame.icebound.taoworld.modules.find.bean.BaseInfo;
import com.flame.icebound.taoworld.modules.find.bean.FindListInfo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hasee on 2016/7/30.
 */
public class ParseFindListInfo {



    public static FindListInfo parseFindList(String result)
    {
        List<FindListInfo.ShareListBean> list = new ArrayList<FindListInfo.ShareListBean>();
        FindListInfo in = new FindListInfo();
        try
        {
            JSONObject jsonObject = new JSONObject(result);

            FindListInfo.ShareListBean info=null;
            JSONObject res = jsonObject.getJSONObject("rst");
            JSONArray shareList = res.getJSONArray("shareList");

            for (int i = 0; i < shareList.length(); i++)
            {
                /**
                 * 在遍历中加入try-catch防止跳出循环
                 */
                try
                {
                    JSONObject subJson=shareList.getJSONObject(i);
                    info=new FindListInfo.ShareListBean();

                    JSONArray imgs = subJson.getJSONArray("imgs");
                    String url = imgs.get(0).toString();

                    info.setImgs("http://img.taoshij.com"+url);
                    Log.e("print","================"+info.getImgs());
                    info.setReview_detail(subJson.getString("review_detail"));
                    info.setUser_head("http://img.taoshij.com"+subJson.getString("user_head"));
                    info.setLike_count(subJson.getString("like_count"));
                    info.setUser_name(subJson.getString("user_name"));
                    list.add(info);

                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
            in.setShareList(list);
            in.setType(BaseInfo.Type.FINDLISTINFO);
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
        return in;
    }
}
