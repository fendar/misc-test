package net.fendar.test.annotation;

import java.lang.annotation.*;

/**
 * Created by zhongchao on 16/9/27.
 */
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface InheritExam {
}
