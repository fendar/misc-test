package net.fendar.test.spring.aspect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by zhongchao on 16/5/3.
 */
@Component
public class ServiceImpl implements ServiceIface {
    private static final Logger LOG = LoggerFactory.getLogger(ServiceImpl.class);

    public void service() {
        LOG.info("service impl service");
    }
}
