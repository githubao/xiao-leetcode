package me.xiao.leetcode.dynamic_programming;

/**
 * 未排序的数组的最长递增子串
 * <p>
 * 动态记录更新每个节点的到该节点为止的最长序列是多少，然后+1就是该位置的，然后多个比较取最大值
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/7 14:05
 */

public class Medium06_LongestIncreasingSubSequence {
    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(new Medium06_LongestIncreasingSubSequence().lengthOfLTS(nums));
    }

    private int lengthOfLTS(int[] nums) {
        if (nums.length == 0) return 0;
        int[] results = new int[nums.length];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int lis = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    lis = Math.max(lis, results[j] + 1);
                }
            }

            results[i] = lis;
            max = Math.max(max, results[i]);
        }
        return max;
    }
}
