package net.fendar.test.mybatis.spring.dao;

import net.fendar.test.annotation.Exam;
import net.fendar.test.mybatis.domain.Music;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * Created by zhongchao on 16/4/12.
 */
public interface MusicMapper {
    @Select("SELECT * FROM music WHERE id = #{id}")
    @Exam
    Music getById(@Param("id") int id);

    @Update("update music set name = 'love summer' where id = 11; update music set name = 'love summer' where id = 12;update music set name = adfds;")
    void updateTest();
}
