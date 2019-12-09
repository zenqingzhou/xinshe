package com.xinshe.web.common.exceptions;


import com.xinshe.web.common.constant.ParamErrorCodeEnum;

public class ParamException extends BaseException {
    public ParamException(Integer code, String msg) {
        super(code, msg);
    }

    public ParamException(ParamErrorCodeEnum paramErrorCodeEnum) {
        super(paramErrorCodeEnum);
    }
}
