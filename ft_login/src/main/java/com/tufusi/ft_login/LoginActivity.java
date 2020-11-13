package com.tufusi.ft_login;

import android.content.Context;
import android.content.Intent;
import android.view.View;


import com.tufusi.ft_login.inter.IUserLoginView;
import com.tufusi.ft_login.presenter.UserLoginPresenter;
import com.tufusi.lib_common_ui.base.BaseActivity;

/**
 * Created by LeoCheung on 2020/11/3.
 *
 * @description
 */
public class LoginActivity extends BaseActivity<UserLoginPresenter, IUserLoginView> implements IUserLoginView {

    public static void start(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected IUserLoginView createView() {
        return this;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login_layout;
    }

    @Override
    protected void initView() {
        findViewById(R.id.login_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.login(getUserName(), getUserPassword());
            }
        });
    }

    @Override
    protected UserLoginPresenter createPresenter() {
        return new UserLoginPresenter();
    }

    @Override
    public String getUserName() {
        return "15715769421";
    }

    @Override
    public String getUserPassword() {
        return "999999q";
    }

    @Override
    public void showLoginFailedView() {

    }

    @Override
    public void showLoadingView() {

    }

    @Override
    public void hideLoadingView() {

    }

    @Override
    public void finishActivity() {
        finish();
    }

}