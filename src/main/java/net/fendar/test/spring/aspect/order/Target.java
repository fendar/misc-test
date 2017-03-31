package net.fendar.test.spring.aspect.order;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by zhongchao on 16/9/21.
 * 日志打印出来是:
 * high aspect start...
 * low aspect starting...
 * target
 * low
 * high
 */
@Component
public class Target {
    private static final Logger LOG = LoggerFactory.getLogger(Target.class);

    public String work(String a) {
        LOG.info("target working...: {}", a);
        return "target return";
    }

    public static String tt(String a) {
        LOG.info("target working...: {}", a);
        return "static target return";
    }
}
