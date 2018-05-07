package me.xiao.leetcode.dynamic_programming;

/**
 * A-Z 与 1-26 对应
 * 给定一个数字，返回他可能的对应字母的数量
 * <p>
 * 比如 12 可以是L 也可以是AB
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/7 11:09
 */

public class Medium04_DecodeWays {
    public static void main(String[] args) {
        System.out.println(new Medium04_DecodeWays().numDecodings("12"));
    }

    private int numDecodings(String num) {
        if (num == null || num.length() == 0) return 0;
        int[] dp = new int[num.length() + 2];
        dp[num.length()] = 1;
        dp[num.length() + 1] = 1;
        for (int i = num.length() - 1; i >= 0; i--) {
            for (int j = i + 1; j < i + 3; j++) {
                if (j <= num.length()) {
                    String sub = num.substring(i, j);
                    if (!sub.startsWith("0")) {
                        int intVal = Integer.parseInt(sub);
                        if (intVal <= 26) {
                            dp[i] += dp[j];
                        }
                    }
                }
            }
        }
        return dp[0];
    }
}
