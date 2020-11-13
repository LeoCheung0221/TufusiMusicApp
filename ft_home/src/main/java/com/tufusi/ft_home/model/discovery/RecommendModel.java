package com.tufusi.ft_home.model.discovery;

import com.tufusi.lib_base.BaseModel;

import java.util.ArrayList;

/**
 * Created by LeoCheung on 2020/11/12.
 *
 * @description 推荐实体对象
 */
public class RecommendModel extends BaseModel {
    public ArrayList<RecommendBodyValue> list;
    public RecommendHeadValue head;
} 