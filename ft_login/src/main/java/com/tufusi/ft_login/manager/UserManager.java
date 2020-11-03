package com.tufusi.ft_login.manager;

import com.tufusi.lib_base.ft_login.model.user.User;

/**
 * Created by LeoCheung on 2020/11/3.
 *
 * @description 单例管理用户信息
 */
public class UserManager {

    private static volatile UserManager singleton = null;
    private User user;

    private UserManager() {
    }

    public static UserManager getInstance() {
        if (singleton == null) {
            synchronized (UserManager.class) {
                if (singleton == null) {
                    singleton = new UserManager();
                }
            }
        }
        return singleton;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isLogin() {
        return user != null;
    }

    public void deleteUser() {
        this.user = null;
    }
}