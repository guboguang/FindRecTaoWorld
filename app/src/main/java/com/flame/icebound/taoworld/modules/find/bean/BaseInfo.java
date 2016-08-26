package com.flame.icebound.taoworld.modules.find.bean;

/**
 * Created by hasee on 2016/8/10.
 */
public class BaseInfo {

    public String commonId;
    private int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getCommonId() {
        return commonId;
    }

    public void setCommonId(String commonId) {
        this.commonId = commonId;
    }

    public interface Type{
        public static int BANNERS = 0;
        public static int BRANDINFO = 1;
        public static int FINDLISTINFO = 2;
        public static int HOTFOURCATEGORY = 3;
    }


}
