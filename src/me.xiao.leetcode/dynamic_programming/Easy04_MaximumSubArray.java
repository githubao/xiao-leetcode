package me.xiao.leetcode.dynamic_programming;

/**
 * 最大连续子串
 * <p>
 * 当前到了这一步骤，要么是它自己最大，要么是前面已经最大的加上它
 * <p>
 * 前一个节点存储的是：最大连续字串如果想要包含它的话，最大的子串的和是多少
 *
 * @author pacman
 * @version 1.0
 * date: 2018/4/13 17:46
 */

public class Easy04_MaximumSubArray {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 3};
        System.out.println(new Easy04_MaximumSubArray().maxSubArray2(nums));
    }

    private int maxSubArray(int[] nums) {
        if (nums.length == 1) return nums[0];
        int max = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            nums[i] = Math.max(nums[i], nums[i] + nums[i + 1]);
            max = Math.max(max, nums[i]);
        }

        return max;
    }

    /* 如果为负，把前面的加上，自己只会更小，所以说想要包含我的话，最大的只能是我自己 */
    private int maxSubArray2(int a[]) {
        int maxsum, maxhere;
        maxsum = maxhere = a[0];   //初始化最大和为a【0】
        for (int i = 1; i < a.length; i++) {
            if (maxhere <= 0)
                maxhere = a[i];  //如果前面位置最大连续子序列和小于等于0，则以当前位置i结尾的最大连续子序列和为a[i]
            else
                maxhere += a[i]; //如果前面位置最大连续子序列和大于0，则以当前位置i结尾的最大连续子序列和为它们两者之和
            if (maxhere > maxsum) {
                maxsum = maxhere;  //更新最大连续子序列和
            }
        }
        return maxsum;
    }


}
