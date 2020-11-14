package com.tufusi.ft_audio.mediaplayer.view.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tufusi.ft_audio.R;
import com.tufusi.ft_audio.mediaplayer.core.AudioController;
import com.tufusi.ft_audio.mediaplayer.model.AudioBean;

import java.util.ArrayList;

/**
 * Created by LeoCheung on 2020/11/14.
 *
 * @description
 */
public class MusicListAdapter extends RecyclerView.Adapter<MusicListAdapter.MusicViewHolder> {

    private Context mContext;
    private ArrayList<AudioBean> mAudioListBean;
    private AudioBean mCurrentBean;

    public MusicListAdapter(Context context, ArrayList<AudioBean> queue, AudioBean audioBean) {
        this.mContext = context;
        this.mAudioListBean = queue;
        this.mCurrentBean = audioBean;
    }

    @NonNull
    @Override
    public MusicListAdapter.MusicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MusicViewHolder(LayoutInflater.from(mContext).inflate(R.layout.dialog_bottom_sheet_item, null));
    }

    @Override
    public void onBindViewHolder(@NonNull MusicViewHolder holder, int position) {
        final AudioBean bean = mAudioListBean.get(position);
        holder.mLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AudioController.getInstance().addAudio(bean);
            }
        });
        holder.name.setText(bean.name);
        holder.author.setText(
                new StringBuilder().append(" ").append("-").append(" ").append(bean.author));
        if (bean.id.equals(mCurrentBean.id)) {
            //为播放中歌曲，红色提醒
            holder.tip.setVisibility(View.VISIBLE);
            holder.name.setTextColor(
                    mContext.getResources().getColor(android.R.color.holo_red_light));
            holder.author.setTextColor(
                    mContext.getResources().getColor(android.R.color.holo_red_light));
        } else {
            holder.tip.setVisibility(View.GONE);
            holder.name.setTextColor(Color.parseColor("#333333"));
            holder.author.setTextColor(Color.parseColor("#333333"));
        }
    }

    @Override
    public int getItemCount() {
        return mAudioListBean == null ? 0 : mAudioListBean.size();
    }

    //更新Adapter状态
    public void updateAdapter(AudioBean bean) {
        mCurrentBean = bean;
        notifyDataSetChanged();
    }

    public static class MusicViewHolder extends RecyclerView.ViewHolder {

        private RelativeLayout mLayout;
        private TextView name;
        private TextView author;
        private ImageView tip;

        public MusicViewHolder(@NonNull View itemView) {
            super(itemView);

            mLayout = itemView.findViewById(R.id.item_layout);
            tip = itemView.findViewById(R.id.tip_view);
            name = itemView.findViewById(R.id.item_name);
            author = itemView.findViewById(R.id.item_author);
        }
    }
}