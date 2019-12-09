package com.xinshe.web.common.exceptions.house;


import com.xinshe.web.common.constant.IntBaseType;

public enum LayoutInfoExceptionEnum implements IntBaseType {

    //
    LAYOUT_ADD_FAILD("户型信息添加失败",40101),
    LAYOUT_UPDATE_FAILD("户型信息修改失败",40102),
    LAYOUT_STOP_FAILD("户型停用失败",40103),
    LAYOUT_GET_LIST_FAILD("户型列表查询失败",40104),
    LAYOUT_GET_DETAILS_FAILD("户型详情查询失败",40105),
    LAYOUT_NOT_EXIST("户型不存在",40106),
    LAYOUT_IMAGE_NOT_EXIST("户型图不存在",40106),
    LAYOUT_IMAGE_IS_EXIST("户型已存在",40107),
    LAYOUT_HAS_HOUSE("当前户型已存在房源信息，不能删除",40108),
    ;

    LayoutInfoExceptionEnum(String desc, int value) {
        this.desc = desc;
        this.value = value;
    }

    private String desc;
    private int value;

    @Override
    public int getValue() {
        return this.value;
    }

    @Override
    public String getDesc() {
        return this.desc;
    }
}
