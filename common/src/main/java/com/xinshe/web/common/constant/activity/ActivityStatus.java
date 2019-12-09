package com.xinshe.web.common.constant.activity;


import com.xinshe.web.common.constant.IntBaseType;

/**
 * Created by CuiShihao on 2019/3/5
 */
public enum ActivityStatus implements IntBaseType {

    UNOPENED(1, "未开盘"),
    OPENING(2, "开盘中"),
    TIMEOUT(5, "暂停"),
    OVER(6, "已结束"),
    CHECKING(7, "公示中"),
    CHECK_SUCCESS(8, "公示成功"),
    CHECK_FAILURE(9, "公示失败"),
    ;

    private Integer value;
    private String desc;

    ActivityStatus(Integer value, String desc) {
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
        ActivityStatus[] activityStatuses = values();
        for (ActivityStatus status : activityStatuses) {
            if (status.value.equals(id)) {
                return status.desc;
            }
        }
        return "";
    }

    public static Integer getValue(String name) {
        ActivityStatus[] activityStatuses = values();
        for (ActivityStatus status : activityStatuses) {
            if (status.desc.equals(name)) {
                return status.value;
            }
        }
        return null;
    }

}
