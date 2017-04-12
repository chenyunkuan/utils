package cn.ykchen;

import cn.ykchen.enums.BooleanType;
import cn.ykchen.utils.enums.EnumUtils;

/**
 * Unit test for simple App.
 */
public class AppTest {

    public static void main(String[] args) {
        System.out.println(EnumUtils.getEnumDesc(BooleanType.class,"TRUE"));
        System.out.println(EnumUtils.getEnumDesc(BooleanType.class,0));
    }
}
