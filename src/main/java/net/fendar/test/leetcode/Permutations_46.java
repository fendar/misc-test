package net.fendar.test.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhongchao on 17/2/26.
 */
public class Permutations_46 {
    @Test
    public void test() {
        System.out.println(permute(new int[]{1, 2, 3, 4}));
    }

//    public List<List<Integer>> permute(int[] nums) {
//        return solution(nums, 0);
//    }

    private List<List<Integer>> solution(int[] nums, int j) {
        if (j == nums.length - 1) {
            List<Integer> r = new LinkedList<>();
            r.add(nums[j]);
            List<List<Integer>> ret = new ArrayList<>();
            ret.add(r);
            return ret;
        }

        List<List<Integer>> ret = solution(nums, j + 1);
        List<List<Integer>> res = new ArrayList<>();
        for (List<Integer> list : ret) {
            LinkedList<Integer> newList = new LinkedList<>(list);
            newList.add(0, nums[j]);
            res.add(newList);
        }
        for (List<Integer> list : ret) {
            for (int i = 1; i <= nums.length - j - 1; i++) {
                LinkedList<Integer> newList = new LinkedList<>(list);
                newList.add(i, nums[j]);
                res.add(newList);
            }
        }
        return res;
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        // Arrays.sort(nums); // not necessary
        backtrack(list, new ArrayList<Integer>(), nums);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (tempList.contains(nums[i])) continue; // element already exists, skip
                tempList.add(nums[i]);
                backtrack(list, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
