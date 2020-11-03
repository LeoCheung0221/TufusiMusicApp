package com.tufusi.lib_common_ui.recyclerview.base;

/**
 * Created by LeoCheung on 2020/11/3.
 *
 * @description
 */
public interface ItemViewDelegate<T> {

    int getItemViewLayoutId();

    boolean isForViewType(T item, int position);

    void convert(ViewHolder holder, T t, int position);
} 