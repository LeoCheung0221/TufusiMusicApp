package com.tufusi.lib_base.ft_login.service;

import android.content.Context;

import com.alibaba.android.arouter.facade.template.IProvider;
import com.tufusi.lib_base.ft_login.model.user.User;

/**
 * Created by LeoCheung on 2020/11/3.
 *
 * @description Login模块对外提供的所有功能
 */
public interface LoginService extends IProvider {

    User getUserInfo();

    void removeUser();

    boolean isLogin();

    void login(Context context);

} 