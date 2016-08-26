package com.flame.icebound.taoworld.modules.shop.bean;

/**
 * Created by Administrator on 2016/7/30.
 */
public class BaseItemInfo {

    private int _id;
    private int type;

    public int get_Id() {
        return _id;
    }

    public void set_Id(int _id) {
        this._id = _id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public interface ShopTpyes{
        public static int SHOP_TYPE_TODAY=0;
        public static int SHOP_TYPE_DOUBLE=1;
        public static int SHOP_TYPE_SINGLE_TEXT=2;
        public static int SHOP_TYPE_SORT=3;
    }
}
