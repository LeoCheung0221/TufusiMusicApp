package com.tufusi.ft_audio.mediaplayer.events;

/**
 * Created by LeoCheung on 2020/11/12.
 *
 * @description 收藏/取消收藏事件
 */
public class AudioFavouriteEvent {
    public boolean isFavourite;

    public AudioFavouriteEvent(boolean isFavourite) {
        this.isFavourite = isFavourite;
    }
}
