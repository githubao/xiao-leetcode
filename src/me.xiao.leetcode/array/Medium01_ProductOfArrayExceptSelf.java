package me.xiao.leetcode.array;

import java.util.Arrays;

/**
 * 计算除了它自己位置的每个值的乘积
 * <p>
 * 把这个数前面的乘起来，后面的乘起来，这样的话遍历两次就好了
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/2 17:40
 */

public class Medium01_ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] results = new Medium01_ProductOfArrayExceptSelf().productExceptSelf(nums);
        System.out.println(Arrays.toString(results));
    }

    private int[] productExceptSelf(int[] nums) {
        int[] results = new int[nums.length];
        for (int i = 0, temp = 1; i < nums.length; i++) {
            results[i] = temp;
            temp *= nums[i];
        }
        for (int i = nums.length - 1, temp = 1; i >= 0; i--) {
            results[i] = results[i] * temp;
            temp *= nums[i];
        }
        return results;
    }
}
