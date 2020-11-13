package com.tufusi.music;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.tufusi.ft_audio.app.AudioHelper;

/**
 * Created by LeoCheung on 2020/11/12.
 *
 * @description
 */
public class TufusiHiApplication extends Application {

    private static TufusiHiApplication mApplication = null;


    @Override
    public void onCreate() {
        super.onCreate();
        mApplication = this;

        // 视频SDK初始化

        // 音频SDK初始化
        AudioHelper.init(this);

        // 分享SDK初始化

        // 更新组件初始化

        // ARouter初始化
        ARouter.init(this);
    }

    public static TufusiHiApplication getInstance() {
        return mApplication;
    }
}