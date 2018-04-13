package me.xiao.leetcode.dynamic_programming;

/**
 * 先买后卖 的最好时机
 *
 * @author pacman
 * @version 1.0
 * date: 2018/4/13 16:55
 */

public class Easy01_BestTimeToBuyAndSellStocks {
    public static void main(String[] args) {
//        int[] nums = {7, 1, 5, 3, 6, 4};
        int[] nums = {7, 6, 4, 3, 1};
        System.out.println(new Easy01_BestTimeToBuyAndSellStocks().maxProfit(nums));
    }

    private int maxProfit(int[] nums) {
        int min = Integer.MAX_VALUE, maxProfit = 0;
        for (int num : nums) {
            int profit = num - min;
            if (profit > maxProfit) {
                maxProfit = profit;
            }
            min = Math.min(num, min);
        }

        return maxProfit;
    }
}
