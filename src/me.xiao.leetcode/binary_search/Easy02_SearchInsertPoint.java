package me.xiao.leetcode.binary_search;

/**
 * 给定一个排序的数据，如果有这个值返回，如果没有，返回插入的位置
 *
 * @author pacman
 * @version 1.0
 * date: 2018/4/11 11:49
 */

public class Easy02_SearchInsertPoint {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        System.out.println(new Easy02_SearchInsertPoint().searchInsert(nums, 2));
    }

    private int searchInsert(int[] nums, int target) {
        int pos = nums.length;
        int start = 0, end = pos - 1;
        while (start < end) {
            int medium = start + (end - start) / 2;
            if (nums[medium] >= target) {
                pos = medium;
                end = medium - 1;
            } else {
                start = medium + 1;
            }
        }

        return pos;
    }
}
