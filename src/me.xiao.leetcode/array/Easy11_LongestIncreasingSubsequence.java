package me.xiao.leetcode.array;

/**
 * 最长递增子串
 *
 * @author pacman
 * @version 1.0
 * date: 2018/4/9 19:08
 */

public class Easy11_LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 4, 7};
        System.out.println(new Easy11_LongestIncreasingSubsequence().findLengthOfLCIS(nums));
        ;
    }

    private int findLengthOfLCIS(int[] nums) {
        int max = 1, count = 1;
        if (nums.length == 1) {
            return 1;
        }
        if (nums.length == 0) {
            return 0;
        }
        for (int i = 0, j = i + 1; j < nums.length; ) {
            if (nums[j] > nums[i]) {
                count++;
                i++;
                j++;
            } else {
                max = Math.max(max, count);
                count = 0;
                i = j;
                j = j + 1;
            }
        }
        return max;
    }
}
