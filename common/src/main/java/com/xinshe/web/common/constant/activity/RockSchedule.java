package com.xinshe.web.common.constant.activity;


import com.xinshe.web.common.constant.IntBaseType;

/**
 * Created by CuiShihao on 2019/3/18
 */
public enum RockSchedule implements IntBaseType {

    //
    NOT_CREATED_SHAKE_USER(0, "未创建摇号用户"),
    NOT_SETTING_SHAKE_RULE(1, "未设置摇号规则"),
    FINISHED(2, "已完成"),
    RESET_ROCKNUM_SUCCESS(3, "重置摇号成功"),
    RESET_ROCKNUM_FAIL(4, "重置摇号失败"),
    ROCKNUM_NOT_EXIST(5, "摇号活动不存在"),
    ROCKNUM_ALREADY_CONFIRM(6, "摇号结果已经确认，不能更改"),
    ROCKNUM_NOT_END(7, "摇号结果未结束，不能确认摇号"),
    ROCKNUM_NOT_BEGIN(7, "摇号结果未开始，不能设置号码")
    ;

    private Integer value;
    private String desc;

    RockSchedule(Integer value, String desc) {
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
        RockSchedule[] activitySchedules = values();
        for (RockSchedule schedule : activitySchedules) {
            if (schedule.value.equals(id)) {
                return schedule.desc;
            }
        }
        return "";
    }

    public static Integer getValue(String name) {
        RockSchedule[] activitySchedules = values();
        for (RockSchedule schedule : activitySchedules) {
            if (schedule.desc.equals(name)) {
                return schedule.value;
            }
        }
        return null;
    }
}
