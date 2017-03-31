package net.fendar.test.leetcode;

import org.junit.Test;

/**
 * Created by zhongchao on 17/3/4.
 */
public class UniquePathII_63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0)
            return 0;
        int row = obstacleGrid.length, col = obstacleGrid[0].length;
        int[] d = new int[col];

        for (int j = 0; j < col; ++j) {
            d[j] = (j == 0 ? 1 : d[j-1]) & (obstacleGrid[0][j] ^ 1);
        }
        for (int i = 1; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                d[j] = obstacleGrid[i][j] == 1 ? 0 : (j == 0 ? d[j] : d[j-1] + d[j]);
            }
        }
        return d[col-1];
    }

    @Test
    public void test() {
        System.out.println(uniquePathsWithObstacles(new int[][]{{0,0,0},{0,1,0},{0,0,0}}));
    }
}
