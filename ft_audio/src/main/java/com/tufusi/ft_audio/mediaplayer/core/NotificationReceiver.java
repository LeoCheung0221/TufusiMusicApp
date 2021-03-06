package com.tufusi.ft_audio.mediaplayer.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

import com.tufusi.ft_audio.app.AudioHelper;

/**
 * Created by LeoCheung on 2020/11/13.
 *
 * @description 直接动态注册广播 接收Notification发送的广播
 */
public class NotificationReceiver extends BroadcastReceiver {

    public static final String ACTION_STATUS_BAR =
            AudioHelper.getContext().getPackageName() + ".NOTIFICATION_ACTIONS";
    public static final String EXTRA = "extra";
    public static final String EXTRA_PLAY = "play_pause";
    public static final String EXTRA_PRE = "play_previous";
    public static final String EXTRA_NEXT = "play_next";
    public static final String EXTRA_FAV = "play_favourite";

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent == null || TextUtils.isEmpty(intent.getAction())) {
            return;
        }
        String extra = intent.getStringExtra(EXTRA);
        switch (extra) {
            case EXTRA_PLAY:
                //处理播放暂停事件,可以封到AudioController中
                AudioController.getInstance().playOrPause();
                break;
            case EXTRA_PRE:
                //不管当前状态，直接播放
                AudioController.getInstance().previous();
                break;
            case EXTRA_NEXT:
                AudioController.getInstance().next();
                break;
            case EXTRA_FAV:
                AudioController.getInstance().changeFavourite();
                break;
        }
    }
}