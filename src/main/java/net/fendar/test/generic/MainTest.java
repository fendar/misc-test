package net.fendar.test.generic;

import com.sun.tools.javac.resources.javac;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by zhongchao on 16/10/31.
 */
public class MainTest {
    /**
     * 使用的时候才知道错误，因为类型被擦除了
     */
    @Test
    public void testCast() {
        List<?> list = Arrays.asList(1, 2, 3);
        List<String> list2 = Collections.checkedList((List<String>)list, String.class);


        System.out.println("f");
        System.out.println(list2.get(1));
    }

    /**
     * cast的时候就知道错误了
     */
    @Test
    public void testCast2() {
        Object s = "fdfds";
        Long l = (Long) s;

        System.out.println(l);

    }

    @Test
    public void testArrayGeneric() {
        String[] sa = new String[2];
        Object[] oa = sa;
        oa[0] = 1;


    }

    /**
     * 测试类相同，参数类型不同在运行时的类型是否相同
     * 结论：运行时类型相同！！！
     */
    @Test
    public void testType() {
        List<String> s = new ArrayList<String>();
        List<Integer> i = new ArrayList<Integer>();

        System.out.println(s.getClass().equals(i.getClass()));
    }
}
