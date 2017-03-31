package net.fendar.test.leetcode;

/**
 * Created by zhongchao on 17/3/3.
 */
public class UniquePaths_62 {
    public int uniquePaths(int m, int n) {
        if (m < 1) {
            return 0;
        }
        int[] d = new int[n];
        for (int i = 0; i < n; ++i) {
            d[i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                d[j] = j == 0 ? d[0] : d[j-1] + d[j];
            }
        }
        return d[n-1];
    }
}
