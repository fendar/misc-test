package net.fendar.test.leetcode;

/**
 * Created by zhongchao on 17/2/26.
 */
public class HouseRobber_198 {
    public int rob(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        int[] w = new int[nums.length];


        for (int i = 0; i < nums.length; ++i) {
            if (i == 0) w[0] = nums[0];
            else if (i == 1) w[1] = Math.max(w[0], nums[1]);
            else w[i] = Math.max(w[i-1], w[i-2] + nums[i]);
        }

        return w[nums.length-1];
    }
}
