package net.fendar.test.leetcode;

import java.util.*;

/**
 * Created by zhongchao on 17/2/22.
 */
public class ThreeSum_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Set<Integer> colors = new HashSet<Integer>();

        for (int i = 0; i < nums.length; ++i) {
            if (colors.contains(nums[i]))
                continue;
            List<List<Integer>> lists = twoSum(nums, i + 1, -nums[i]);
            result.addAll(lists);
            if (lists.size() > 0) {
                colors.add(nums[i]);
            }
        }
        Collections.sort(result, new Comparator<List<Integer>>() {
            public int compare(List<Integer> o1, List<Integer> o2) {
                for (int i = 0; i < 3; ++i) {
                    int a = o1.get(i);
                    int b = o2.get(i);

                    if (a == b)
                        continue;

                    return a > b ? 1 : -1;
                }
                return 0;
            }
        });
        return result;
    }

    private List<List<Integer>> twoSum(int[] arr, int s, int target) {
        Set<Integer> exists = new HashSet<Integer>();
        Set<Integer> colors = new HashSet<Integer>();

        List<List<Integer>> res = new ArrayList<List<Integer>>();

        for (int i = s; i < arr.length; ++i) {
            Integer key = target - arr[i];
            if (exists.contains(key) && !colors.contains(key)) {
                colors.add(key);
                res.add(Arrays.asList(arr[s-1], key, arr[i]));
            } else {
                exists.add(arr[i]);
            }
        }

        return res;
    }
}
