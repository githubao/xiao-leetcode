package me.xiao.leetcode.array;

import java.util.Arrays;

/**
 * 数组中 有没有三个绝对递增的
 * <p>
 * O(n) 的时间复杂度 O(1)的空间复杂度
 * <p>
 * 需要经过“三关”才能到达目的地，一旦失败就重新开始
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/3 11:47
 */

public class Medium11_IncreasingTripleSubSequence {

    public static void main(String[] args) {
        int[] nums = {5, 6, 2, 3, 1};
        System.out.println(new Medium11_IncreasingTripleSubSequence().increasingTriplet(nums));
    }

    private boolean increasingTriplet(int[] nums) {
        int[] arr = new int[3];
        Arrays.fill(arr, Integer.MAX_VALUE);
        for (int num : nums) {
            if (num < arr[0]) {
                arr[0] = num;
            } else if (num < arr[1] && arr[0] < num) {
                arr[1] = num;
            } else if (num < arr[2] && arr[1] < num) {
                return true;
            }
        }
        return false;
    }
}
