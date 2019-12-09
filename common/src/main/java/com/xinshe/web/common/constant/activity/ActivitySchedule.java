package com.xinshe.web.common.constant.activity;


import com.xinshe.web.common.constant.IntBaseType;

/**
 * Created by CuiShihao on 2019/3/5
 */
public enum ActivitySchedule implements IntBaseType {

    NOT_CREATED_SETTING(3, "未上传房源"),
    NOT_UPLOADED_USER(4, "未上传用户"),
    FINISHED(7, "已完成")
    ;

    private Integer value;
    private String desc;

    ActivitySchedule(Integer value, String desc) {
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
        ActivitySchedule[] activitySchedules = values();
        for (ActivitySchedule schedule : activitySchedules) {
            if (schedule.value.equals(id)) {
                return schedule.desc;
            }
        }
        return "";
    }

    public static Integer getValue(String name) {
        ActivitySchedule[] activitySchedules = values();
        for (ActivitySchedule schedule : activitySchedules) {
            if (schedule.desc.equals(name)) {
                return schedule.value;
            }
        }
        return null;
    }

}
