package me.xiao.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 可能有重复数据的全排列
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/3 15:53
 */

public class Medium07_Permutations2 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        System.out.println(new Medium07_Permutations2().permute(nums));
    }

    private List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);
        nextPermutation(0, nums, results);
        return results;
    }

    private void nextPermutation(int i, int[] nums, List<List<Integer>> results) {
        if (i == nums.length - 1) {
            List<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            results.add(list);
        } else {
            for (int j = i; j < nums.length; j++) {
//                if (same(nums, i, j)) continue;
                if (j > i && nums[i] == nums[j]) continue;

                swap(nums, i, j);
                nextPermutation(i + 1, Arrays.copyOf(nums, nums.length), results);
//                swap(nums, i, j);
            }
        }
    }

    private boolean same(int[] nums, int i, int j) {
        for (int k = i; k < j; k++) {
            if (nums[i] == nums[k]) {
                return true;
            }
        }
        return false;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
