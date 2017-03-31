package net.fendar.test.concurrency;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhongchao on 16/4/18.
 */
public class FinalTest {
    private final Integer fint = 1;
    private final List<Integer> ilist = new ArrayList<Integer>();

    public void testModify() {

    }

    public static void main(String[] args) {
        FinalTest finalTest = new FinalTest();

    }
}
