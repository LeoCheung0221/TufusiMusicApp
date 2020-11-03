package com.tufusi.lib_base.ft_login.model.user;

import com.tufusi.lib_base.BaseModel;

import java.io.Serializable;

/**
 * Created by LeoCheung on 2020/11/3.
 *
 * @description 用户真正实体数据
 */
public class UserContent extends BaseModel {

    //用户唯一标识符
    public String userId;
    public String photoUrl;
    public String name;
    public String tick;
    public String mobile;
    public String platform;
} 