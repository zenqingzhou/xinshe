package com.xinshe.web.common.constant.house;


import com.xinshe.web.common.constant.IntBaseType;

/**
 * Created by wk on 2019/3/15.
 */
public enum HouseActivityStatus implements IntBaseType {

    ON_ACTIVITY(0, "活动中"),
    NOT_ACTIVITY(1, "未参加活动"),

    ACTIVITY_ONLINE(0, "线上"),
    ACTIVITY_OFFLINE(1, "线下"),

    ACTIVITY_OFFLINE_GROUP(0, "按组"),
    ACTIVITY_OFFLINE_PERSON(1, "按人"),

    HOUSE_NOT_SELECT(0, "未选"),
    HOUSE_ALREADY_SELECT(1, "已选")
    ;
    private int value;
    private String desc;

    HouseActivityStatus(int value, String desc) {
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
