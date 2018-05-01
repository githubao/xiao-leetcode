package me.xiao.leetcode.string;

/**
 * 查找一个串是不是另一个的子串
 *
 * @author pacman
 * @version 1.0
 * date: 2018/4/16 13:27
 */

public class Easy03_ImplementStrStr {
    public static void main(String[] args) {
        System.out.println(new Easy03_ImplementStrStr().strStr("ABCD", "BC"));
    }

    private int strStr(String haystack, String needle) {
        if (haystack.isEmpty() && needle.isEmpty()) return 0;
        if (needle.isEmpty()) return 0;
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                if (isEqual(haystack, needle, i)) {
                    return i;
                }
            }
        }
        return -1;
    }

    private boolean isEqual(String haystack, String needle, int i) {
        int hl = haystack.length();
        int nl = needle.length();
        int j = 0;
        while (i < hl && j < nl) {
            if (haystack.charAt(i) != needle.charAt(j)) return false;
            i++;
            j++;
        }
        return j >= nl;
    }
}
