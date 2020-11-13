package com.tufusi.ft_audio.mediaplayer.core;

import android.content.Context;
import android.media.AudioManager;

/**
 * Created by LeoCheung on 2020/11/12.
 *
 * @description
 */
public class AudioFocusManager implements AudioManager.OnAudioFocusChangeListener {

    private AudioManager audioManager;
    private AudioFocusListener mAudioFocusListener;

    public AudioFocusManager(Context context, AudioFocusListener listener) {
        audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        mAudioFocusListener = listener;
    }

    @Override
    public void onAudioFocusChange(int focusChange) {

    }

    public void abandonAudioFocus() {
        audioManager.abandonAudioFocus(this);
    }

    public boolean requestAudioFocus() {
        return audioManager.requestAudioFocus(this, AudioManager.STREAM_MUSIC,
                AudioManager.AUDIOFOCUS_GAIN) == AudioManager.AUDIOFOCUS_REQUEST_GRANTED;
    }
}