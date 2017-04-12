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
 * @see org.apache.ibatis.type.BaseTypeHandler
 * @ser cn.ykchen.utils.enums.EnumDescAndCode
 */
public abstract class EnumDescAndCodeTypeHandler <T extends Enum & EnumDescAndCode> extends BaseTypeHandler<T> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, T parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i,parameter.getCode());
    }

    @Override
    public T getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return EnumUtils.getEnumConstant(getClazz(),rs.getInt(columnName));
    }

    @Override
    public T getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return EnumUtils.getEnumConstant(getClazz(),rs.getInt(columnIndex));
    }

    @Override
    public T getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return EnumUtils.getEnumConstant(getClazz(),cs.getInt(columnIndex));
    }

    protected abstract Class<T> getClazz();
}
