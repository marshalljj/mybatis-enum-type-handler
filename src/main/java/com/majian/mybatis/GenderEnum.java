package com.majian.mybatis;

/**
 * Created by jianma on 2017/10/31.
 */
public enum  GenderEnum implements CommonEnum{
    MALE(1, "male"),
    FEMALE(2, "female");

    private final int code;
    private final String value;

    GenderEnum(int code, String value) {
        this.code = code;
        this.value = value;
    }

    public int code() {
        return code;
    }

    public String value() {
        return value;
    }
}
