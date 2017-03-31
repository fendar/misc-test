package net.fendar.test.leetcode;

/**
 * Created by zhongchao on 17/3/4.
 */
public class ClimbingStairs_70 {
    public int climbStairs(int n) {
        int a = 0, b = 1;
        for (int i = 1; i <= n ;++i) {
            int c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
}
