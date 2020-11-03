package com.tufusi.lib_base.ft_audio.service;

import android.app.Activity;

import com.alibaba.android.arouter.facade.template.IProvider;
import com.tufusi.lib_base.ft_audio.model.CommonAudioBean;

import java.util.ArrayList;

/**
 * Created by LeoCheung on 2020/11/3.
 *
 * @description 音乐模块对外接口
 */
public interface AudioService extends IProvider {
    void pauseAudio();

    void resumeAudio();

    void addAudio(Activity activity, CommonAudioBean audioBean);

    void startMusicService(ArrayList<CommonAudioBean> audioBeans);
} 