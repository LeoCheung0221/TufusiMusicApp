package com.tufusi.ft_audio.mediaplayer.core;

import android.media.MediaPlayer;

import java.io.IOException;

/**
 * Created by LeoCheung on 2020/11/12.
 *
 * @description 自定义媒体播放器 维护播放各个状态
 */
public class CustomMediaPlayer extends MediaPlayer implements MediaPlayer.OnCompletionListener {

    private Status mState;
    private OnCompletionListener mOnCompletionListener;

    public enum Status {
        /**
         * 就绪状态
         */
        IDLE,
        /**
         * 初始化完成状态
         */
        INITIALIZED,
        /**
         * 开始状态
         */
        STARTED,
        /**
         * 暂停状态
         */
        PAUSED,
        /**
         * 停止状态
         */
        STOPPED,
        /**
         * 完成状态
         */
        COMPLETED
    }

    public CustomMediaPlayer() {
        super();
        mState = Status.IDLE;
        super.setOnCompletionListener(this);
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        mState = Status.COMPLETED;
        if (mOnCompletionListener != null) {
            mOnCompletionListener.onCompletion(mp);
        }
    }

    @Override
    public void setOnCompletionListener(OnCompletionListener mOnCompletionListener) {
        this.mOnCompletionListener = mOnCompletionListener;
    }

    @Override
    public void start() throws IllegalStateException {
        super.start();
        mState = Status.STARTED;
    }

    @Override
    public void pause() throws IllegalStateException {
        super.pause();
        mState = Status.PAUSED;
    }

    @Override
    public void stop() throws IllegalStateException {
        super.stop();
        mState = Status.STOPPED;
    }

    @Override
    public void reset() {
        super.reset();
        mState = Status.IDLE;
    }

    @Override
    public void setDataSource(String path) throws IOException, IllegalArgumentException, IllegalStateException, SecurityException {
        super.setDataSource(path);
    }

    public Status getState() {
        return mState;
    }

    public void setState(Status mState) {
        this.mState = mState;
    }
}