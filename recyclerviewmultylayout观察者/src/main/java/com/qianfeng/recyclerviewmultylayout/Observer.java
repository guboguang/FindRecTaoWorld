package com.qianfeng.recyclerviewmultylayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by se7en on 16/7/25.
 */
public class Observer {

    private static Observer instance;

    private List<Watcher> watchers;

    private Observer() {
        watchers = new ArrayList<Watcher>();
    }

    public static Observer getInstance() {
        if (instance == null) {
            synchronized (Observer.class) {
                if (instance == null) {
                    instance = new Observer();
                }
            }
        }
        return instance;
    }

    /**
     * 注册被观察者(将接口实现层的对象加入到接口集合中)
     */
    public void registWatcher(Watcher watcher) {
        this.watchers.add(watcher);
    }

    /**
     * 注销被观察者(将接口实现层的对象从接口集合中移除)
     */
    public void unRegistWatcher(Watcher watcher) {
        this.watchers.remove(watcher);
    }

    /**
     * 发送消息
     */
    public void post(Object info,int type) {

        for (int i = 0; i < watchers.size(); i++) {

            Watcher w = watchers.get(i);

            if (type == w.type) {
                //TODO 将消息发送到图片新闻模块
                w.update(info);
            } else if (type == w.type) {
                //TODO 将消息发送到视频新闻模块
                w.update(info);
            }
        }
    }

    /**
     * 被观察者
     */
    public abstract static class Watcher {

        public int type;

        public Watcher(int type) {
            this.type = type;
        }


        abstract void update(Object info);
    }

    public interface Type {
        int IMAGE = 0;

        int VIDEO = 1;
    }
}
