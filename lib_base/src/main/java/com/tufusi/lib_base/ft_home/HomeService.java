package com.tufusi.lib_base.ft_home;

import android.content.Context;

import com.alibaba.android.arouter.facade.template.IProvider;

/**
 * Created by LeoCheung on 2020/11/12.
 *
 * @description 首页模块对外暴露接口
 */
public interface HomeService extends IProvider {

    void startHomeActivity(Context context);

} 