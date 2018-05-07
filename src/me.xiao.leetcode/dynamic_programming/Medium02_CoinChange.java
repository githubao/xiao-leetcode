package me.xiao.leetcode.dynamic_programming;

/**
 * 不同面值的硬币，得到target需要的最少的硬币数量
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/6 21:37
 */

public class Medium02_CoinChange {
    private int[][] DP;

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        System.out.println(new Medium02_CoinChange().coinChange(coins, 11));
    }

    private int coinChange(int[] coins, int amount) {
        DP = new int[coins.length][amount + 1];
        int result = dp(amount, 0, coins);
        return result == Integer.MAX_VALUE - 1 ? -1 : result;
    }

    private int dp(int amount, int i, int[] coins) {
        if (amount == 0) return 0;
        else if (i >= coins.length || amount < 0) {
            return Integer.MAX_VALUE - 1;
        }

        if (DP[i][amount] != 0) return DP[i][amount];

        DP[i][amount] = Math.min(1 + dp(amount - coins[i], i, coins), dp(amount, i + 1, coins));

        return DP[i][amount];
    }
}
