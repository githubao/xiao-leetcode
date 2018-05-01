package me.xiao.leetcode.string;

/**
 * 第一个不重复的字符
 *
 * @author pacman
 * @version 1.0
 * date: 2018/4/16 12:01
 */

public class Easy01_FirstUniqueCharacterInAString {
    int[] CHAR = new int[256];

    public static void main(String[] args) {
        System.out.println(new Easy01_FirstUniqueCharacterInAString().firstUniqChar("loveleetcode"));
    }

    private int firstUniqChar(String str) {
        if (str == null || str.length() == 0) return -1;

        for (int i = 0; i < str.length(); i++) {
            CHAR[str.charAt(i)]++;
        }

        for (int i = 0; i < str.length(); i++) {
            if (CHAR[str.charAt(i)] == 1) {
                return i;
            }
        }
        return -1;
    }

}
