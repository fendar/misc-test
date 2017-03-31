package net.fendar.test.guava;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhongchao on 16/6/21.
 */
public class Multi {
    public static void main(String[] args) {
        Multi multi = new Multi();

        multi.testMultiset();
    }

    public void testMultiset() {
        Multiset<String> multiset = HashMultiset.create();
        multiset.add("adfds");

        Set<String> set = new HashSet<String>();
        set.addAll(multiset);

        for (String ab : multiset) {
            System.out.println(ab);
        }
    }
}
