package com.tufusi.lib_webview.adbrowser;

import android.content.Context;
import android.webkit.WebSettings;
import android.webkit.WebView;

/**
 * Created by LeoCheung on 2020/11/3.
 *
 * @description 自定义WebView，设置一些能用的参数
 */
public class BrowserWebView extends WebView {

    public BrowserWebView(Context context) {
        super(context);
        init();
    }

    private void init() {
        WebSettings webSettings = getSettings();
        webSettings.setJavaScriptEnabled(true);

        webSettings.setPluginState(WebSettings.PluginState.ON);

        webSettings.setBuiltInZoomControls(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);
        setInitialScale(1);
    }
} 