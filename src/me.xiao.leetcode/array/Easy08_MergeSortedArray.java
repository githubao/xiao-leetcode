package me.xiao.leetcode.array;

import java.util.Arrays;

/**
 * 合并两个已经排好序的数组
 *
 * @author pacman
 * @version 1.0
 * date: 2018/4/9 18:09
 */

public class Easy08_MergeSortedArray {
    public static void main(String[] args) {
        int[] num1 = {2, 4, 6};
        int[] num2 = {1, 3};

        int[] results = new Easy08_MergeSortedArray().merge(num1, 3, num2, 2);

        Arrays.stream(results).forEach(System.out::println);
    }

    private int[] merge(int[] num1, int m, int[] num2, int n) {
        int i = m + n - 1, j = m - 1, k = n - 1;

        int[] results = new int[m + n];

        while (j >= 0 && k >= 0) {
            results[i--] = (num1[j] > num2[k]) ? num1[j--] : num2[k--];
        }

        while (j >= 0) {
            results[i--] = num1[j--];
        }
        while (k >= 0) {
            results[i--] = num2[k--];
        }

        return results;
    }
}
