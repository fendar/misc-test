package net.fendar.test.mybatis.spring.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * Created by zhongchao on 16/5/24.
 */
@Repository
public interface TestDao {

    @Select("SELECT 1")
    void testConnection();
}
