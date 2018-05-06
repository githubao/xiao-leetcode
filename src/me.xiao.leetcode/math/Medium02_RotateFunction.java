package me.xiao.leetcode.math;

/**
 * 旋转一个数组的最大值，索引和值的乘积的加和
 * 旋转一次其实是每个值的索引减一，除了index=0 到 index=n-1
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/6 16:09
 */

public class Medium02_RotateFunction {
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 6};
        System.out.println(new Medium02_RotateFunction().maxRotateFuncion(nums));
    }

    private int maxRotateFuncion(int[] nums) {
        if (nums.length == 0 || nums.length == 1) return 0;
        int max = Integer.MIN_VALUE;
        int n = nums.length;
        int sum = 0, prodSum = 0;
        for (int i = 0; i < n; i++) {
            prodSum += (nums[i] * i);
            sum += nums[i];
        }
        max = Math.max(max, prodSum);

        for (int i = 0; i < n - 1; i++) {
            prodSum = (prodSum - sum + nums[i] + (n - 1) * nums[i]);
            max = Math.max(max, prodSum);
        }
        return max;
    }
}
