package com.tufusi.ft_audio.mediaplayer.exception;

/**
 * Created by LeoCheung on 2020/11/12.
 *
 * @description 播放队列为空异常
 */
public class AudioQueueEmptyException extends RuntimeException {

    public AudioQueueEmptyException(String message) {
        super(message);
    }
}