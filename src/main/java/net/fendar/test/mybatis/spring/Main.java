package net.fendar.test.mybatis.spring;

import net.fendar.test.annotation.Exam;
import net.fendar.test.mybatis.spring.dao.TypeHanlderTestDao;
import net.fendar.test.mybatis.spring.dao.AggrActArrIntegDao;
import net.fendar.test.mybatis.spring.dao.DetailOrdSubmittedKylinRiskDao;
import net.fendar.test.mybatis.spring.dao.MusicMapper;
import net.fendar.test.mybatis.spring.domain.TypeHandlerDomain;
import net.fendar.test.mybatis.spring.service.MusicService;
import net.fendar.test.proxy.jdk.JdkProxy;
import net.fendar.test.util.Prints;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.SpringProxy;
import org.springframework.aop.framework.AopProxyUtils;
import org.springframework.aop.support.AopUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.*;
import java.lang.reflect.Proxy;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by zhongchao on 16/4/12.
 */
@Component
public class Main {
    public static Logger LOG;
    @Resource
    private MusicService musicService;

    @Resource
    private MusicMapper musicMapper;

    @Resource
    private AggrActArrIntegDao arrIntegDao;

    @Resource
    private DetailOrdSubmittedKylinRiskDao kylinRiskDao;

//    @Resource
//    private TypeHanlderTestDao testDao;

    @PostConstruct
    private void init() {
        LOG = LoggerFactory.getLogger(Main.class);
    }


    public static void main(String[] args) throws IOException, SQLException, NoSuchMethodException {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/mybatis-spring-context.xml");

        LOG.info("application started....");
        Main main = context.getBean(Main.class);
        TypeHanlderTestDao bean = (TypeHanlderTestDao) context.getBean("thTestDao");
        System.out.println(bean.selectById(7));
        bean.insertDomain(new TypeHandlerDomain().setB((byte)-1));
//       bean.insert(true);
        main.testAnnotation();
    }

    /**
     * mybatis dao上的注解被代理后
     * @throws NoSuchMethodException
     */
    public void testAnnotation() throws NoSuchMethodException {
        Proxy proxy = (Proxy) musicMapper;
        Class<?> targetClass = AopProxyUtils.ultimateTargetClass(musicMapper);
        Class<?> dClz = targetClass.getMethod("getById", int.class).getDeclaringClass();
        System.out.println(dClz);
        System.out.println(dClz.getMethod("getById", int.class).getAnnotation(Exam.class));
    }


    public void testHandler() {
//        System.out.println(testDao.selectById(1));
    }

    public void testSelectNo() {
        System.out.println(arrIntegDao.selectNoId());
    }

    public void testDatabaseIdProvider() {

    }

    public void testKylinMapKeyUpperCase() {
        List<Map<String, Object>> maps = kylinRiskDao.selectMap();
        System.out.println(maps);
    }

    public void testKylin() {
        System.out.println(kylinRiskDao.selectAccount());
//        System.out.println(kylinRiskDao.selectPhones(90822, " AND dt BETWEEN 20150101 AND 20150801"));
//        System.out.println(kylinRiskDao.selectMap());
    }

    public void testMusicService(int id) {
        Prints.print(musicService.getMusicById(id));
    }

    public void testBatchUpdateTransaction() {
        musicMapper.updateTest();
    }

    /**
     * c3p0数据源、mybatis 未初始化读取数据和初始化后读取数据测试
     */
    //数据库源未初始化 耗时 324ms 363ms 334ms
    //后续耗时 6ms 8ms 5ms
    public void testTime(String phone) {
        long s = System.currentTimeMillis();
        LOG.info("first test time result:" + arrIntegDao.selectByPhone(phone));
        long e = System.currentTimeMillis();
        LOG.info("first time cost: {} ms", e - s);
    }

    //数据库源、mapper 都初始化 耗时 63ms recipient_phone:20150701
    public void testTime2(String phone) {
        long s = System.currentTimeMillis();
        LOG.info("second test time result:" + arrIntegDao.selectByPhone(phone));
        long e = System.currentTimeMillis();
        LOG.info("second time cost: {} ms", e-s);
    }

    //数据库源初始化 耗时 109ms 119ms 120ms
    //后续耗时 34ms 20ms 10ms
    public void testTime3(String phone) {
        long s = System.currentTimeMillis();
        LOG.info("3 test time result:" + arrIntegDao.selectByPhone(phone));
        long e = System.currentTimeMillis();
        LOG.info("3 time cost: {} ms", e-s);
    }

    public String testAop(int i) throws SQLException {
        return "origin string";
    }

    /**
     * c3p0数据源、mybatis 未初始化读取数据和初始化后读取数据结束
     */
    //===============================================

}