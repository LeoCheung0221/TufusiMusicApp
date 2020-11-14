package com.tufusi.ft_audio.mediaplayer.core;

import com.tufusi.ft_audio.mediaplayer.db.GreenDaoHelper;
import com.tufusi.ft_audio.mediaplayer.events.AudioCompleteEvent;
import com.tufusi.ft_audio.mediaplayer.events.AudioErrorEvent;
import com.tufusi.ft_audio.mediaplayer.events.AudioFavouriteEvent;
import com.tufusi.ft_audio.mediaplayer.exception.AudioQueueEmptyException;
import com.tufusi.ft_audio.mediaplayer.model.AudioBean;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by LeoCheung on 2020/11/12.
 *
 * @description 控制播放逻辑类
 */
public class AudioController {

    private AudioPlayer mAudioPlayer;
    private int mQueueIndex = 0;
    private PlayMode mPlayMode = PlayMode.LOOP;
    // 播放队列，不能为空，否则会抛出异常
    private ArrayList<AudioBean> mQueue = new ArrayList<>();

    private AudioController() {
        EventBus.getDefault().register(this);
        mAudioPlayer = new AudioPlayer();
    }

    public static AudioController getInstance() {
        return AudioController.SingletonHandler.instance;
    }

    /**
     * 播放/暂停切换
     */
    public void playOrPause() {
        if (isStartState()) {
            pause();
        } else {
            resume();
        }
    }

    /**
     * 加载当前index歌曲
     */
    public void play() {
        AudioBean audioBean = getPlaying(mQueueIndex);
        load(audioBean);
    }

    /**
     * 加载previous index歌曲
     */
    public void previous() {
        AudioBean bean = getPreviousPlaying();
        load(bean);
    }

    /**
     * 加载next index歌曲
     */
    public void next() {
        AudioBean bean = getNextPlaying();
        load(bean);
    }

    /**
     * 释放播放器
     */
    public void release() {
        mAudioPlayer.release();
        EventBus.getDefault().unregister(this);
    }

    /**
     * 添加/移除到收藏
     */
    public void changeFavourite() {
        if (null != GreenDaoHelper.selectFavourite(getNowPlaying())) {
            // 已收藏 移除
            GreenDaoHelper.removeFavourite(getNowPlaying());
            EventBus.getDefault().post(new AudioFavouriteEvent(false));
        } else {
            // 未收藏 添加收藏
            GreenDaoHelper.addFavourite(getNowPlaying());
            EventBus.getDefault().post(new AudioFavouriteEvent(true));
        }
    }

    public void resume() {
        mAudioPlayer.resume();
    }

    public void pause() {
        mAudioPlayer.pause();
    }

    public void load(AudioBean audioBean) {
        mAudioPlayer.load(audioBean);
    }

    private AudioBean getPreviousPlaying() {
        switch (mPlayMode) {
            case LOOP:
                mQueueIndex = (mQueueIndex - 1) % mQueue.size();
                return getPlaying(mQueueIndex);
            case RANDOM:
                mQueueIndex = new Random().nextInt(mQueue.size()) % mQueue.size();
                return getPlaying(mQueueIndex);
            case REPEAT:
                return getPlaying(mQueueIndex);
            default:
                return null;
        }
    }

    private AudioBean getNextPlaying() {
        switch (mPlayMode) {
            case LOOP:
                mQueueIndex = (mQueueIndex + 1) % mQueue.size();
                return getPlaying(mQueueIndex);
            case RANDOM:
                mQueueIndex = new Random().nextInt(mQueue.size()) % mQueue.size();
                return getPlaying(mQueueIndex);
            case REPEAT:
                return getPlaying(mQueueIndex);
            default:
                return null;
        }
    }

    /**
     * 对外提供是否播放中状态
     */
    public boolean isStartState() {
        return CustomMediaPlayer.Status.STARTED == getStatus();
    }

    /**
     * 对外提提供是否暂停状态
     */
    public boolean isPauseState() {
        return CustomMediaPlayer.Status.PAUSED == getStatus();
    }

    private CustomMediaPlayer.Status getStatus() {
        return mAudioPlayer.getStatus();
    }

    public AudioBean getNowPlaying() {
        return getPlaying(mQueueIndex);
    }

    private AudioBean getPlaying(int index) {
        if (mQueue != null && !mQueue.isEmpty() && index >= 0 && index < mQueue.size()) {
            return mQueue.get(index);
        } else {
            throw new AudioQueueEmptyException("当前播放队列为空,请先设置播放队列。");
        }
    }

    /**
     * 队列头添加播放歌曲
     */
    public void addAudio(AudioBean bean) {
        this.addAudio(0, bean);
    }

    public void addAudio(int index, AudioBean bean) {
        if (mQueue == null) {
            throw new AudioQueueEmptyException("当前播放队列为空,请先设置播放队列.");
        }
        int queryAudio = queryAudio(bean);
        if (queryAudio <= -1) {
            // 没索引到该歌曲，添加并且直接播放
            addCustomAudio(index, bean);
            setPlayIndex(index);
        } else {
            AudioBean currentBean = getNowPlaying();
            if (!currentBean.id.equals(bean.id)) {
                // 添加过并且不是当前播放的，则播放，否则不播放
                setPlayIndex(queryAudio);
            }
        }
    }

    public void setPlayIndex(int queryIndex) {
        if (mQueue == null) {
            throw new AudioQueueEmptyException("当前播放队列为空,请先设置播放队列.");
        }
        mQueueIndex = queryIndex;
        play();
    }

    private void addCustomAudio(int index, AudioBean bean) {
        if (mQueue == null) {
            throw new AudioQueueEmptyException("当前播放队列为空,请先设置播放队列.");
        }
        mQueue.add(index, bean);
    }

    private int queryAudio(AudioBean bean) {
        return mQueue.indexOf(bean);
    }

    /**
     * 设置播放队列
     */
    public void setQueue(ArrayList<AudioBean> audioBeans) {
        setQueue(audioBeans, 0);
    }

    public void setQueue(ArrayList<AudioBean> audioBeans, int queueIndex) {
        mQueue.addAll(audioBeans);
        mQueueIndex = queueIndex;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onAudioCompleteEvent(AudioCompleteEvent event) {
        next();
    }

    //播放出错事件处理
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onAudioErrorEvent(AudioErrorEvent event) {
        next();
    }

    public ArrayList<AudioBean> getQueue() {
        return mQueue;
    }

    public PlayMode getPlayMode() {
        return mPlayMode;
    }

    public void setPlayMode(PlayMode playMode) {
        mPlayMode = playMode;
    }

    /**
     * 播放方式
     */
    public enum PlayMode {
        /**
         * 单曲循环
         */
        REPEAT,

        /**
         * 列表循环
         */
        LOOP,

        /**
         * 随机播放
         */
        RANDOM
    }

    private static class SingletonHandler {
        private static AudioController instance = new AudioController();
    }
}