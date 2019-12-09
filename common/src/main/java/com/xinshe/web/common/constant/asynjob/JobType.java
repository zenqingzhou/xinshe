package com.xinshe.web.common.constant.asynjob;


import com.xinshe.web.common.constant.IntBaseType;

public enum JobType implements IntBaseType {
    RockNumImportUser(1, "摇号活动导参与人员"),
    KaipanImportUser(2, "开盘活动导参与人员"),
    KaipanImportHouse(3, "开盘活动导房源信息"),
    ;

    private Integer value;
    private String desc;

    JobType(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    @Override
    public int getValue() {
        return this.value;
    }

    @Override
    public String getDesc() {
        return this.desc;
    }

    public static String getName(Integer id) {
        JobType[] activityStatuses = values();
        for (JobType status : activityStatuses) {
            if (status.value == id) {
                return status.desc;
            }
        }
        return "";
    }

    public static Integer getValue(String name) {
        JobType[] activityStatuses = values();
        for (JobType status : activityStatuses) {
            if (status.desc.equals(name)) {
                return status.value;
            }
        }
        return null;
    }
}
