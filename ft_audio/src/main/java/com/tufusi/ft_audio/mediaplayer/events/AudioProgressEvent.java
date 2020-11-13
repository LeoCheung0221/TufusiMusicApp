package com.tufusi.ft_audio.mediaplayer.events;

import com.tufusi.ft_audio.mediaplayer.core.CustomMediaPlayer;

/**
 * Created by LeoCheung on 2020/11/12.
 *
 * @description
 */
public class AudioProgressEvent {

    public CustomMediaPlayer.Status mStatus;
    public int progress;
    public int maxLength;

    public AudioProgressEvent(CustomMediaPlayer.Status status, int progress, int maxLength) {
        this.mStatus = status;
        this.progress = progress;
        this.maxLength = maxLength;
    }
}
