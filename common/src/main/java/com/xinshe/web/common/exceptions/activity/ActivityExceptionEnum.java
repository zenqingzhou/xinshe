package com.xinshe.web.common.exceptions.activity;


import com.xinshe.web.common.constant.IntBaseType;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wk on 2019/3/5.
 */
public enum ActivityExceptionEnum implements IntBaseType {

    ACTIVITY_NOT_EXIST(42001, "活动信息不存在"),
    ACTIVITY_NOT_START(42002, "活动未开始"),
    ACTIVITY_NOT_KAIPANSHIJIAN(42003, "活动缺少开始时间"),
    ACTIVITY_NOT_ATTEND(42004, "用户未签到"),
    ACTIVITY_ORDER_EXIST(42005, "选房失败，很抱歉您已选房，不可重复购买"),
    ACTIVITY_HOUSE_NOT_SALE(42006, "房源不可售"),
    ACTIVITY_GROUP_NOT_MATCH(42007, "选房方式不符"),
    ACTIVITY_USER_NOT_PICK(42008, "该用户不能抢房"),
    ACTIVITY_HP_ERROR(42009, "选房页信息查询失败"),
    ACTIVITY_NO_PICK_SORT(42010, "活动缺少选房顺序"),
    ACTIVITY_START_ERROR(42011, "开始活动发生异常"),
    ACTIVITY_PICK_FAILURE(42012, "抢房失败"),
    ACTIVITY_SOON_START(42013, "当前时间距开盘时间不足10分钟,不允许修改"),
    ACTIVITY_KAIPAN_TIME_APPROACHING(42014, "开盘时间与已有场次开盘时间间隔不能小于10分钟"),
    ACTIVITY_KAIPAN_TIME_NOT_NULL(42014, "开盘时间不能为空"),
    ACTIVITY_COMPLETE_FAILURE(42015, "完成活动异常"),
    ACTIVITY_NOT_SUPPORT_ONLINE(42016, "线上活动暂不支持"),
    ACTIVITY_QUERY_ROOM_FAILURE(42017, "查询房间列表异常"),
    ACTIVITY_QUERY_ROOMCFG_FAILURE(42018, "查询房间配置信息异常"),
    ACTIVITY_NO_CURRENT_ORDER(42019, "活动缺少当前选房组/序"),
    ACTIVITY_ADD_COLLECT_FAILURE(42020, "添加收藏异常"),
    ACTIVITY_CANCLE_COLLECT_FAILURE(42021, "取消收藏异常"),
    ACTIVITY_SELECT_COLLECT_FAILURE(42022, "查询收藏异常"),
    ACTIVITY_ALREADY_STARTED(42023, "当前活动状态不能修改信息操作"),
    ACTIVITY_JUST_LOCKED(42024,"活动刚锁定不足10分钟，不可以进行当前操作"),
    ACTIVITY_IS_LOCKED(42025,"活动已经锁定，不支持任何修改操作"),
    ACTIVITY_IS_FROZEN(42026,"活动已经封停，无法访问"),
    ACTIVITY_OOO_IS_NULL(42027,"活动线上线下状态为空"),
    ACTIVITY_GOH_IS_NULL(42028,"活动分组状态为空"),
    USER_NOT_JOIN_ACTIVITY(42029,"用户未参加活动"),
    ACTIVITY_ONOROFF_ERROR(42030,"活动类型错误"),
    ACTIVITY_GROUPORHUMAN_ERROR(42031,"选房方式错误"),
    HOUSE_NOT_PICK(42032, "房源不可抢"),
    ACTIVITY_COLLECTION_EXIST(42033, "无法重复收藏该房源"),
    ACTIVITY_COLLECTION_MORE_THAN_ONE(42034, "用户多次收藏该房源"),
    ACTIVITY_COLLECTION_NOT_EXIST(42035, "收藏中不存在该房源"),
    ACTIVITY_EXIST_PROCESSING_JOB(42036, "活动存在进行中的任务，不允许开始"),
    ACTIVITY_HOUSE_VERSION_NOT_EXIST(42037, "房源实例ID不存在"),
    ACTIVITY_USER_VERSION_NOT_EXIST(42038, "用户实例ID不存在"),
    ACTIVITY_NOT_PUBLICITY(42039, "仅未开盘的活动可以公示"),
    ACTIVITY_NO_USER(42040, "活动未设置用户"),
    ACTIVITY_NO_HOUSE(42041, "活动为设置房源"),
    ACTIVITY_NO_GROUP(42042, "活动未设置分组"),
    ACTIVITY_STATUS_NOT_OPERATE(42043, "当前状态不允许进行此操作"),
    ACTIVITY_GROUP_NOT_PICK(42044, "选房失败，很抱歉您的组号未到，请耐心等待"),
    ACTIVITY_HUMAN_NOT_PICK(42045, "选房失败，很抱歉您的排号未到，请耐心等待"),
    ACTIVITY_BUILDING_NOT_RIGHT(42050, "活动楼盘与当前楼盘不匹配"),
    ACTIVITY_NOT_ALREADY(42051, "活动状态不是未开盘或公示失败，不能修改开盘内容"),
    HOUSE_ALREADY_SELL(42052, "选房失败，很抱歉您选的房源已被其他客户抢购"),
    ACTIVITY_GROUP_ROB_TIME_IS_NULL(42053, "分组抢房时间不能为空"),
    ACTIVITY_USER_NOT_NUMBER(42054, "分组抢房时间不能为空"),
    ACTIVITY_COLLECTION_ADD_ERROR(42055, "添加收藏异常"),
    ACTIVITY_COLLECTION_AGAIN_ERROR(42056, "添加收藏异常"),
    ACTIVITY_STATUS_ONLINE_ERROR(42057, "当前活动为线上活动，不能进入房源分组选择"),
    ACTIVITY_COUNT_DOWN_STARTTIME_ERROR(42058, "线上分组倒计时，当前组开始时间异常"),
    ACTIVITY_COUNT_DOWN_ROBTIME_ERROR(42059, "线上分组倒计时，抢房时间异常"),
    ;

    private int value;
    private String desc;


    ActivityExceptionEnum(int value, String desc) {
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

    private static final Map<Integer, ActivityExceptionEnum> MAP = new HashMap<>();

    static {
        for (ActivityExceptionEnum item : ActivityExceptionEnum.values()) {
            MAP.put(item.value, item);
        }
    }

    public static ActivityExceptionEnum getItemByValue(Integer value) {
        return MAP.get(value);
    }

}
