package net.fendar.test.leetcode;

/**
 * Created by zhongchao on 17/2/27.
 */
public class MaximumSubarray_53 {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int selfMax = nums[0];

        for (int i = 1; i < nums.length; ++i) {
            selfMax = Math.max(selfMax + nums[i], nums[i]);
            max = Math.max(max, selfMax);
        }

        return max;
    }

//    public int maxSubArray2(int[] nums) {
//
//    }
//
//    private int[] divideAndConquer(int[] nums, int i, int j) {
//        if (i == j)
//            return new int[]{3, nums[i]};
//        int m = (i + j) / 2;
//        int[] lmax = divideAndConquer(nums, i, m);
//        int[] rmax = divideAndConquer(nums, m + 1, j);
//
//
//    }
}
