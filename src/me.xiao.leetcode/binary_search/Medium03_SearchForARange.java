package me.xiao.leetcode.binary_search;

import java.util.Arrays;

/**
 * 查找排好序的一个范围内的索引，target给定
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/3 18:13
 */

public class Medium03_SearchForARange {
    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 8, 10};
        int[] results = new Medium03_SearchForARange().searchRange(nums, 8);
        System.out.println(Arrays.toString(results));
    }

    private int[] searchRange(int[] nums, int target) {
        return new int[]{findIndex(nums, target, true), findIndex(nums, target, false)};
    }

    private int findIndex(int[] nums, int target, boolean isLower) {
        int result = -1;
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                result = mid;

                if (isLower) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return result;
    }
}
