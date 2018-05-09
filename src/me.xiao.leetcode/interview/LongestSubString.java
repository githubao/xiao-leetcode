package me.xiao.leetcode.interview;

/**
 * 两个字符串的字串公共子串
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/9 10:44
 */

public class LongestSubString {
    public static void main(String[] args) {
        String s = "1AB2345CD";
        String t = "12345EF";
        System.out.println(new LongestSubString().findLongest(s, t));
    }

    private int findLongest(String s, String t) {
        int m = s.length();
        int n = t.length();

        // dp[i][j] 表示 以s[i]和t[j] 作为公共子串的最后一个字符的情况下，公共子串的最大长度
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = s.charAt(i) == t.charAt(0) ? 1 : 0;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = s.charAt(0) == t.charAt(j) ? 1 : 0;
        }

        int max = -1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = s.charAt(i) == t.charAt(j) ? dp[i - 1][j - 1] + 1 : 0;
                if (dp[i][j] > max) {
                    max = dp[i][j];
                }
            }
        }

        // 找到index
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (dp[i][j] - dp[i - 1][j - 1] == 1) {
                    System.out.println(String.format("(%s,%s)", i, j));
                }

            }
        }

        return max;

    }
}
