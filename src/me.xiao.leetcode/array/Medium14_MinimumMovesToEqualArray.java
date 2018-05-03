package me.xiao.leetcode.array;

import java.util.Arrays;

/**
 * 对每个元素加一或者减一，最少的步数让这个数组相同
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/3 13:52
 */

public class Medium14_MinimumMovesToEqualArray {

    public static void main(String[] args) {
        int[] A = {1, 2, 3};
        System.out.println(new Medium14_MinimumMovesToEqualArray().minMovesToEqual(A));
    }

    /**
     * 找中位数
     *
     * @param nums
     * @return
     */
    private int minMovesToEqual(int[] nums) {
        if (nums.length <= 1) return 0;
        else if (nums.length == 2) return Math.abs(nums[0] - nums[1]);

        Arrays.sort(nums);

        int median;
        if ((nums.length % 2) == 1) {
            median = nums.length / 2;
            int sum = 0;
            for (int num : nums) {
                sum += Math.abs(num - nums[median]);
            }
            return sum;
        } else {
            median = nums.length / 2 - 1;
            int sum1 = 0;
            for (int num : nums) {
                sum1 += Math.abs(num - nums[median]);
            }

            median = nums.length / 2;
            int sum2 = 0;
            for (int num : nums) {
                sum2 += Math.abs(num - nums[median]);
            }

            return Math.min(sum1, sum2);
        }


    }
}
