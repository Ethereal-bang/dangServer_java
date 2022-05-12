package dangserver.common;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeException;

import java.sql.*;

public class ArrayTypeHandler extends BaseTypeHandler<String[]> {
    private static final String TYPE_NAME_VARCHAR = "varchar";
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, String[] parameter,
                                    JdbcType jdbcType) throws SQLException {

        // 这3行是关键的代码，创建Array，然后ps.setArray(i, array)就可以了
        Connection conn = ps.getConnection();
        Array array = conn.createArrayOf(TYPE_NAME_VARCHAR, parameter);
        ps.setArray(i, array);

    }

    @Override
    public String[] getNullableResult(ResultSet rs, String columnName)
            throws SQLException {

        return getArray(rs.getString(columnName));
    }

    @Override
    public String[] getNullableResult(ResultSet rs, int columnIndex) throws SQLException {

        return getArray(rs.getString(columnIndex));
    }

    @Override
    public String[] getNullableResult(CallableStatement cs, int columnIndex)
            throws SQLException {

        return getArray(cs.getString(columnIndex));
    }

    /**
     * 该方法就是把在 mapper xml 里配置了typeHandler=MyArrayTypeHandler的字段，
     * 走我们这个自定义方法来实现字符串转字符串数组
     * 同理，我们可以把它转成任何我们想转的格式，如Json
     */
    private String[] getArray(String value) {
        System.out.println(value);
        if (StringUtils.isBlank(value)) {
            return null;
        }
        return value.split(",");
    }

}