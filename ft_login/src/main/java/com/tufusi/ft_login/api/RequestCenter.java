package com.tufusi.ft_login.api;

import com.tufusi.lib_base.ft_login.model.user.User;
import com.tufusi.lib_network.okhttp.CommonOkHttpClient;
import com.tufusi.lib_network.okhttp.listener.DisposeDataHandle;
import com.tufusi.lib_network.okhttp.listener.DisposeDataListener;
import com.tufusi.lib_network.okhttp.request.CommonRequest;
import com.tufusi.lib_network.okhttp.request.RequestParams;

/**
 * 请求中心
 */
public class RequestCenter {

    static class HttpConstants {
        private static final String ROOT_URL = "http://imooc.com/api";

        /**
         * 登陆接口
         */
        public static String LOGIN = ROOT_URL + "/module_voice/login_phone";
    }

    /**
     * 根据参数发送所有post请求
     *
     * @param url      请求url
     * @param params   请求参数
     * @param listener 请求回调接口
     * @param clazz    响应实体对象
     */
    public static void getRequest(String url, RequestParams params, DisposeDataListener listener,
                                  Class<?> clazz) {
        CommonOkHttpClient.get(CommonRequest.
                createGetRequest(url, params), new DisposeDataHandle(listener, clazz));
    }

    /**
     * 用户登陆请求
     */
    public static void login(DisposeDataListener listener) {
        RequestParams params = new RequestParams();
        params.put("mb", "18734924592");
        params.put("pwd", "999999q");
        RequestCenter.getRequest(HttpConstants.LOGIN, params, listener, User.class);
    }
}
