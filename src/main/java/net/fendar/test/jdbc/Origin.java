package net.fendar.test.jdbc;

import static net.fendar.test.util.Prints.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by zhongchao on 16/3/26.
 */
public class Origin {
    public static void main(String[] args) throws Exception {
        DBSource dbSource = new SimpleDBSource();
        Connection connection = dbSource.getConnection();

        Statement stmt = connection.createStatement();

        print(stmt.executeUpdate("INSERT INTO music VALUES(null, '什刹海', '李健')"));

        ResultSet rs = stmt.executeQuery("SELECT * FROM music");

        while (rs.next()) {
            print(rs.getString("name"), "\t", rs.getString("author"));
        }
    }
}
