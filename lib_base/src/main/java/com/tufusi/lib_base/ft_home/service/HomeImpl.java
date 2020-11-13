package com.tufusi.lib_base.ft_home.service;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.launcher.ARouter;
import com.tufusi.lib_base.ft_home.HomeService;

/**
 * Created by LeoCheung on 2020/11/12.
 *
 * @description 对HomeService的包装，使接口使用更方便
 */
public class HomeImpl {

    @Autowired(name = "/home/home_service")
    protected HomeService mHomeService;

    private static volatile HomeImpl singleton = null;

    private HomeImpl() {
        ARouter.getInstance().inject(this);
    }

    public static HomeImpl getInstance() {
        if (singleton == null) {
            synchronized (HomeImpl.class) {
                if (singleton == null) {
                    singleton = new HomeImpl();
                }
            }
        }
        return singleton;
    }

    public void startHomeActivity(Context context) {
        mHomeService.startHomeActivity(context);
    }

}