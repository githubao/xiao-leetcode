package me.xiao.leetcode.dynamic_programming;

/**
 * 最长的回文子字符串
 * <p>
 * 如果两边相等的话，加上2，不相等的话去掉边角的一个的较大者
 * <p>
 * dp[i][j] 代表i-j范围内的最长回文子串
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/7 15:57
 */

public class Medium08_LongestPalindromicSubSequence {
    public static void main(String[] args) {
        System.out.println(new Medium08_LongestPalindromicSubSequence().longestPalindromicSubSequence("bbbab"));
    }

    private int longestPalindromicSubSequence(String s) {
        int[][] dp = new int[s.length() + 1][s.length() + 1];
        String r = new StringBuilder(s).reverse().toString();
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= s.length(); j++) {
                dp[i][j] = (s.charAt(i - 1) == r.charAt(j - 1)) ? dp[i - 1][j - 1] + 1 : Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[s.length()][s.length()];
    }
}
