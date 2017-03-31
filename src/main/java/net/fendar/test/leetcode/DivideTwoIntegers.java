package net.fendar.test.leetcode;

import org.junit.Test;

/**
 * Created by zhongchao on 17/1/23.
 */
public class DivideTwoIntegers {
    public int solution(int dividend, int divisor) {
        if (divisor == Integer.MIN_VALUE)
            return dividend == Integer.MIN_VALUE ? 1 : 0;

        if (divisor == 1)
            return dividend;
        if (divisor == -1)
            return Integer.MIN_VALUE == dividend ? Integer.MAX_VALUE: -dividend;

        boolean neg = false;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            neg = true;
        }

        boolean isMin = dividend == Integer.MIN_VALUE;
        divisor = Math.abs(divisor);
        dividend = isMin ? Integer.MAX_VALUE : Math.abs(dividend);

        if (isMin && divisor == 1) {
            return neg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }

        int n = 0;
        int step = 1;
        int base = divisor;
        while (dividend >= base && base < Integer.MAX_VALUE / 2) {
            n += step;
            dividend -= base;
            base += base;
            step += step;
        }

        while (dividend >= divisor) {
            dividend -= divisor;
            n += 1;
        }

        if (isMin && dividend + 1 == divisor)
            n++;

        return neg ? -n : n;
    }

    @Test
    public void t() {
        System.out.println(Integer.MIN_VALUE);
    }

    @Test
    public void v() {
        System.out.println(solution(Integer.MAX_VALUE, 2));
    }
}
