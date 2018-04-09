package me.xiao.leetcode.array;

import java.util.Arrays;

/**
 * 对数字翻转多次
 * 原地翻转，不使用多余的空间
 *
 * @author pacman
 * @version 1.0
 * date: 2018/4/9 18:42
 */

public class Easy09_RotateArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        new Easy09_RotateArray().rotate(nums, 2);
        System.out.println(Arrays.toString(nums));
    }

    private void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
