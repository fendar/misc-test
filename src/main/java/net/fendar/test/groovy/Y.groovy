package net.fendar.test.groovy

/**
 * Created by zhongchao on 16/12/25.
 */
public class Y {
    public class X {}
    public X foo() {
        return new X()
    }
    public static X createX(Y y) {
        return new X(y)
    }
}

