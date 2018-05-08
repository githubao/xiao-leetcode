package me.xiao.leetcode.string;

/**
 * 两个字符串，是不是1的编辑距离
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/8 17:57
 */

public class Medium06_OneEditDistance {
    public static void main(String[] args) {
        System.out.println(new Medium06_OneEditDistance().isOneEditDistance("abxd", "adxb"));
    }

    private boolean isOneEditDistance(String s, String t) {
        if (Math.abs(s.length() - t.length()) > 1 || s.equals(t)) return false;
        if (s.length() > t.length()) {
            return hasDiffOne(s, t, false);
        } else if (s.length() < t.length()) {
            return hasDiffOne(t, s, false);
        } else {
            return hasDiffOne(s, t, true);
        }
    }

    private boolean hasDiffOne(String s, String t, boolean sameLength) {
        int count = 0, i = 0, j = 0;
        for (; i < s.length() && j < t.length(); ) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                if (count > 0) return false;
                count++;
                if (sameLength) {
                    i++;
                    j++;
                } else {
                    i++;
                }
            }
        }

        if (i == j) return true;
        else return s.charAt(s.length() - 1) == t.charAt(t.length() - 1);
    }
}
