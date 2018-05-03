package me.xiao.leetcode.array;

import java.util.Arrays;

/**
 * 0,1,2 数组排序，使用 one-pass的空间复杂度
 * <p>
 * 两个指针，0往前移动指针后移，2往后移动指针前移
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/2 20:31
 */

public class Medium05_SortColors {
    public static void main(String[] args) {
        int[] nums = {2, 1, 0, 0, 1};
        new Medium05_SortColors().sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    private void sortColors(int[] nums) {
        int s = nums[0];
        nums[0] = 1;
        int leftIndex = 0, rightIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            switch (nums[i]) {
                case 0:
                    nums[leftIndex] = 0;
                    nums[rightIndex + 1] = 1;
                    if (rightIndex + 1 != i) {
                        nums[i] = 2;
                    }
                    leftIndex++;
                    rightIndex++;
                    break;
                case 1:
                    nums[rightIndex + 1] = 1;
                    if (rightIndex + 1 != i) {
                        nums[i] = 2;
                    }
                    rightIndex++;
                    break;
            }
        }
        if (s == 0) {
            nums[leftIndex] = 0;
        } else if (s == 2) {
            nums[rightIndex] = 2;
        }
    }
}
