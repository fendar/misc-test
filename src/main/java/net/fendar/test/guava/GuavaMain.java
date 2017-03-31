package net.fendar.test.guava;

import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhongchao on 16/8/16.
 */
public class GuavaMain {
    @Test
    public void testMapDiff() {
        Map<String, String> map1 = new HashMap<String, String>();
        map1.put("a", "1");
        map1.put("b", "2");
        map1.put("c", "3");
        map1.put("d", "4");

        Map<String, String> map2 = new HashMap<String, String>();
        map2.put("a", "1");
        map2.put("b", "22");
        map2.put("cc", "3");
        map2.put("dd", "44");

        MapDifference<String, String> difference = Maps.difference(map1, map2);

        System.out.println(difference.entriesInCommon());
        System.out.println(difference.entriesOnlyOnLeft());
        System.out.println(difference.entriesOnlyOnRight());
        System.out.println(difference.entriesDiffering());
    }
}
