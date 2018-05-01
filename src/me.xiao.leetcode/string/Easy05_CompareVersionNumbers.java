package me.xiao.leetcode.string;

/**
 * 版本号比较,返回1,0,-1
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/1 21:58
 */

public class Easy05_CompareVersionNumbers {
    public static void main(String[] args) {
        System.out.println(new Easy05_CompareVersionNumbers().compareVersion("1.1.0.1", "1.1.0.1.2"));
    }

    private int compareVersion(String v1, String v2) {
        String[] s1 = v1.split("\\.");
        String[] s2 = v2.split("\\.");

        int minLen = s1.length < s2.length ? s1.length : s2.length;

        for (int i = 0; i < minLen; i++) {
            if (Integer.parseInt(s1[i]) > Integer.parseInt(s2[i])) {
                return 1;
            } else if (Integer.parseInt(s1[i]) < Integer.parseInt(s2[i])) {
                return -1;
            }
        }

        if (s1.length < s2.length) {
            for (int i = minLen; i < s2.length; i++) {
                if (Integer.parseInt(s2[i]) > 0) {
                    return -1;
                }
            }
        } else if (s1.length > s2.length) {
            for (int i = minLen; i < s1.length; i++) {
                if (Integer.parseInt(s1[i]) > 0) {
                    return 1;
                }
            }
        }

        return 0;

    }
}
