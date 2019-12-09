package com.xinshe.web.common.exceptions.user;


import com.xinshe.web.common.constant.IntBaseType;

public enum  ActiveUserExceptionEnum  implements IntBaseType {
    ACTIVE_ID_NON_EXISTENT(41001,"活动编号不存在"),
    ACTIVE_USER_NO_JOIN_ACTIVITY(41002,"该用户未参与此次活动"),
    ACTIVE_USER_ALREADY_EXISTS(41003,"该用户已存在"),
    ACTIVE_USER_UPDATE_FAIL(41004,"更新用户信息失败"),
    ACTIVE_USER_INFO_GET_FAIL(41005,"获取用户缓存信息失败"),
    ACTIVE_USER_NOT_EXISTS(41006,"活动用户不存在"),
    ACTIVE_USER_LOGOUT_FAIL(41007,"退出失败"),
    ACTIVE_USER_PHONE_OR_ID_CARD_REPEAT(41008,"手机号或身份证号重复"),
    ACTIVE_USER_VERIFICATION_CODE_REPEATS_END(41009,"短信验证码已发送,请稍后再试"),
    ACTIVE_USER_VERIFICATION_CODE_SEND_FAIL(41010,"短信验证码发送失败"),
    ACTIVE_USER_VERIFICATION_CODE_FAIL(41012,"验证码错误"),
    ACTIVE_USER_VERIFICATION_CODE_TIMEOUT(41013,"验证码已过期"),
    ACTIVE_USER_FILE_NO_EXISTS(41014,"文件不存在"),
    ACTIVE_USER_FILE_ERROR(41015,"文件不符合模板要求"),
    ACTIVE_USER_PARAM_ERROR(41016,"参数错误"),
    ACTIVE_USER_NO_ATTEND(41017,"该用户未签到"),
    ACTIVE_USER_GET_ROCK_NUM_FAIL(41018,"摇号结果不存在"),
    ACTIVE_USER_CODE_EXISTS(41019,"该活动次个人号码已存在"),
    ACTIVE_USER_INFO_EXISTS(41020,"用户信息不存在"),
    ACTIVE_USER_UPLOAD_FAIL(41021,"批量上传用户失败"),
    ACTIVE_USER_EDIT_FAIL(41022,"该活动不处于未摇号状态，无法进行编辑操作"),
    ACTIVE_USER_PHONE_FAIL(41023,"手机号错误"),
    ACTIVE_USER_ID_CARD_FAIL(41024,"身份证号码错误"),
    ACTIVE_USER_BIND_FAIL(41024,"摇号用户选择失败,请重试"),
    ACTIVE_USER_ON_FAIL(41025,"活动用户解封失败"),
    ;

    private int value;
    private String desc;
    ActiveUserExceptionEnum(int value, String desc) {
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
