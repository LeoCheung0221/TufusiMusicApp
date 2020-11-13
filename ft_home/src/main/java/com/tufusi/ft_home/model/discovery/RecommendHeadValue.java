package com.tufusi.ft_home.model.discovery;

import com.tufusi.lib_base.BaseModel;

import java.util.ArrayList;

/**
 * Created by LeoCheung on 2020/11/12.
 *
 * @description
 */
public class RecommendHeadValue extends BaseModel {
    public ArrayList<String> ads;
    public ArrayList<RecommendMiddleValue> middle;
    public ArrayList<RecommendFooterValue> footer;
} 