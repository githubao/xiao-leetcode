package me.xiao.leetcode.array;

import java.util.Arrays;

/**
 * 倒水，低点先填满
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/3 13:43
 */

public class Medium13_PourWater {
    public static void main(String[] args) {
        int[] nums = {2, 1, 1, 2, 1, 2, 2};
        int[] results = new Medium13_PourWater().pourWater(nums, 4, 3);
        System.out.println(Arrays.toString(results));
    }

    /**
     * @param heights
     * @param v       倒几个
     * @param k       起始的index的位置
     * @return
     */
    private int[] pourWater(int[] heights, int v, int k) {
        while (v-- > 0) {
            heights[k] += 1;

            int index = k;
            int min = heights[k];

            for (int i = k - 1; i >= 0; i--) {
                if (heights[i] + 1 > min) {
                    break;
                } else if (heights[i] + 1 < min) {
                    min = heights[i] + 1;
                    index = i;
                }
            }

            if (index == k) {
                for (int i = k + 1; i < heights.length; i++) {
                    if (heights[i] + 1 > min) {
                        break;
                    } else if (heights[i] + 1 < min) {
                        min = heights[i] + 1;
                        index = i;
                    }
                }
            }

            if (index != k) {
                heights[k]--;
                heights[index]++;
            }
        }
        return heights;
    }
}
