package net.fendar.test.groovy

/**
 * Created by zhongchao on 16/12/25.
 */
class TmpTest {
    public static void main(String[] args) {
        println Y.createX(new Y());
        println Y.createXError(new Y());
        def l = [1,23,4]
        l.find({it > 3})
    }


}
