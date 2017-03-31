package net.fendar.test.mybatis.TypeHanlder;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by zhongchao on 16/4/5.
 */
@MappedJdbcTypes({JdbcType.VARCHAR, JdbcType.INTEGER, JdbcType.DECIMAL, JdbcType.FLOAT, JdbcType.DOUBLE})
public class ListTypeHanlder extends BaseTypeHandler<List<? extends Number>> {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, List<? extends Number> parameter, JdbcType jdbcType) throws SQLException {
        Joiner joiner = Joiner.on(",");
        String str;
        if (jdbcType == JdbcType.VARCHAR) {
            str = joiner.join(Lists.transform(parameter, new Function<Number, String>() {
                public String apply(Number input) {
                    return "'" + input.toString() + "'";
                }
            }));
        } else {

        }
    }

    @Override
    public List<? extends Number> getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return null;
    }

    @Override
    public List<? extends Number> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return null;
    }

    @Override
    public List<? extends Number> getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return null;
    }
}
