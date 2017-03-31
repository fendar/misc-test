package net.fendar.test.mybatis.interceptor;


import org.apache.calcite.avatica.AvaticaResultSetMetaData;
import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.plugin.*;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Properties;

/**
 * Created by zhongchao on 16/6/3.
 */
@Intercepts(@Signature(type = ResultSetHandler.class, method = "handleResultSets", args = {Statement.class}))
public class KylinInterceptor implements Interceptor {

    public Object intercept(Invocation invocation) throws Throwable {

        final Statement statement = (Statement) invocation.getArgs()[0];
        final ResultSet resultSet = statement.getResultSet();
        final ResultSetMetaData metaData = resultSet.getMetaData();

        if (!(metaData instanceof AvaticaResultSetMetaData))
            return invocation.proceed();

        ClassLoader classLoader = invocation.getClass().getClassLoader();

        final ResultSetMetaData metaDataProxy = (ResultSetMetaData)Proxy.newProxyInstance(classLoader, metaData.getClass().getInterfaces(), new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (method.getName().equals("getColumnClassName")) {
                    return getJavaType(metaData.getColumnType(Integer.parseInt(args[0].toString())));
                }
                return method.invoke(metaData, args);
            }
        });

        final ResultSet resultSetProxy = (ResultSet) Proxy.newProxyInstance(classLoader, resultSet.getClass().getInterfaces(), new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (method.getName().equals("getMetaData")) {
                    return metaDataProxy;
                }
                return method.invoke(resultSet, args);
            }
        });

        Statement statementProxy = (Statement) Proxy.newProxyInstance(classLoader, statement.getClass().getInterfaces(), new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (method.getName().equals("getResultSet")) {
                    return resultSetProxy;
                }
                return method.invoke(statement, args);
            }
        });

        return invocation.getMethod().invoke(invocation.getTarget(), statementProxy);
    }

    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    public void setProperties(Properties properties) {

    }

    private String getJavaType(int sqlType) {
        switch(sqlType) {
            case -7:
            case 16:
                return "java.lang.Boolean";
            case -6:
                return "java.lang.Integer";
            case -5:
                return "java.lang.Long";
            case -4:
            case -3:
            case -2:
                return "java.lang.String";
            case -1:
            case 1:
            case 12:
                return "java.lang.String";
            case 2:
            case 3:
                return "java.math.BigDecimal";
            case 4:
                return "java.lang.Integer";
            case 5:
                return "java.lang.Integer";
            case 6:
            case 8:
                return "java.lang.Double";
            case 7:
                return "java.lang.Float";
            case 91:
                return "java.sql.Date";
            case 92:
                return "java.sql.Time";
            case 93:
                return "java.sql.Timestamp";
            default:
                return "java.lang.Object";
        }
    }
}
