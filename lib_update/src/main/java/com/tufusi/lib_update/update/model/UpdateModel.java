package com.tufusi.lib_update.update.model;

import java.io.Serializable;

/**
 * Created by LeoCheung on 2020/11/3.
 *
 * @author 鼠夏目
 * @description
 */
public class UpdateModel implements Serializable {

    private static final long serialVersionUID = -5161684897150460361L;

    public int ecode;
    public String emsg;
    public UpdateInfo data;
}
