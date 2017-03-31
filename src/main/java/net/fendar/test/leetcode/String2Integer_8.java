package net.fendar.test.leetcode;

import org.junit.Test;

import static net.fendar.test.util.IOUtil.getConsoleDataInputStream;

/**
 * Created by zhongchao on 17/2/19.
 */
public class String2Integer_8 {
    public int solution(String str) {
        int i = 0;
        while (i < str.length() && str.charAt(i) == ' ')
            i++;
        int k = i;
        while (k < str.length() && k < i+2 && (str.charAt(k) < '0' || str.charAt(k) > '9')) {
            if (str.charAt(k) == '-' || str.charAt(k) == '+')
                k++;
            else
                return 0;
        }
        if (k == str.length() || k >= i+2)
            return 0;

        int r=0;
        for (int j = str.length(); k < j && str.charAt(k) >= '0' && str.charAt(k) <= '9'; ++k) {
            if (r != 0 && (r * 10 == 0 || (r * 10 / 10 ^ r) != 0)) {
                r = -1;
                break;
            }
            r = r*10 + (str.charAt(k) - '0');
            if (r < 0)
                break;
        }

        boolean positive = (str.charAt(i) != '-');
        if (r < 0) {//overflow
            return positive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
       return positive ? r : -r;
    }

    @Test
    public void test() {
        System.out.println(solution("    10522545459"));
        System.out.println(solution("1"));
    }
    @Test
    public void t() {
        long l = Integer.MAX_VALUE + 32L;
        System.out.println(l);
        System.out.println((int)l);
    }
}
