package net.fendar.test.leetcode;

/**
 * Created by zhongchao on 16/9/15.
 */
public class UglyNumber {


    static class Solution {
        public boolean isUgly(int num) {
            while (num % 2 == 0)
                num /= 2;
            while (num % 3 == 0)
                num /= 3;
            while (num % 5 == 0)
                num /= 5;

            return num == 1;
        }
    }
}
