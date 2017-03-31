package net.fendar.test.guava;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import org.junit.Test;

/**
 * Created by zhongchao on 16/11/2.
 */
public class MainTest {
    @Test
    public void testMultimap() {
        {
            Multimap<String, String> multimap = HashMultimap.create();

            multimap.put("aa", "bb");
            multimap.put("aa", "bb");
            System.out.printf("HashMultiMap: %s\n", multimap.get("aa"));
        }

        {
            Multimap<String, String> multimap = ArrayListMultimap.create();

            multimap.put("aa", "bb");
            multimap.put("aa", "bb");
            System.out.printf("ArrayListMultiMap: %s",multimap.get("aa"));
        }
    }
}
