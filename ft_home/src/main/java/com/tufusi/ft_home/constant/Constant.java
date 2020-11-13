package com.tufusi.ft_home.constant;

import android.Manifest;

/**
 * Created by LeoCheung on 2020/11/12.
 *
 * @description 常量类
 */
public class Constant {
    /**
     * 权限常量相关
     */
    public static final int WRITE_READ_EXTERNAL_CODE = 0x01;
    public static final String[] WRITE_READ_EXTERNAL_PERMISSION = new String[]{
            Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE
    };

    public static final int HARDWARE_CAMERA_CODE = 0x02;
    public static final String[] HARDWARE_CAMERA_PERMISSION = new String[]{Manifest.permission.CAMERA};

    /**
     * Router相关
     */
    public class Router {
        public static final String ROUTER_CAPTURE_ACTIVITY = "/qrcode/capture_activity";
        public static final String ROUTER_MUSIC_ACTIVITY = "/audio/music_activity";
        public static final String ROUTER_WEB_ACTIVITY = "/webview/web_activity";
    }
} 