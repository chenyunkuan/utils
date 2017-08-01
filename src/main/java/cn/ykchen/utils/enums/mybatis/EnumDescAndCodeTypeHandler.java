package cn.ykchen.utils.enums.mybatis;

import cn.ykchen.utils.enums.EnumDescAndCode;
import cn.ykchen.utils.enums.EnumUtils;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by kuange on 2017/4/12.
 * mybatis 的枚举处理类，需要枚举实现EnumDescAndCode接口
 * 用来处理枚举类型需要在数据库存储数字类型的需求
 * 需要在myBatisConfig中添加配置
 * <typeHandler handler="com.dnkx.express.enums.mybatis.EnumDescAndCodeTypeHandler" javaType="xxx"/>
 * xxx为对应的枚举类,并且实现EnumDescAndCode接口
 *
 * @see EnumDescAndCode
 * @see BaseTypeHandler
 */
public class EnumDescAndCodeTypeHandler<T extends Enum & EnumDescAndCode> extends BaseTypeHandler<T> {

    private Class<T> type;

    public EnumDescAndCodeTypeHandler(Class<T> type) {
        if (type == null)
            throw new IllegalArgumentException("Type argument cannot be null");
        this.type = type;
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, T parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, parameter.getCode());
    }

    @Override
    public T getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return EnumUtils.getEnumConstant(type, rs.getInt(columnName));
    }

    @Override
    public T getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return EnumUtils.getEnumConstant(type, rs.getInt(columnIndex));
    }

    @Override
    public T getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return EnumUtils.getEnumConstant(type, cs.getInt(columnIndex));
    }

}
