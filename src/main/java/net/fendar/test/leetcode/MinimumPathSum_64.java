package net.fendar.test.leetcode;

/**
 * Created by zhongchao on 17/3/2.
 */
public class MinimumPathSum_64 {
    public int minPathSum(int[][] grid) {
        if (grid.length == 0)
            return 0;
        int row = grid.length, col = grid[0].length;
        int[] min = new int[col];

        for (int i = 0; i < col; ++i) {
            min[i] = i == 0 ? grid[0][0] : min[i-1] + grid[0][i];
        }

        for (int i = 1; i < row; i ++) {
            for (int j = 0; j < col; j++) {
                min[j] = j == 0 ? min[0] + grid[i][j] : Math.min(min[j-1], min[j]) + grid[i][j];
            }
        }

        return min[col - 1];
    }
}
