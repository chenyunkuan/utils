package cn.ykchen.enums;

import java.security.InvalidParameterException;

/**
 * Created by kuange on 2017/4/12.
 */
public class EnumUtils {

    public static < T extends Enum> T getEnumConstant(Class<T> clazz,String enumName){
        for(T enumConstant: clazz.getEnumConstants()){
            if(enumConstant.name().equals(enumName)){
                return enumConstant;
            }
        }
        throw new InvalidParameterException("enum "+clazz.getName()+" not contains name["+enumName+"] constant ");
    }

    public static < T extends Enum & EnumDesc>String getEnumDesc(Class<T> clazz,String enumName){
        return getEnumConstant(clazz,enumName).getDesc();
    }

    public static < T extends Enum & EnumDescAndCode> T getEnumConstant(Class<T> clazz,int enumCode){
        for(T enumConstant: clazz.getEnumConstants()){
            if(enumConstant.getCode()==enumCode){
                return enumConstant;
            }
        }
        throw new InvalidParameterException("enum "+clazz.getName()+" not contains code ["+enumCode+"] constant ");
    }

    public static < T extends Enum & EnumDescAndCode>String getEnumDesc(Class<T> clazz,int enumCode){
        return getEnumConstant(clazz,enumCode).getDesc();
    }
}
