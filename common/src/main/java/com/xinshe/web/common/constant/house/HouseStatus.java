package com.xinshe.web.common.constant.house;


import com.xinshe.web.common.constant.IntBaseType;

/**
 * Created by wk on 2019/3/4.
 */
public enum HouseStatus implements IntBaseType {


    NOT_SALE(1, "不可售"),
    ON_SALE(2, "可售"),
    SALE_OUT(3, "已售"),
    RESERVE_SALE(4, "预留"),
    SALE_FAKE(5, "假售")
    ;
    private int value;
    private String desc;

    HouseStatus(int value, String desc) {
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
        HouseStatus[] houseStatuses = values();
        for (HouseStatus status : houseStatuses) {
            if (status.value == id) {
                return status.desc;
            }
        }
        return "";
    }

    public static Integer getValue(String name) {
        HouseStatus[] houseStatuses = values();
        for (HouseStatus status : houseStatuses) {
            if (status.desc.equals(name)) {
                return status.value;
            }
        }
        return null;
    }

}
