package net.fendar.test.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by zhongchao on 16/3/26.
 */
public class SimpleDBSource implements DBSource {
    private String url = "jdbc:mysql://localhost:3306/fendar?useUnicode=true&characterEncoding=utf8&state";
    private String user = "root";
    private String passwd = "";

    public SimpleDBSource() throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, passwd);
    }

    public void closeConnection(Connection connection) throws SQLException {

        connection.close();
    }
}
