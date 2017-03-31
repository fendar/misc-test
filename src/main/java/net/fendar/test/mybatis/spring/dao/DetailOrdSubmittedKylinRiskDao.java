package net.fendar.test.mybatis.spring.dao;

import net.fendar.test.mybatis.spring.domain.KylinRisk;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by zhongchao on 16/6/2.
 */
@Repository
public interface DetailOrdSubmittedKylinRiskDao {
    String TABLE = "mart_waimai_risk.detail_ord_submitted_kylin_risk";

    //'18806534182'
    @Select("select recipient_phone recipientPhone,wm_poi_id wmPoiId from mart_waimai_risk.detail_ord_submitted_kylin_risk where  recipient_phone=#{phone} and  dt between '20150601' and '20160607' limit 10")
    List<KylinRisk> selectOne(@Param("phone") String phone);


    //test prepareStatement
    @Select("SELECT distinct(recipient_phone) FROM " + TABLE + " WHERE wm_poi_id = #{wmPoiId} #{dt, javaType=java.lang.String, jdbcType=VARCHAR}")
//    @SelectProvider(type = SqlProvider.class, method = "selectPhones")
    List<String> selectPhones(@Param("wmPoiId") int wmPoiId, @Param("dt") String dt);

    @Select("SELECT distinct(recipient_phone) FROM " + TABLE + " WHERE wm_poi_id = #{wmPoiId, javaType=java.lang.Long, jdbcType=INTEGER}")
    List<String> selectAccounts(@Param("wmPoiId") long wmPoiId);

    @Select("select recipient_phone recipientPhone,wm_poi_id from mart_waimai_risk.detail_ord_submitted_kylin_risk where  wm_poi_id = 90822 limit 10")
    List<Map<String, Object>> selectMap();

    @Select("SELECT recipient_phone, user_uuid FROM mart_waimai_risk.detail_wm_ps__wm_ord WHERE recipient_phone = '13972609770'")
    List<Map<String, Object>> selectAccount();


    class SqlProvider {
        public String selectPhones(Map<String, Object> param) {
            String sql= "SELECT distinct(recipient_phone) FROM "
                    + TABLE
                    + " WHERE wm_poi_id = #{wmPoiId} #{dt}";
            return sql.replace("#{wmPoiId}", param.get("wmPoiId").toString()).replace("#{dt}", param.get("dt").toString());
        }
    }
}
