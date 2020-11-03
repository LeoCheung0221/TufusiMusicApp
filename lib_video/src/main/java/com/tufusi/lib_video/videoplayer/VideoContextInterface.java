package com.tufusi.lib_video.videoplayer;

/**
 * Created by LeoCheung on 2020/11/3.
 *
 * @description 与应用层通信接口
 */
public interface VideoContextInterface {

    void onVideoSuccess();

    void onVideoFailed();

    void onVideoComplete();
} 