package me.xiao.leetcode.string;

import java.util.LinkedList;
import java.util.List;

/**
 * 根据单词反转字符串
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/8 15:57
 */

public class Medium01_ReverseWordsInAString {
    public static void main(String[] args) {
        System.out.println(new Medium01_ReverseWordsInAString().reverseWords("  the sky    is blue"));
    }

    private String reverseWords(String s) {
        List<String> results = new LinkedList<>();

        if (s == null || s.isEmpty()) return "";
        String[] split = s.split("\\s+");
        for (int i = split.length - 1; i >= 0; i--) {
            if (split[i].length() == 0) continue;
            results.add(split[i]);
        }

        return String.join(" ", results);

    }
}
