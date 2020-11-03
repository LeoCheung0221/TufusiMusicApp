package com.tufusi.lib_common_ui.base;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NavUtils;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import com.tufusi.lib_common_ui.Constant;
import com.tufusi.lib_common_ui.utils.StatusBarUtil;

/**
 * Created by LeoCheung on 2020/11/3.
 *
 * @author 鼠夏目
 * @description
 */
public abstract class BaseActivity<T extends BasePresenter<V>, V extends BaseView> extends FragmentActivity {

    protected T mPresenter;
    protected V iView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        StatusBarUtil.statusBarLightMode(this);
        super.onCreate(savedInstanceState, persistentState);
        setContentView(getLayoutId());

        mPresenter = createPresenter();
        iView = createView();
        if (mPresenter != null && iView != null) {
            //将业务处理与View层关联
            mPresenter.attachView(iView);
        }
        initView();
    }

    private V createView() {
        return null;
    }

    protected abstract int getLayoutId();

    protected abstract void initView();

    protected abstract T createPresenter();

    /**
     * 申请指定的权限.
     */
    public void requestPermission(int code, String... permissions) {
        ActivityCompat.requestPermissions(this, permissions, code);
    }

    /**
     * 判断是否有指定的权限
     */
    public boolean hasPermission(String... permissions) {
        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case Constant.WRITE_READ_EXTERNAL_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    doSDCardPermission();
                }
                break;
            case Constant.HARDWARE_CAMERA_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    doCameraPermission();
                }
                break;
            default:
                break;
        }
    }

    /**
     * 处理整个应用用中的SDCard业务
     */
    public void doSDCardPermission() {
    }

    public void doCameraPermission() {
    }

    @Override
    protected void onDestroy() {
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        super.onDestroy();
    }
}