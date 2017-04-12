package cn.ykchen.enums;

import cn.ykchen.utils.enums.mybatis.EnumDescAndCodeTypeHandler;

/**
 * Created by kuange on 2017/4/12.
 */
public class TestHandlerTypeHandler extends EnumDescAndCodeTypeHandler<BooleanType> {
    @Override
    protected Class<BooleanType> getClazz() {
        return BooleanType.class;
    }
}
