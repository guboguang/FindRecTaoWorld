package com.qianfeng.recyclerviewmultylayout;

/**
 * Created by se7en on 16/7/20. BaseInfo的作用:1.存放多种类型所共有数据 2.承担了作为所有数据类型基类的作用
 */
public class BaseInfo
{
    private String id;

    private int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public interface NewsTypes
    {
        public static int NEWS_TYPE_SINGLE_LEFT = 0;

        public static int NEWS_TYPE_SINGLE_FULL = 1;

        public static int NEWS_TYPE_DOUBLE = 2;

        public static int NEWS_TYPE_THREE = 3;
    }
}
