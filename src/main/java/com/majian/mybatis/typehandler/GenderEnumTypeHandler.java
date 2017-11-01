package com.majian.mybatis.typehandler;

import com.majian.mybatis.GenderEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * local enum processor
 * 1.mybatis.type-handlers-package=com.majian.mybatis.typehandler
 * 2.@MappedTypes(GenderEnum.class) is mandatory
 * 3.every enum should have a TypeHandler
 * 4.do not need implement com.majian.mybatis.CommonEnum
 */
@MappedTypes(GenderEnum.class)
public class GenderEnumTypeHandler extends BaseTypeHandler<GenderEnum>{
    private final Class<GenderEnum> type;
    private final GenderEnum[] enums;

    public GenderEnumTypeHandler(Class<GenderEnum> type) {
        if (type == null) {
            throw new IllegalArgumentException("Type argument cannot be null");
        } else {
            this.type = type;
            this.enums = (GenderEnum[]) type.getEnumConstants();
            if (this.enums == null) {
                throw new IllegalArgumentException(type.getSimpleName() + " does not represent an enum type.");
            }
        }
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, GenderEnum parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i,parameter.code());
    }

    @Override
    public GenderEnum getNullableResult(ResultSet rs, String columnName) throws SQLException {
        int code = rs.getInt(columnName);
        if (rs.wasNull()) {
            return null;
        }
        return fromCode(code);
    }

    private GenderEnum fromCode(int code) {
        for (GenderEnum item : enums) {
            if (item.code()==code) {
                return item;
            }
        }
        throw new IllegalArgumentException("Cannot convert " + code + " to " + this.type.getSimpleName() + " by code.");
    }

    @Override
    public GenderEnum getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        int code = rs.getInt(columnIndex);
        if (rs.wasNull()) {
            return null;
        }
        return fromCode(code);
    }

    @Override
    public GenderEnum getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        int code = cs.getInt(columnIndex);
        if (cs.wasNull()){
            return null;
        }
        return fromCode(code);
    }
}
