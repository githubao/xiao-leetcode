package me.xiao.leetcode.array;

import java.util.Arrays;

/**
 * 数组 三个数字的成绩的最大值
 *
 * @author pacman
 * @version 1.0
 * date: 2018/4/9 17:58
 */

public class Easy06_MaxProductOfThreeNumbers {
    public static void main(String[] args) {
        int[] nums = {-2, -4, 5, -7, 10};
        System.out.println(new Easy06_MaxProductOfThreeNumbers().maxProductOfThreeNumbers(nums));
    }

    private int maxProductOfThreeNumbers(int[] nums) {
        Arrays.sort(nums);

        int len = nums.length;

        int prod1 = nums[len - 1] * nums[len - 2] * nums[len - 3];
        int prod2 = nums[len - 1] * nums[0] * nums[1];

        return prod1 > prod2 ? prod1 : prod2;
    }
}
