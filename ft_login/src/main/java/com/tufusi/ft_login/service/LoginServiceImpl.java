package com.tufusi.ft_login.service;

import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.tufusi.ft_login.LoginActivity;
import com.tufusi.ft_login.manager.UserManager;
import com.tufusi.lib_base.ft_login.model.user.User;
import com.tufusi.lib_base.ft_login.service.LoginService;

/**
 * Created by LeoCheung on 2020/11/3.
 *
 * @description 登录模块对外接口功能实现
 */
@Route(path = "/login/login_service")
public class LoginServiceImpl implements LoginService {

    @Override
    public User getUserInfo() {
        return UserManager.getInstance().getUser();
    }

    @Override
    public void removeUser() {
        UserManager.getInstance().deleteUser();
    }

    @Override
    public boolean isLogin() {
        return UserManager.getInstance().isLogin();
    }

    @Override
    public void login(Context context) {
        LoginActivity.start(context);
    }

    @Override
    public void init(Context context) {
        Log.i(LoginServiceImpl.class.getSimpleName(), "init()");
    }
}