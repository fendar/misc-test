package net.fendar.test.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by zhongchao on 17/2/19.
 */
public class LongestCommonPrefix_14 {
    public String solution2(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";

        int ml = strs[0].length();
        for (int i = 1; i < strs.length; ++i) {
            if (ml > strs[i].length())
                ml = strs[i].length();
        }

        Arrays.sort(strs);

        int l = 0;
        for (; l < ml; ++l) {
            char c = strs[0].charAt(l);
            int j = 1;
            for (; j < strs.length; ++j) {
                if (strs[j].charAt(l) != c)
                    break;
            }
            if (j < strs.length)
                break;
        }

        if (l == 0)
            return "";
        return strs[0].substring(0, l);
    }

    public String solution(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";

        if (strs.length == 1)
            return strs[0];

        int ml = strs[0].length();
        for (int i = 1; i < strs.length; ++i) {
            if (ml > strs[i].length())
                ml = strs[i].length();
        }

        Arrays.sort(strs);
        String first = strs[0];
        String end = strs[strs.length - 1];

        int l = 0;
        for (; l < ml; ++l) {
            char c1 = first.charAt(l);
            char c2 = end.charAt(l);

            if (c1 != c2)
                break;
        }

        if (l == 0)
            return "";
        return strs[0].substring(0, l);
    }

    @Test
    public void test() {
        System.out.println(solution(new String[]{"aaa", "aabb", "a", "a"}));
        System.out.println(solution(new String[]{"aaa", "aabb", "a", "a"}));
        System.out.println(solution(new String[]{"aaa", "b", "c", "d"}));
        System.out.println(solution(new String[]{"aaa", "b", "c", ""}));
        System.out.println(solution(new String[]{"aaa"}));
    }
}
