package me.xiao.leetcode.math;

/**
 * 挨着的逆序对 和 全局的逆序对是不是相等
 * <p>
 * 排好序的数组，每个元素的变动范围不能超过1
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/6 16:52
 */

public class Medium05_GlobalAndLocalInversions {
    public static void main(String[] args) {
        int[] nums = {1, 2, 0};
        System.out.println(new Medium05_GlobalAndLocalInversions().isIdealPermutation(nums));
    }

    private boolean isIdealPermutation(int[] nums) {
        if (nums.length <= 1) return true;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < max) {
                return false;
            } else {
                max = Math.max(max, nums[i - 1]);
            }
        }
        return true;
    }
}
