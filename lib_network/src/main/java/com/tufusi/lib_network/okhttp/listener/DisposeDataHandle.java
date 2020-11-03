package com.tufusi.lib_network.okhttp.listener;

/**
 * Created by LeoCheung on 2020/11/3.
 *
 * @description
 */
public class DisposeDataHandle {

    public DisposeDataListener mListener;
    public Class<?> mClass = null;
    public String mSource = null;

    public DisposeDataHandle(DisposeDataListener listener) {
        this.mListener = listener;
    }

    public DisposeDataHandle(DisposeDataListener listener, Class<?> clazz) {
        this.mListener = listener;
        this.mClass = clazz;
    }

    public DisposeDataHandle(DisposeDataListener listener, String source) {
        this.mListener = listener;
        this.mSource = source;
    }
} 