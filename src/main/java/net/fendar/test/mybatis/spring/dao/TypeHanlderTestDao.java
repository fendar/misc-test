package net.fendar.test.mybatis.spring.dao;

import net.fendar.test.mybatis.spring.domain.TypeHandlerDomain;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * Created by zhongchao on 16/8/25.
 */
@Repository("thTestDao")
public interface TypeHanlderTestDao {

    @Select("SELECT b FROM fendar_th WHERE ID = #{id}")
    TypeHandlerDomain selectById(int id);

    @Insert("INSERT INTO fendar_th(b) values(#{val})")
    void insert(boolean val);

    @Insert("INSERT INTO fendar_th(b) values(#{b})")
    void insertDomain(TypeHandlerDomain domain);
}
