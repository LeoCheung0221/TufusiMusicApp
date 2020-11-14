package com.tufusi.ft_audio.mediaplayer.view;

import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.tufusi.ft_audio.R;
import com.tufusi.ft_audio.mediaplayer.core.AudioController;
import com.tufusi.ft_audio.mediaplayer.events.AudioLoadEvent;
import com.tufusi.ft_audio.mediaplayer.events.AudioPlayModeEvent;
import com.tufusi.ft_audio.mediaplayer.model.AudioBean;
import com.tufusi.ft_audio.mediaplayer.view.adapter.MusicListAdapter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

/**
 * Created by LeoCheung on 2020/11/13.
 *
 * @description 播放器底部对话框
 */
public class MusicListDialog extends BottomSheetDialog {

    private Context mContext;
    private DisplayMetrics mDisplayMetrics;
    private ArrayList<AudioBean> mQueue;
    private AudioBean mAudioBean;
    private AudioController.PlayMode mPlayMode;
    private ImageView mTipView;
    private TextView mPlayModeView;
    private RecyclerView mRecyclerView;
    private MusicListAdapter mMusicListAdapter;

    public MusicListDialog(@NonNull Context context) {
        super(context);
        mContext = context;
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDisplayMetrics = mContext.getResources().getDisplayMetrics();
        setContentView(R.layout.dialog_bottom_sheet);
        initData();
        initView();
    }

    private void initView() {
        Window window = getWindow();
        WindowManager.LayoutParams params = window.getAttributes();
        params.width = mDisplayMetrics.widthPixels;
        window.setAttributes(params);

        setCancelable(true);
        setCanceledOnTouchOutside(true);

        mTipView = findViewById(R.id.mode_image_view);
        mPlayModeView = findViewById(R.id.mode_text_view);
        mPlayModeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (mPlayMode) {
                    case LOOP:
                        AudioController.getInstance().setPlayMode(AudioController.PlayMode.RANDOM);
                        break;
                    case RANDOM:
                        AudioController.getInstance().setPlayMode(AudioController.PlayMode.REPEAT);
                        break;
                    case REPEAT:
                        AudioController.getInstance().setPlayMode(AudioController.PlayMode.LOOP);
                        break;
                }
            }
        });
        // 更新UI
        updatePlayModeView();
        // 初始化列表
        mRecyclerView = findViewById(R.id.recycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mMusicListAdapter = new MusicListAdapter(mContext, mQueue, mAudioBean);
        mRecyclerView.setAdapter(mMusicListAdapter);
    }

    private void initData() {
        // 当前播放歌曲，用来初始化UI
        mQueue = AudioController.getInstance().getQueue();
        mAudioBean = AudioController.getInstance().getNowPlaying();
        mPlayMode = AudioController.getInstance().getPlayMode();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onAudioLoadEvent(AudioLoadEvent event) {
        mAudioBean = event.mAudioBean;
        //更新列表
        updateList();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onAudioPlayModeEvent(AudioPlayModeEvent event) {
        mPlayMode = event.mPlayMode;
        //更新播放模式
        updatePlayModeView();
    }

    private void updatePlayModeView() {
        switch (mPlayMode) {
            case LOOP:
                mTipView.setImageResource(R.mipmap.loop);
                mPlayModeView.setText("列表循环");
                break;
            case RANDOM:
                mTipView.setImageResource(R.mipmap.random);
                mPlayModeView.setText("随机播放");
                break;
            case REPEAT:
                mTipView.setImageResource(R.mipmap.once);
                mPlayModeView.setText("单曲循环");
                break;
        }
    }

    private void updateList() {
        mMusicListAdapter.updateAdapter(mAudioBean);
    }

    @Override
    public void dismiss() {
        super.dismiss();
        EventBus.getDefault().unregister(this);
    }
}