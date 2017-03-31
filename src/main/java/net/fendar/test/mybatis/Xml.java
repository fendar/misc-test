package net.fendar.test.mybatis;

import net.fendar.test.mybatis.dao.MusicDao;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.Map;

import static net.fendar.test.util.Prints.*;

/**
 * Created by zhongchao on 16/4/6.
 */
public class Xml {
    public static void main(String[] args) {
        SqlSession sqlSession = Mybatis.getSession();

        MusicDao musicDao = sqlSession.getMapper(MusicDao.class);

//        Music music = new Music();
//        music.setId(-1);
//        music.setAuthor("fendar");
//        music.setName("love summer");
//
//        println(musicDao.insert(music), music);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", 12);
        map.put("author", "fendar");
        map.put("name", "sunday");

        println(musicDao.insertMap(map));

        sqlSession.commit();
        sqlSession.close();
    }
}
