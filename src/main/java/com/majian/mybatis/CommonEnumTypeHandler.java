package com.majian.mybatis;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by jianma on 2017/10/31.
 * global enum process
 * 1.mybatis.configuration.default-enum-type-handler=com.majian.mybatis.CommonEnumTypeHandler
 * 2.every enum implements com.majian.mybatis.CommonEnum
 * 3.every enum share this handler
 */
public class CommonEnumTypeHandler<E extends Enum<E> & CommonEnum> extends BaseTypeHandler<E> {

    private final Class<E> type;
    private final E[] enums;

    public CommonEnumTypeHandler(Class<E> type) {
        if (type == null) {
            throw new IllegalArgumentException("Type argument cannot be null");
        } else {
            this.type = type;
            this.enums = (E[]) type.getEnumConstants();
            if (this.enums == null) {
                throw new IllegalArgumentException(type.getSimpleName() + " does not represent an enum type.");
            }
        }
    }

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, E e, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i, e.code());
    }

    @Override
    public E getNullableResult(ResultSet resultSet, String s) throws SQLException {
        int code = resultSet.getInt(s);
        if (resultSet.wasNull()) {
            return null;
        }
        return getEnum(code);
    }

    @Override
    public E getNullableResult(ResultSet resultSet, int i) throws SQLException {
        int code = resultSet.getInt(i);
        if (resultSet.wasNull()) {
            return null;
        }
        return getEnum(code);

    }

    @Override
    public E getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        int code = callableStatement.getInt(i);
        if (callableStatement.wasNull()) {
            return null;
        }
        return getEnum(code);

    }

    private E getEnum(int code) {
        for (E anEnum : enums) {
            if (anEnum.code() == code) {
                return anEnum;
            }
        }
        throw new IllegalArgumentException("Cannot convert " + code + " to " + this.type.getSimpleName() + " by code.");
    }
}
