package com.flame.icebound.taoworld;

import android.app.Application;
import android.os.Environment;

import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.se7en.utils.SystemUtil;

import java.io.File;

/**
 * Created by se7en on 16/7/11.
 */
public class TaoWorldApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initLibs();
        initImageLoader();
    }

    private void initLibs() {
        SystemUtil.setContext(this);
    }

    /**
     * 初始化ImageLoader
     */
    private void initImageLoader() {
        String cachePath = "";
        //处于挂载状态,sdcard可以使用
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
            cachePath = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "taoworld";
        } else {
            cachePath = Environment.getDataDirectory().getAbsolutePath() + File.separator + "taoworld";
        }
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this).
                //设置内存缓存大小
                        memoryCache(new LruMemoryCache((int) (Runtime.getRuntime().maxMemory() / 8))).
                //设置磁盘缓存路径
                        diskCache(new UnlimitedDiskCache(new File(cachePath))).
                //设置加载图片的线程池的数量
                        threadPoolSize(4).
                //设置二次采样的阀值
                        memoryCacheExtraOptions(200, 200).build();
        ImageLoader.getInstance().init(config);
    }
}
