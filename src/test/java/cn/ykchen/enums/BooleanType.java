package cn.ykchen.enums;

import cn.ykchen.utils.enums.EnumDescAndCode;

/**
 * Created by kuange on 2017/4/12.
 */
public enum BooleanType implements EnumDescAndCode {
    TRUE(1,"是"),FALSE(0,"否");

    BooleanType(int code,String desc){
        this.code = code;
        this.desc = desc;
    }
    private int code;

    private String desc;
    public int getCode() {
        return this.code;
    }

    public String getDesc() {
        return this.desc;
    }
}
