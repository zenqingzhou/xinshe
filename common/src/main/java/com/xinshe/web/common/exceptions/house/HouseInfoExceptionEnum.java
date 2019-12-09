package com.xinshe.web.common.exceptions.house;


import com.xinshe.web.common.constant.IntBaseType;

/**
 * Created by wk on 2019/3/2.
 */
public enum HouseInfoExceptionEnum implements IntBaseType {

    IMPORT_EXCEL_FORMAT_ERROR(40001, "上传的文件格式不正确"),
    BUILDING_NOT_EXIST(40002, "楼盘不存在"),
    BUILDING_LAYOUT_NOT_EXIST(40003, "楼盘户型不存在"),
    MUST_SELECT_USER(40004, "预留必须选择用户"),
    HOUSE_INFO_NOT_EXIST(40005, "房源信息不存在"),
    LOULIST_QUERY_ERROR(40006, "楼栋列表查询异常"),
    HOUSE_GROUP_ERROR(40007, "房源分组重复"),
    USER_HOUSE_GROUP_NOT_EXIST(40008, "用户房源分组不存在"),
    ROOMLIST_EMPTY(40009, "房间列表为空"),
    CREATE_HOUSE_ERROR(40010, "添加房间信息异常"),
    ACTIVITY_ID_NOT_FOUND(40011, "未查询到活动ID"),
    FREEZE_EXCEPTION(40012, "封停处理异常"),
    HOUSE_ALREADY_SALE(40013, "已出售房源，不能更改状态"),
    BUILDING_NOT_LOU_OR_UNIT(40014, "楼盘缺少楼栋、单元信息"),
    HOUSE_ACTIVITY_CHANGE(40015, "当前房源已参加其他活动"),
    HOUSE_ALREADY_ACTIVITY(40016, "当前房源已参加过活动"),
    HOUSE_NOT_ACTIVITY(40017, "当前房源不在活动中"),
    ACTIVITY_NOT_STATUS(40018, "当前活动未开盘"),
    ACTIVITY_GROUP_ERROR(40019, "当前活动未设置用户组数"),
    HOUSE_GROUP_NOT_EXIST(40020, "当前活动抢购用户组数不存在"),
    HOUSE_GROUP_STATUS_ERROR(40021, "当前活动抢购组数未开始或已结束"),
    HOUSE_ACTIVITY_ERROR(40022, "当前房源不在活动中，不能设置销售状态"),
    ADD_ROOMLIST_ERROR(40023, "批量添加房间信息失败"),
    USER_HOUSE_ORDER_NOT_EXIST(40024, "当前用户没有订单"),
    USER_HOUSE_ORDER_ALREADY_EXIST(40025, "当前用户已经存在订单"),
    USER_ALREADY_JUMP(40026, "当前用户抢房时间已过"),
    HOUSE_INFO_IS_EXIST(40027, "该房源信息已存在"),
    LOUNO_HAS_EXIST(40028, "楼号已经存在"),
    HOUSE_STATUS_CHANGE_ERROR(40029, "此处不能修改房源销售状态"),
    HOUSE_STATUS_ERROR(40029, "房源修改状态不存在"),
    HOUSE_SALE_STATUS_ERROR(40030, "用户购房状态不正确"),
    HOUSE_RESERVE_REPEAT(40031, "用户已经预留其他房源，不能重复预留"),
    HOUSE_FAKE_ERROR(40032,"活动开始之前不能设置假售"),
    REVERSE_FREEZE_EXCEPTION(40033, "接触封停处理异常"),
    REVERSE_PERSON_EXCEPTION(40034, "线下按号不能设置预留信息"),
    UPDATE_HOUSE_INFO_IS_EXIST(40035, "您要更新的房源信息已存在，不能重复"),
    HOUSE_STATUS_RESEVER_ERROR(40036, "活动开始后不能设置预留信息"),
    ;
    private int value;
    private String desc;

    HouseInfoExceptionEnum(int value, String desc) {
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
