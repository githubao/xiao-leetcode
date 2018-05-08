package me.xiao.leetcode.string;

/**
 * 给一个target，看字符串里面有没有另一个的 全排列 的模式
 *
 * 从左向右滑动，比较字符相不相等就行
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/8 17:40
 */

public class Medium08_PermutationInString {
    private int[] S1 = new int[256];
    private int[] S2 = new int[256];

    public static void main(String[] args) {
        System.out.println(new Medium08_PermutationInString().checkInclusion("ab", "eidbaooo"));
    }

    private boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) return false;
        for (int i = 0; i < s1.length(); i++) {
            S1[s1.charAt(i)]++;
            S2[s2.charAt(i)]++;
        }

        if (isEqual()) return true;

        for (int i = 1, j = s1.length(); j < s2.length(); i++, j++) {
            S2[s2.charAt(i - 1)]--;
            S2[s2.charAt(j)]++;
            if (isEqual()) return true;
        }

        return false;

    }

    public boolean isEqual() {
        for (int i = 0; i < 256; i++) {
            if (S1[i] != S2[i]) {
                return false;
            }
        }
        return true;
    }
}
