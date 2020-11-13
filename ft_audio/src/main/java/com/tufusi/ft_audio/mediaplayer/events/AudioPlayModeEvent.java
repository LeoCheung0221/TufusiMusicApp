package com.tufusi.ft_audio.mediaplayer.events;

import com.tufusi.ft_audio.mediaplayer.core.AudioController;

/**
 * Created by LeoCheung on 2020/11/12.
 *
 * @description 播放模式切换事件
 */
public class AudioPlayModeEvent {
    public AudioController.PlayMode mPlayMode;

    public AudioPlayModeEvent(AudioController.PlayMode playMode) {
        this.mPlayMode = playMode;
    }
}
