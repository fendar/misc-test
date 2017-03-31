package net.fendar.test.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhongchao on 17/2/10.
 */
public class LengthOfLongestSubstring {
    @Test
    public void main() {
//        System.out.println(solution("abcabcbb"));
//        System.out.println(solution("bbbbb"));
//        System.out.println(solution("pwwkew"));
//        System.out.println(solution("1234567sdfgh"));

        System.out.println(out("abba"));
    }

    public String out(String s) {
        if (s == null || s.length() == 0)
            return "";

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int start = 0, length = 0;
        int i , j;

        for (i = 0, j = 0; j < s.length(); j++) {
            Character c = s.charAt(j);
            if (map.containsKey(c)) {
                if (length < j - i) {
                    start = i;
                    length = j - i;
                }
                int k = i;
                i = map.get(c) + 1;
                for (; k < i; k++) {
                    map.remove(s.charAt(k));
                }

            }
            map.put(c, j);
        }

        if (length < j - i) {
            start = i;
            length = j - i;
        }

        return s.substring(start, start + length);
    }

    public int solution(String s) {
        if (s == null || s.length() == 0)
            return 0;

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int length = 0;
        int i , j, l;

        for (i = 0, j = 0, l = s.length(); j < l; j++) {
            Character c = s.charAt(j);
            if (map.containsKey(c)) {
                if (length < j - i) {
                    length = j - i;
                }
                int k = i;
                i = map.get(c) + 1;
                for (; k < i; k++) {
                    map.remove(s.charAt(k));
                }

            }
            map.put(c, j);
        }

        if (length < j - i) {
            length = j - i;
        }

        return length;
    }
}
