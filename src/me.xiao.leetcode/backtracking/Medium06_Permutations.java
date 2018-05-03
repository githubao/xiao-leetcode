package me.xiao.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列
 * <p>
 * 任意两个交换，做完了之后再换回来
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/3 15:43
 */

public class Medium06_Permutations {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(new Medium06_Permutations().permute(nums));
    }

    private List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
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
                swap(nums, i, j);
                nextPermutation(i + 1, nums, results);
                swap(nums, i, j);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
