package com.tufusi.lib_base.ft_login.service.impl;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.launcher.ARouter;
import com.tufusi.lib_base.ft_login.service.LoginService;

/**
 * Created by LeoCheung on 2020/11/10.
 *
 * @description 封装LoginService，使得可以直接供业务代码调用，无需再去初始化Service类
 */
public class LoginWrapper {

    @Autowired(name = "/login/login_service")
    protected LoginService mLoginService;

    private static volatile LoginWrapper singleton = null;

    private LoginWrapper() {
        //初始化LoginService
        ARouter.getInstance().inject(this);
    }

    public static LoginWrapper getInstance() {
        if (singleton == null) {
            synchronized (LoginWrapper.class) {
                if (singleton == null) {
                    singleton = new LoginWrapper();
                }
            }
        }
        return singleton;
    }

    public void login(Context context) {
        mLoginService.login(context);
    }

    public boolean isLogin() {
        return mLoginService.isLogin();
    }

    public void removeUser() {
        mLoginService.removeUser();
    }

    public void getUserInfo() {
        mLoginService.getUserInfo();
    }

} 