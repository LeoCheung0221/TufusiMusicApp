package com.tufusi.ft_login.inter;

import com.tufusi.lib_common_ui.base.BaseView;

/**
 * Created by LeoCheung on 2020/11/3.
 *
 * @description
 */
public interface IUserLoginView extends BaseView {

    /**
     * 获取用户姓名
     */
    String getUserName();

    /**
     * 获取用户登录密码
     */
    String getUserPassword();

    void finishActivity();

    void showLoginFailedView();

}