package net.fendar.test.spring.bean;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by zhongchao on 16/7/12.
 */
@Component
public class Two {
    @Resource
    private One one;

    public One getOne() {
        return one;
    }
}
