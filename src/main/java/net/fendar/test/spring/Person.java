package net.fendar.test.spring;

import net.fendar.test.spring.annotation.Mark;
import net.fendar.test.spring.bean.TargetIface;
import org.springframework.stereotype.Component;

/**
 * Created by zhongchao on 16/3/28.
 */
public class Person implements TargetIface{
    public void work(){
        System.out.println("I am working");
    }

    @Mark
    public void annotationWork() {
        System.out.println("I am working under annotation");
    }
}
