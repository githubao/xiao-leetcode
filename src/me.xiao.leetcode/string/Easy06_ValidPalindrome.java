package me.xiao.leetcode.string;

/**
 * 判断是不是回文
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/1 22:11
 */

public class Easy06_ValidPalindrome {
    public static void main(String[] args) {
        System.out.println(new Easy06_ValidPalindrome().isPalindrome("989 "));
    }

    private boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) return true;
        for (int i = 0, j = s.length() - 1; i < j; ) {
            char a = s.charAt(i);
            char b = s.charAt(j);
            if (!(a >= 'a' && a <= 'z') && !(a >= '0' && a <= '9')) {
                i++;
                continue;
            }
            if (!(b >= 'a' && b <= 'z') && !(b >= '0' && b <= '9')) {
                j--;
                continue;
            }
            if (a != b) return false;

            i++;
            j--;
        }

        return true;
    }
}
