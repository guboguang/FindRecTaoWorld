package com.flame.icebound.taoworld.modules.home.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/7/31.
 */
public class TostUtils {

    private static Toast toast;

    public static  void ShowTost(Context context, String msg){
        if(toast==null){
            toast = Toast.makeText(context, "", Toast.LENGTH_SHORT);
        }
        toast.setText(msg);
        toast.show();
    }
}
