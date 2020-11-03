package com.tufusi.ft_login.presenter;

import com.google.gson.Gson;
import com.tufusi.ft_login.api.MockData;
import com.tufusi.ft_login.api.RequestCenter;
import com.tufusi.ft_login.inter.IUserLoginPresenter;
import com.tufusi.ft_login.inter.IUserLoginView;
import com.tufusi.ft_login.manager.UserManager;
import com.tufusi.lib_base.ft_login.model.LoginEvent;
import com.tufusi.lib_base.ft_login.model.user.User;
import com.tufusi.lib_common_ui.base.BasePresenter;
import com.tufusi.lib_network.okhttp.listener.DisposeDataListener;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by LeoCheung on 2020/11/3.
 *
 * @description
 */
public class UserLoginPresenter extends BasePresenter<IUserLoginView> implements IUserLoginPresenter, DisposeDataListener {

    @Override
    public void login(String username, String password) {
        iView.showLoadingView();
        RequestCenter.login(this);
    }

    @Override
    public void onSuccess(Object responseObj) {
        iView.hideLoadingView();
        User user = (User) responseObj;
        UserManager.getInstance().setUser(user);
        //发送登陆Event
        EventBus.getDefault().post(new LoginEvent());
        iView.finishActivity();
    }

    @Override
    public void onFailure(Object reasonObj) {
        iView.hideLoadingView();
        onSuccess(new Gson().fromJson(MockData.LOGIN_DATA, User.class));
        iView.showLoginFailedView();
    }
}