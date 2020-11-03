package com.tufusi.lib_network.okhttp.listener;

/**
 * Created by LeoCheung on 2020/11/3.
 *
 * @description 监听下载进度
 */
public interface DisposeDownloadListener extends DisposeDataListener {
    void onProgress(int progress);
} 