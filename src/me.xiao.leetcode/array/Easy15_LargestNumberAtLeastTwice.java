package me.xiao.leetcode.array;

/**
 * 返回数据 两倍的最大值的索引
 *
 * @author pacman
 * @version 1.0
 * date: 2018/4/9 22:05
 */

public class Easy15_LargestNumberAtLeastTwice {
    public static void main(String[] args) {
        int[] nums = {3, 6, 1, 0};
        System.out.println(new Easy15_LargestNumberAtLeastTwice().dominantIndex(nums));
    }

    private int dominantIndex(int[] nums) {
        int index = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (i == index) {
                continue;
            }

            if (((long) nums[i] * 2) > max) {
                return -1;
            }
        }

        return index;
    }
}
