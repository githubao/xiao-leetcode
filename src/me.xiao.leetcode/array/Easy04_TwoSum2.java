package me.xiao.leetcode.array;

import java.util.Arrays;

/**
 * 获取排好序的两个加和的target的索引
 *
 * @author pacman
 * @version 1.0
 * date: 2018/4/9 17:32
 */

public class Easy04_TwoSum2 {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int[] results = new Easy04_TwoSum2().twoSum(nums, 18);
        System.out.println(Arrays.toString(results));
    }

    private int[] twoSum(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int x = nums[i] + nums[j];
            if (x == target) {
                return new int[]{i + 1, j + 1};
            } else if (x < target) {
                i++;
            } else {
                j--;
            }
        }

        return new int[2];
    }

}
