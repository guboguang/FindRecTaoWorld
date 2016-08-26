package com.flame.icebound.taoworld.modules.find.activity;

import com.flame.icebound.taoworld.modules.find.bean.BaseInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hasee on 2016/8/22.
 */
public class Observer {

    private List<Watch> list;
    private static Observer instance = null;

    public void post(BaseInfo baseInfo) {

        for (int i = 0; i < list.size(); i++) {

            switch (list.get(i).type) {

                case BaseInfo.Type.BANNERS:

                    list.get(i).upDate(baseInfo);

                    break;

                case BaseInfo.Type.BRANDINFO:


                    list.get(i).upDate(baseInfo);

                    break;
            }

        }

    }

    private Observer() {
        list = new ArrayList<Watch>();
    }

    public static Observer getInstance() {

        synchronized (Observer.class) {
            if (instance == null) {
                instance = new Observer();
            }
            return instance;
        }
    }


    public void registWatch(Watch wacth) {
        list.add(wacth);
    }

    public void unRegistWatch(Watch wacth) {
        list.remove(wacth);
    }

    public abstract class Watch {

        public int type;

        public Watch(int type) {
            this.type = type;
        }

        abstract void upDate(Object baseInfo);


    }

    public interface Type{
        int IMAGE = 0;
        int VIDEO = 1;
    }

}
