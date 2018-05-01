package me.xiao.leetcode.string;

/**
 * 数数，数上次字符串的字符的个数
 * 1 -> 1
 * 2 -> 一个1 11
 * 3 -> 两个1 21
 * 4 -> 一个2一个1 1211
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/1 23:08
 */

public class Easy09_CountAndSay {
    public static void main(String[] args) {
        System.out.println(new Easy09_CountAndSay().countAndSay(5));
    }

    private String countAndSay(int n) {
        String result = "1";
        for (int i = 1; i < n; i++) {
            int count = 1;
            char num = result.charAt(0);
            StringBuilder sb = new StringBuilder();
            for (int j = 1; j < result.length(); j++) {
                if (result.charAt(j) == num) {
                    count++;
                } else {
                    sb = sb.append(String.valueOf(count)).append(String.valueOf(num));
                    num = result.charAt(j);
                    count = 1;
                }
            }
            sb = sb.append(String.valueOf(count)).append(String.valueOf(num));
            result = sb.toString();
        }
        return result;
    }
}
