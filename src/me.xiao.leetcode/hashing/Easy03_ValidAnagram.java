package me.xiao.leetcode.hashing;

/**
 * 两个单词，两个是不是所有字母都一样。
 * <p>
 * 每个位置的字符的个数
 *
 * @author pacman
 * @version 1.0
 * date: 2018/4/13 20:24
 */

public class Easy03_ValidAnagram {
    int[] S = new int[256];
    int[] T = new int[256];

    public static void main(String[] args) {
        System.out.println(new Easy03_ValidAnagram().isAnagram("anagram", "nagaram"));
    }

    private boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        for (int i = 0; i < s.length(); i++) {
            S[s.charAt(i)]++;
        }
        for (int i = 0; i < t.length(); i++) {
            T[s.charAt(i)]++;
        }
        for (int i = 0; i < 256; i++) {
            if (S[i] != T[i]) return false;
        }
        return true;
    }
}
