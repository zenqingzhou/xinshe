package com.xinshe.web.common.exceptions.activity;


import com.xinshe.web.common.constant.IntBaseType;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wk on 2019/3/5.
 */
public enum RockActivityExceptionEnum implements IntBaseType {

    ACTIVITY_NOT_EXIST(43001, "活动不存在"),
    ACTIVITY_SOON_START(43002, "当前时间距摇号时间不足10分钟,不允许修改"),
    ACTIVITY_NOT_SYCHRONIZED(43003, "活动不是进行中，不能同步");

    private int value;
    private String desc;


    RockActivityExceptionEnum(int value, String desc) {
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

    private static final Map<Integer, RockActivityExceptionEnum> MAP = new HashMap<>();

    static {
        for (RockActivityExceptionEnum item : RockActivityExceptionEnum.values()) {
            MAP.put(item.value, item);
        }
    }

    public static RockActivityExceptionEnum getItemByValue(Integer value) {
        return MAP.get(value);
    }

}
