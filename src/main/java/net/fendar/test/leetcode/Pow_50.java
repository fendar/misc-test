package net.fendar.test.leetcode;

/**
 * Created by zhongchao on 17/2/25.
 */
public class Pow_50 {
    public double pow(double base, int n) {
        if (n == 0)
            return 1.0;
        if (n == 1 || base == 1.0)
            return base;

        double r = n == Integer.MIN_VALUE ? func(base, Integer.MAX_VALUE)*base : func(base, Math.abs(n));
        return n > 0 ? func(base, n) : 1.0 / r;
    }

    private double func(double base, int n) {
        if (n == 1 || base == 0.0)
            return base;

        if ((n & 1) == 1) {
            double r = func(base, n/2);
            return r*r*base;
        }

        double r = func(base, n/2);
        return r*r;

    }

    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE);
    }
}
