package me.xiao.leetcode.backtracking;

/**
 * 在一个数组前面加上正负号，求得的所有的和等于target
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/3 19:02
 */

public class Medium12_TargetSum {
    private static int n;

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        System.out.println(new Medium12_TargetSum().findTargetSumWays(nums, 3));
    }

    private int findTargetSumWays(int[] nums, int target) {
        n = 0;
        backtrack(nums, target, 0, 0);
        return n;
    }

    private void backtrack(int[] nums, int target, int sum, int i) {
        if (i == nums.length) {
            if (target == sum) {
                n++;
            }
        } else {
            backtrack(nums, target, sum + nums[i], i + 1);
            backtrack(nums, target, sum - nums[i], i + 1);
        }
    }
}
