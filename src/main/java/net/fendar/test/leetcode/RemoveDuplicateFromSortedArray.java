package net.fendar.test.leetcode;

/**
 * Created by zhongchao on 16/10/6.
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 */
public class RemoveDuplicateFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int i = 0, j = 1;
        while (j < nums.length) {
            if (nums[j] != nums[i]) {
                nums[++i] = nums[j];
            }
            j++;

        }
        return i + 1;
    }
}
