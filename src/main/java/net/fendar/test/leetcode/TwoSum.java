package net.fendar.test.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhongchao on 16/9/10.
 */
public class TwoSum {
    @Test
    public void twoSum() {
        System.out.println(Arrays.toString(sovle(new int[]{6,3,2,4,13123,912,6}, 6)));
    }

    public int[] sovle(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; ++i) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; ++i) {
            Integer find = target - nums[i];
            Integer j = map.get(find);
            if (map.containsKey(find) && i != j)
                return i > j ? new int[]{j, i} : new int[]{i, j};
        }
        return null;
    }
}
