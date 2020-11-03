package com.tufusi.lib_common_ui.base;

import androidx.annotation.Nullable;

import java.lang.ref.WeakReference;

/**
 * Created by LeoCheung on 2020/11/3.
 *
 * @description
 */
public class BasePresenter<V extends BaseView> {

    private WeakReference<V> weakView;
    protected V iView;

    /**
     * 将Presenter与View层关联，以便这业务处理的时候更新界面
     */
    public void attachView(V view) {
        this.weakView = new WeakReference<>(view);
        iView = weakView.get();
    }

    /**
     * 将Presenter与View层解绑，防止界面退出时后台任务仍然持有Activity的引用，进而导致内存泄漏的发生
     */
    public void detachView() {
        if (weakView != null) {
            if (weakView.get() != null) {
                weakView.get().hideLoadingView();
            }
            this.weakView.clear();
        }
        this.weakView = null;
    }

    /**
     * 获取具体的View层对象,有可能为null(当Activity退出后)
     */
    public @Nullable
    V getView() {
        return weakView != null ? weakView.get() : null;
    }
} 