package com.tufusi.lib_network.okhttp.listener;

import java.util.ArrayList;

/**
 * Created by LeoCheung on 2020/11/3.
 *
 * @description 当需要专门处理Cookie时创建此回调接口
 */
public interface DisposeHandleCookieListener extends DisposeDataListener {

    void onCookie(ArrayList<String> cookieStrLists);
} 