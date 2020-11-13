package com.tufusi.ft_home.model.friend;

import com.tufusi.lib_base.BaseModel;
import com.tufusi.lib_base.ft_audio.model.CommonAudioBean;

import java.util.ArrayList;

/**
 * Created by LeoCheung on 2020/11/12.
 *
 * @description
 */
public class FriendBodyValue extends BaseModel {
    public int type;
    public String avatr;
    public String name;
    public String fans;
    public String text;
    public ArrayList<String> pics;
    public String videoUrl;
    public String zan;
    public String msg;
    public CommonAudioBean audioBean;
} 