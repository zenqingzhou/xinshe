package com.xinshe.web.common.constant.activity;


import com.xinshe.web.common.constant.IntBaseType;

/**
 * Created by CuiShihao on 2019/3/18
 */
public enum RockStatus implements IntBaseType {

    //
    UNSHAKEN(0, "未摇号"),
    SHAKING(1, "摇号中"),
    TIMEOUT(2, "暂停"),
    OVER(3, "已结束"),
    FAIL(4, "失败")
            ;

    private Integer value;
    private String desc;

    RockStatus(Integer value, String desc) {
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

    public static String getName(Integer id) {
        RockStatus[] activityStatuses = values();
        for (RockStatus status : activityStatuses) {
            if (status.value.equals(id)) {
                return status.desc;
            }
        }
        return "";
    }

    public static Integer getValue(String name) {
        RockStatus[] activityStatuses = values();
        for (RockStatus status : activityStatuses) {
            if (status.desc.equals(name)) {
                return status.value;
            }
        }
        return null;
    }
}
