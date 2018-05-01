package me.xiao.leetcode.string;

/**
 * 最多可以删除一个字符，判断能不能构成回文数
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/1 22:35
 */

public class Easy08_ValidPalindrome2 {
    public static void main(String[] args) {
        System.out.println(new Easy08_ValidPalindrome2().validPalindrome("aaaaaab"));
    }

    private boolean validPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; ) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return isPalindrome(s.substring(i, j)) || isPalindrome(s.substring(i + 1, j + 1));
            }
        }
        return true;
    }

    private boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; ) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else return false;
        }
        return true;
    }
}