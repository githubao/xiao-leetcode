package me.xiao.leetcode.array;

import java.util.Arrays;

/**
 * 两个数组，第一个是第二个的子集，在第二个里面找到第一个的元素，然后找到它右边的第一个比它大的元素
 *
 * @author pacman
 * @version 1.0
 * date: 2018/4/9 21:58
 */

public class Easy14_NextGreaterElement1 {
    public static void main(String[] args) {
//        int[] num1 = {4, 1, 2};
//        int[] num2 = {1, 3, 4, 2};
        int[] num1 = {2, 4};
        int[] num2 = {1, 2, 3, 4};
        int[] results = new Easy14_NextGreaterElement1().nextGreaterElement(num1, num2);
        System.out.println(Arrays.toString(results));
    }

    private int[] nextGreaterElement(int[] num1, int[] num2) {
        int[] results = new int[num1.length];
        for (int i = 0; i < num1.length; i++) {
            int n = num1[i];
            boolean found = false;
            int target = -1;
            for (int j = 0; j < num2.length; j++) {
                if (num2[j] == n) {
                    found = true;
                }
                if (found) {
                    if (num2[j] > n) {
                        target = num2[j];
                        break;
                    }
                }
            }

            results[i] = target;

        }
        return results;
    }
}
