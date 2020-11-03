package com.tufusi.lib_video.app;

import android.content.Context;

/**
 * Created by LeoCheung on 2020/11/3.
 *
 * @description 用来为调用者创建视频
 */
public final class VideoHelper {

    //SDK全局Context
    private static Context mContext;

    public static void init(Context context) {
        mContext = context;
        //初始化SDK的时候，初始化Realm数据库
    }

    public static Context getContext() {
        return mContext;
    }
} 