package me.xiao.leetcode.array;

/**
 * 从零到n，找到消失的一个数字
 *
 * @author pacman
 * @version 1.0
 * date: 2018/4/9 18:04
 */

public class Easy07_MissingNumber {
    public static void main(String[] args) {
        int[] nums = {0, 3, 1};
        System.out.println(new Easy07_MissingNumber().missingNumber(nums));
    }

    private int missingNumber(int[] nums) {
        int n = nums.length + 1;
        int sum = n * (n - 1) / 2;

        int result = 0;
        for (int num : nums) {
            result += num;
        }
        return sum - result;
    }
}
