package net.fendar.test.guava;

import com.google.common.collect.Range;
import com.google.common.collect.RangeMap;
import com.google.common.collect.TreeRangeMap;
import org.junit.Test;

/**
 * Created by zhongchao on 17/2/13.
 */
public class RangeTest {
    @Test
    public void test() {
        RangeMap<Integer, Integer> rangeMap = TreeRangeMap.create();

        rangeMap.put(Range.closed(-1, 1), 33);

        System.out.println(rangeMap.get(0));
        System.out.println(rangeMap.get(3));
    }
}
