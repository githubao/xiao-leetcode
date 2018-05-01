package me.xiao.leetcode.string;

/**
 * 给定一个字符串，查看它是否是一个字串repeat成的
 *
 * @author pacman
 * @version 1.0
 * date: 2018/4/16 13:10
 */

public class Easy02_RepeatedSubstringPattern {

    public static void main(String[] args) {
        System.out.println(new Easy02_RepeatedSubstringPattern().repeatedSubstringPattern("abcabc"));
    }

    private boolean repeatedSubstringPattern(String str) {
        boolean found;
        for (int i = 1; i < str.length(); i++) {
            found = true;
            String sub = str.substring(0, i);
            int j = i;
            while (j < str.length()) {
                if ((j + i) >= str.length() + 1) {
                    return false;
                }
                String sub2 = str.substring(j, j + i);
                if (!sub2.equals(sub)) {
                    found = false;
                    break;
                }
                j += i;
            }
            if (found) return true;
        }
        return false;
    }
}
