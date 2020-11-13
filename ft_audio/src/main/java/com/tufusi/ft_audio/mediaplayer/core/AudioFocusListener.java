package com.tufusi.ft_audio.mediaplayer.core;

/**
 * Created by LeoCheung on 2020/11/12.
 *
 * @description 音频焦点改变回调接口
 */
public interface AudioFocusListener {

    /**
     * 获得焦点回调接口
     */
    void audioFocusGrant();

    /**
     * 永久失去焦点回调接口
     */
    void audioFocusLoss();

    /**
     * 短暂失去焦点回调接口
     */
    void audioFocusLossTransient();

    /**
     * 瞬间失去焦点回调接口
     */
    void audioFocusLossDuck();
}
