package com.xinshe.web.common.exceptions.house;


import com.xinshe.web.common.constant.IntBaseType;

/**
 * Created by wk on 2019/3/18.
 */
public enum  BigSceneExceptionEnum implements IntBaseType {


    CONFIG_NOT_EXIST(50001, "活动大屏配置不存在")
    ;
    private int value;
    private String desc;

    BigSceneExceptionEnum(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public String getDesc() {
        return desc;
    }

}
