package com.tufusi.ft_audio.mediaplayer.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;

import com.tufusi.ft_audio.R;

public class MusicPlayerActivity extends AppCompatActivity {

    public static void start(Activity context) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_player);
    }
}