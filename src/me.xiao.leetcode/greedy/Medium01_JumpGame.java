package me.xiao.leetcode.greedy;

/**
 * 从头开始，里面的数字代表"最多可以"跳几步，当然也可以少跳，问能否跳到结尾
 *
 * 倒序查找，总要一步一步的跳，看最后最远的一步能跳到哪就行
 *
 * @author pacman
 * @version 1.0
 * date: 2018/4/13 18:38
 */

public class Medium01_JumpGame {
    public static void main(String[] args) {
//        int[] nums = {1, 2, 1, 0, 4};
        int[] nums = {1, 2, 2, 0, 0};

        System.out.println(new Medium01_JumpGame().canJump(nums));
    }

    private boolean canJump(int[] nums) {
        if (nums.length == 0) return false;
        if (nums.length == 1) return 1 == nums[0];
        int min = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if ((nums[i] + i) >= min) {
                min = i;
            }
        }
        return min == 0;
    }
}
