package com.tufusi.ft_audio.mediaplayer.events;


import com.tufusi.ft_audio.mediaplayer.model.AudioBean;

/**
 * Created by LeoCheung on 2020/11/12.
 *
 * @description
 */
public class AudioLoadEvent {
    public AudioBean mAudioBean;

    public AudioLoadEvent(AudioBean audioBean) {
        this.mAudioBean = audioBean;
    }
}
