package me.xiao.leetcode.two_pointers;

import java.util.Arrays;

/**
 * 删除重复项。
 * 删除一个排好序的数组的重复的数字，不能新分配空间
 * <p>
 * 把第一个找到的与前面不同的，放在前面的位置
 *
 * @author pacman
 * @version 1.0
 * date: 2018/4/14 20:59
 */

public class Easy02_RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3, 4, 4, 4, 5, 5};
        System.out.println(new Easy02_RemoveDuplicates().removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }

    private int removeDuplicates(int[] nums) {
        if (nums.length <= 1) return nums.length;

        int pos = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                pos += 1;
                nums[pos] = nums[i];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (i >= pos + 1) {
                nums[i] = Integer.MIN_VALUE;
            }
        }

        return pos + 1;
    }
}
