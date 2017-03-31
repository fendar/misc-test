package net.fendar.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by zhongchao on 17/3/21.
 */
public class AbstractClass {
    enum TEnum {
        ONE
    }
    interface TAC {
        TEnum run();
    }

    abstract class ATAC implements TAC {

    }

    /**
     * 匿名类的构造函数会以捕获的变量作为参数
     * 下面的 {t} 是有2个参数的构造函数
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws InstantiationException
     */
    public void test() throws IllegalAccessException, InvocationTargetException, InstantiationException {
        final TEnum u = TEnum.ONE;
        TAC t = new ATAC() {
            @Override
            public TEnum run() {
                return u;
            }
        };
        t.run();

        Class<? extends TAC> aClass = t.getClass();

        Constructor<?> constructors = aClass.getDeclaredConstructors()[0];

        constructors.setAccessible(true);

        ((TAC)constructors.newInstance()).run();
    }

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        AbstractClass main = new AbstractClass();
        main.test();
    }
}
