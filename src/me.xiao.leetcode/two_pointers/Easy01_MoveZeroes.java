package me.xiao.leetcode.two_pointers;

import java.util.Arrays;

/**
 * 把所有的0移动到最后，并保证相对位置
 * <p>
 * 对于所有的不是零的，依次移动到最前面就好了
 *
 * @author pacman
 * @version 1.0
 * date: 2018/4/14 20:55
 */

public class Easy01_MoveZeroes {
    public static void main(String[] args) {
        int[] nums = {0, 0, 0, 0, 1, 0, 1, 0, 2};
        new Easy01_MoveZeroes().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    private void moveZeroes(int[] nums) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
        }
        while (i < nums.length) {
            nums[i++] = 0;
        }
    }
}
