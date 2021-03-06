package com.tufusi.ft_home.api;

import com.tufusi.ft_home.model.discovery.BaseRecommendModel;
import com.tufusi.ft_home.model.discovery.BaseRecommendMoreModel;
import com.tufusi.ft_home.model.friend.BaseFriendModel;
import com.tufusi.lib_network.okhttp.CommonOkHttpClient;
import com.tufusi.lib_network.okhttp.listener.DisposeDataHandle;
import com.tufusi.lib_network.okhttp.listener.DisposeDataListener;
import com.tufusi.lib_network.okhttp.request.CommonRequest;
import com.tufusi.lib_network.okhttp.request.RequestParams;

/**
 * Created by LeoCheung on 2020/11/12.
 *
 * @description 请求中心
 */
public class RequestCenter {
    static class HttpConstants {

        private static final String ROOT_URL = "http://imooc.com/api";
        //private static final String ROOT_URL = "http://39.97.122.129";

        /**
         * 首页请求接口
         */
        private static String HOME_RECOMMEND = ROOT_URL + "/module_voice/home_recommand";

        private static String HOME_RECOMMEND_MORE = ROOT_URL + "/module_voice/home_recommand_more";

        private static String HOME_FRIEND = ROOT_URL + "/module_voice/home_friend";
    }

    //根据参数发送所有post请求
    public static void getRequest(String url, RequestParams params, DisposeDataListener listener,
                                  Class<?> clazz) {
        CommonOkHttpClient.get(CommonRequest.
                createGetRequest(url, params), new DisposeDataHandle(listener, clazz));
    }

    public static void requestRecommendData(DisposeDataListener listener) {
        RequestCenter.getRequest(HttpConstants.HOME_RECOMMEND, null, listener,
                BaseRecommendModel.class);
    }

    public static void requestRecommendMore(DisposeDataListener listener) {
        RequestCenter.getRequest(HttpConstants.HOME_RECOMMEND_MORE, null, listener,
                BaseRecommendMoreModel.class);
    }

    public static void requestFriendData(DisposeDataListener listener) {
        RequestCenter.getRequest(HttpConstants.HOME_FRIEND, null, listener, BaseFriendModel.class);
    }
} 