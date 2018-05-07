package me.xiao.leetcode.dynamic_programming;

import java.util.Arrays;

/**
 * 给定硬币，给定target，所有可能的组合。
 * <p>
 * 要么把这个硬币加进去数量加一，要么把这个跳过什么也不做
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/7 10:24
 */

public class Medium03_CoinChange2 {

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        System.out.println(new Medium03_CoinChange2().change(5, coins));
    }

    private int change(int amount, int[] coins) {
        int[][] arr = new int[coins.length][amount + 1];
        for (int i = 0; i < coins.length; i++) {
            Arrays.fill(arr[i], -1);
        }
        return dp(arr, 0, coins, coins.length, amount);
    }

    private int dp(int[][] arr, int i, int[] coins, int l, int amount) {
        if (amount == 0) return 1;
        else if (i >= l) return 0;
        if (amount < 0) return 0;
        if (arr[i][amount] != -1) return arr[i][amount];
        arr[i][amount] = dp(arr, i + 1, coins, l, amount) + dp(arr, i, coins, l, amount - coins[i]);
        return arr[i][amount];
    }
}
