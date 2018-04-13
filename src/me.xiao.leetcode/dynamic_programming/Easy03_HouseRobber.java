package me.xiao.leetcode.dynamic_programming;

/**
 * 抢劫 不能抢劫相邻的房间
 *
 * 走到某一个固定的步数，只有两个选择。要么抢劫这个然后把前面两个的加上，要么不抢这一个
 *
 * @author pacman
 * @version 1.0
 * date: 2018/4/13 17:28
 */

public class Easy03_HouseRobber {
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 8, 3};
        System.out.println(new Easy03_HouseRobber().rob(nums));
    }

    private int rob(int[] nums) {
        if (nums.length == 0) return 0;
        int[] max = new int[nums.length];
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        max[nums.length - 1] = nums[nums.length - 1];
        max[nums.length - 2] = Math.max(nums[nums.length - 1], nums[nums.length - 2]);
        for (int i = nums.length - 3; i >= 0; i--) {
            max[i] = Math.max(max[i + 1], nums[i] + max[i + 2]);
        }
        return max[0];
    }

}
