package me.xiao.leetcode.dynamic_programming;

import java.util.Arrays;

/**
 * 也是不同偷挨着的房间的，但是现在所有的房间是首尾相连的
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/7 11:20
 */

public class Medium05_HouseRobber2 {
    public static void main(String[] args) {
        int[] nums = {6, 3, 10, 8, 2, 10, 3, 5, 10, 5, 3};
        System.out.println(new Medium05_HouseRobber2().rob(nums));
    }

    private int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        else if (nums.length == 2) return Math.max(nums[0], nums[1]);
        else if (nums.length == 3) return Math.max(Math.max(nums[0], nums[1]), nums[2]);

        int[] dp = new int[nums.length];

        // 倒序第一个抢一遍
        for (int i = nums.length - 1; i > 0; i--) {
            if (i + 3 < nums.length) {
                dp[i] = Math.max(nums[i] + dp[i + 2], nums[i] + dp[i + 3]);
            } else if (i + 2 < nums.length) {
                dp[i] = nums[i] + dp[i + 2];
            } else {
                dp[i] = nums[i];
            }
        }
        int max = Math.max(dp[1], dp[2]);

        // 倒序第二个
        Arrays.fill(dp, 0);
        for (int i = nums.length - 2; i > 0; i--) {
            if (i + 3 < nums.length) {
                dp[i] = Math.max(nums[i] + dp[i + 2], nums[i] + dp[i + 3]);
            } else if (i + 2 < nums.length) {
                dp[i] = nums[i] + dp[i + 2];
            } else {
                dp[i] = nums[i];
            }
        }

        max = Math.max(max, Math.max(dp[0], dp[1]));
        return max;
    }
}
