package com.tufusi.ft_audio.mediaplayer.view;

import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;

import androidx.annotation.NonNull;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by LeoCheung on 2020/11/13.
 *
 * @description 播放器底部对话框
 */
public class MusicListDialog extends BottomSheetDialog {

    private Context mContext;
    private DisplayMetrics mDisplayMetrics;

    public MusicListDialog(@NonNull Context context) {
        super(context);
        mContext = context;
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDisplayMetrics = mContext.getResources().getDisplayMetrics();
    }
}