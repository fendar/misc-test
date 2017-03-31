package net.fendar.test.leetcode;

import org.junit.Test;

/**
 * Created by zhongchao on 17/1/23.
 */
public class RemoveElement {
    @Test
    public int removeElement(int[] nums, int val) {
        int i = 0, j = nums.length - 1;

        while (i <= j) {
            if (nums[i] == val) {
                while (i < j && nums[j] == val)
                    j--;
                if (i == j)
                    break;
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                j--;
            }
            i++;
        }

        return i;
    }
}
