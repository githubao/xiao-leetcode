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
//        int[] coins = {1, 2, 5};
        int[] coins = {4, 5, 10};
        System.out.println(new Medium02_CoinChange().coinChange2(coins, 11));
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

    /**
     * dp的含义： 和为i的硬币，需要的最小硬币数
     * <p>
     * 不把硬币放进去 和 把硬币放进去 的最小值
     *
     * @param coins
     * @param amount
     * @return
     */
    private int coinChange2(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) dp[i] = 0x7fff_fffe;
        for (int coin : coins)
            for (int i = coin; i <= amount; i++)
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);

        return dp[amount] == 0x7fff_fffe ? -1 : dp[amount];
    }


}
