import com.mysql.jdbc.Field
import groovy.sql.GroovyRowResult
import groovy.sql.Sql



def md
Sql.withInstance("jdbc:mysql://127.0.0.1:3306/fendar",  "root", "", "com.mysql.jdbc.Driver") { Sql sql ->
    sql.eachRow("SELECT * FROM music LIMIT 1") { row ->
        md = row.getMetaData();
    }
//    println md
    if (md) {
        (1..md.columnCount).each { it ->
            println md.getColumnName(it) << ':' << md.getColumnType(it)
        }
    }
    new File("TableName.java").withWriter { writer ->
        writer.writeLine(
"""
/**
* Auto generated by fendar
**/
public class TableName {
    private Integer a;
}
""")
    }
}

//public String getColumnTypeName(int column) throws SQLException {
//    Field field = getField(column);
//    int mysqlType = field.getMysqlType();
//    int jdbcType = field.getSQLType();
//    switch(mysqlType) {
//        case 0:
//        case 246:
//            return field.isUnsigned()?"DECIMAL UNSIGNED":"DECIMAL";
//        case 1:
//            return field.isUnsigned()?"TINYINT UNSIGNED":"TINYINT";
//        case 2:
//            return field.isUnsigned()?"SMALLINT UNSIGNED":"SMALLINT";
//        case 3:
//            return field.isUnsigned()?"INT UNSIGNED":"INT";
//        case 4:
//            return field.isUnsigned()?"FLOAT UNSIGNED":"FLOAT";
//        case 5:
//            return field.isUnsigned()?"DOUBLE UNSIGNED":"DOUBLE";
//        case 6:
//            return "NULL";
//        case 7:
//            return "TIMESTAMP";
//        case 8:
//            return field.isUnsigned()?"BIGINT UNSIGNED":"BIGINT";
//        case 9:
//            return field.isUnsigned()?"MEDIUMINT UNSIGNED":"MEDIUMINT";
//        case 10:
//            return "DATE";
//        case 11:
//            return "TIME";
//        case 12:
//            return "DATETIME";
//        case 13:
//            return "YEAR";
//        case 15:
//            return "VARCHAR";
//        case 16:
//            return "BIT";
//        case 247:
//            return "ENUM";
//        case 248:
//            return "SET";
//        case 249:
//            return "TINYBLOB";
//        case 250:
//            return "MEDIUMBLOB";
//        case 251:
//            return "LONGBLOB";
//        case 252:
//            if(this.getField(column).isBinary()) {
//                return "BLOB";
//            }
//
//            return "TEXT";
//        case 253:
//            if(jdbcType == -3) {
//                return "VARBINARY";
//            }
//
//            return "VARCHAR";
//        case 254:
//            if(jdbcType == -2) {
//                return "BINARY";
//            }
//
//            return "CHAR";
//        case 255:
//            return "GEOMETRY";
//        default:
//            return "UNKNOWN";
//    }
//}