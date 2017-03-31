package net.fendar.test.spring.bean;

import net.fendar.test.spring.annotation.Mark;

/**
 * Created by zhongchao on 16/7/22.
 */
public interface TargetIface {
    @Mark
    void work();
}
