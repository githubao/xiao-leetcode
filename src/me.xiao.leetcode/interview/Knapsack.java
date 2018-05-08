package me.xiao.leetcode.interview;

import java.util.Arrays;

/**
 * 书包容量为15.
 * <p>
 * 东西容量为 2,4,5,6,7
 * 东西价值为 3,3,12,6,10
 * <p>
 * 怎么样装的价值会最大
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/8 14:13
 */

public class Knapsack {

//    private static final int[] w = {0, 2, 2, 6, 5, 4}; //weight
//    private static final int[] p = {0, 6, 3, 5, 4, 6}; //price


    /**
     * [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
     * [0, 0, 0, 0, 0, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12]
     * [0, 0, 0, 0, 3, 12, 12, 12, 12, 15, 15, 15, 15, 15, 15, 15]
     * [0, 0, 0, 0, 3, 12, 12, 12, 12, 15, 15, 15, 22, 22, 22, 22]
     * [0, 0, 3, 3, 3, 12, 12, 15, 15, 15, 15, 18, 22, 22, 25, 25]
     * [0, 0, 3, 3, 3, 12, 12, 15, 15, 15, 15, 18, 22, 22, 25, 25]
     */
    private static final int capacity = 15;
    private static final int[] w = {0, 5, 4, 7, 2, 6}; //weight
    private static final int[] p = {0, 12, 3, 10, 3, 6}; //price

    /**
     * [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
     * [0, 0, 0, 4, 4, 4, 4, 4, 4, 4, 4]
     * [0, 0, 0, 4, 5, 5, 5, 9, 9, 9, 9]
     * [0, 0, 0, 4, 5, 6, 6, 9, 10, 11, 11]
     */
//    private static final int capacity = 10;
//    private static final int[] w = {0, 3, 4, 5}; //weight
//    private static final int[] p = {0, 4, 5, 6}; //price

    private static final int n = w.length - 1;
    private static int[][] dp = new int[n + 1][capacity + 1];


    public static void main(String[] args) {
        Knapsack knapsack = new Knapsack();
        knapsack.knap(capacity, n);
        for (int[] item : dp) {
            System.out.println(Arrays.toString(item));
        }
        System.out.println(Arrays.toString(knapsack.getIndex(capacity, n)));
    }

    /**
     * dp[i][j]: 前i件物品放入容量为j的背包的最大价值
     * <p>
     * i 装了几个
     * j 容量为多少
     * <p>
     * 这个位置的重量比容量大，那么这个位置的跟前一个一样
     * <p>
     * 前一个容量小的位置 如果把这个加上的价值比前一个大的话，就用这个
     * <p>
     * 如果价值小的话，就不把这个加上了，价值还跟之前的一个一样
     *
     * @param cap
     * @param n
     */
    private void knap(int cap, int n) {
        for (int j = 0; j < cap + 1; j++) {
            for (int i = 1; i < n + 1; i++) {
                if (j < w[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else if (dp[i - 1][j - w[i]] + p[i] > dp[i - 1][j]) {
                    dp[i][j] = dp[i - 1][j - w[i]] + p[i];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
    }

    private int[] getIndex(int cap, int n) {
        int[] index = new int[n + 1];

        int j = cap;
        for (int i = n; i > 0; i--) {
            if (dp[i][j] > dp[i - 1][j]) {
                index[i] = 1;
                j -= w[i];
            }
        }
        return index;
    }

    private void knap2(int cap, int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= cap; j++) {
                if (j < w[i]) dp[i][j] = dp[i - 1][j];
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i]] + p[i]);
            }
        }

    }


}
