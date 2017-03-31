package net.fendar.test.guava;

import com.google.common.base.Joiner;

import java.util.Arrays;
import java.util.List;

/**
 * Created by zhongchao on 16/6/21.
 */
public class JoinerTest {
    public static void main(String[] args) {
        JoinerTest joinerTest = new JoinerTest();

        joinerTest.testObjectJoin();
    }

    @SuppressWarnings("unchecked")
    private void testObjectJoin() {
        List<Object> list = (List<Object>)(List<?>)Arrays.asList(1, 2 ,3);
        System.out.println(Joiner.on(',').join(list));
    }
}
