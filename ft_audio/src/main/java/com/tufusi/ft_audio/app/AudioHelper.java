package com.tufusi.ft_audio.app;

import android.app.Activity;
import android.content.Context;

import com.tufusi.ft_audio.mediaplayer.core.AudioController;
import com.tufusi.ft_audio.mediaplayer.core.MusicService;
import com.tufusi.ft_audio.mediaplayer.db.GreenDaoHelper;
import com.tufusi.ft_audio.mediaplayer.ui.MusicPlayerActivity;
import com.tufusi.ft_audio.mediaplayer.utils.Utils;
import com.tufusi.lib_base.ft_audio.model.CommonAudioBean;

import java.util.ArrayList;

/**
 * Created by LeoCheung on 2020/11/12.
 *
 * @description 唯一与外界通信的类
 */
public final class AudioHelper {

    private static Context mContext;

    public static Context getContext() {
        return mContext;
    }

    public static void init(Context context) {
        mContext = context;
        //初始化本地数据库
        GreenDaoHelper.initDatabase();
    }

    public static void addAudio(Activity activity, CommonAudioBean audioBean) {
        AudioController.getInstance().addAudio(Utils.convertFrom(audioBean));
        MusicPlayerActivity.start(activity);
    }

    //外部启动MusicService方法
    public static void startMusicService(ArrayList<CommonAudioBean> audioBeans) {
        MusicService.startMusicService(Utils.convertFrom(audioBeans));
    }
}