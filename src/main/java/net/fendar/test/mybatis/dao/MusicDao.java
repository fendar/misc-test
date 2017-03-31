package net.fendar.test.mybatis.dao;

import net.fendar.test.mybatis.domain.Music;
import net.fendar.test.mybatis.domain.MusicTest;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * Created by zhongchao on 16/3/30.
 */
public interface MusicDao {
    Map<String, Object> selectById(int id);

    @Select("SELECT name pre_name, author pre_author, name preName FROM music")
    List<MusicTest> selectAll();

    int insertOne(@Param("author")String author, @Param("name")String name);

    int insert(Music music);

    int insertMap(Map<String, Object> map);

    @Update("UPDATE music set name = #{name} WHERE author = #{author}")
    int update(Music music);

    @Select("SELECT name FROM music where name = 'sfdsfs'")
    String selectNull();
}
