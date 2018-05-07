package me.xiao.leetcode.dynamic_programming;

/**
 * 先买后卖股票的最佳时机，先买后卖，多次交易，每次交易需要付费
 * <p>
 * 当前如果买入的话是cash，当前如果卖出的话是stock
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/6 21:26
 */

public class Medium01_BestTimeToBuyAndSellStocksWithFee {
    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 8, 4, 9};
        System.out.println(new Medium01_BestTimeToBuyAndSellStocksWithFee().maxProfit(nums, 2));
    }

    private int maxProfit(int[] prices, int fee) {
        int cash = 0, stock = -prices[0];
        for (int i = 0; i < prices.length; i++) {
            cash = Math.max(cash, prices[i] + stock - fee);
            stock = Math.max(stock, cash - prices[i]);
        }
        return cash;
    }
}
