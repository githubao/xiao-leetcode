package me.xiao.leetcode.dynamic_programming;

/**
 * 最长的回文子序列的长度
 * <p>
 * 以一个点为对称点，然后向两边找，看相不相等
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/7 15:26
 */

public class Medium07_LongestPalindromicSubString {
    public static void main(String[] args) {
        System.out.println(new Medium07_LongestPalindromicSubString().longestPalindrome("cbabd"));
    }

    private String longestPalindrome(String s) {
        int l = s.length();
        int startIndex = 0;
        int maxLen = 1;
        boolean[][] bool = new boolean[l][l];
        for (int i = 0; i < l; i++) {
            bool[i][i] = true;
        }
        for (int i = 0, j = i + 1; j < l; i++, j++) {
            if (s.charAt(i) == s.charAt(j)) {
                bool[i][j] = true;
                startIndex = i;
                maxLen = 2;
            }
        }

        for (int k = 3; k <= l; k++) {
            for (int i = 0, j = k - 1; j < l; i++, j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    bool[i][j] = bool[i + 1][j - 1];
                    if (bool[i][j]) {
                        if (k > maxLen) {
                            startIndex = i;
                            maxLen = k;
                        }
                    }
                }
            }
        }

        return s.substring(startIndex, startIndex + maxLen);
    }
}
