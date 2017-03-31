package net.fendar.test.mybatis.spring.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * Created by zhongchao on 16/5/24.
 */
@Repository
public interface AggrActArrIntegDao {

//    @Select("SELECT id, phone, wm_order_ip, d_pay_account FROM aggr_act_arr_integ WHERE recipient_phone = #{phone}")
    Map<String, Object> selectByPhone(@Param("phone")String phone);


    @Select("SELECT id FROM aggr_act_arr_integ WHERE recipient_phone = '333'")
    Long selectNoId();
}
