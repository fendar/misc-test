package net.fendar.test.mybatis;

import net.fendar.test.mybatis.dao.MusicDao;
import net.fendar.test.util.Prints;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * Created by zhongchao on 16/3/30.
 */
public class Start {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        MusicDao musicDao = sqlSession.getMapper(MusicDao.class);

        Prints.println(musicDao.selectById(3), musicDao.selectAll());


    }
}
