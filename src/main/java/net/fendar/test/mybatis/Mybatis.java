package net.fendar.test.mybatis;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by zhongchao on 16/4/5.
 */
public class Mybatis {
    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            String resource = "mybatis/mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSession getSession() {
       return sqlSessionFactory.openSession();
    }

    public static <T> T getMapper(Class<T> clz) {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        return sqlSession.getMapper(clz);
    }
}
