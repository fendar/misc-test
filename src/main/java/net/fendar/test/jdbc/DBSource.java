package net.fendar.test.jdbc;

import java.sql.Connection;

/**
 * Created by zhongchao on 16/3/26.
 */
public interface DBSource {
    Connection getConnection() throws Exception;
    void closeConnection(Connection connection) throws Exception;
}
