package com.tufusi.ft_home.view.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.tufusi.ft_home.R;
import com.tufusi.lib_common_ui.base.BaseActivity;
import com.tufusi.lib_common_ui.base.BasePresenter;
import com.tufusi.lib_common_ui.base.BaseView;

public class HomeActivity extends BaseActivity implements View.OnClickListener {

    public static void start(Context context) {

    }

    @Override
    public void onClick(View v) {

    }

    @Override
    protected BaseView createView() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }
}