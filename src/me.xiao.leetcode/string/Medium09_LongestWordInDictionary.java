package me.xiao.leetcode.string;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 给定一个字符串 和 一个列表的字符串
 * 删除字符串的字符，判断能组成列表字符串的最长的那个
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/8 18:50
 */

public class Medium09_LongestWordInDictionary {
    public static void main(String[] args) {
        List<String> dict = Arrays.asList("ale", "apple", "monkey", "plea");
        System.out.println(new Medium09_LongestWordInDictionary().findLongestWord("abpcplea", dict));
    }

    private String findLongestWord(String s, List<String> dict) {
        Collections.sort(dict, Comparator.comparing(String::length).reversed().thenComparing(String::compareTo));
        for (String d : dict) {
            if (d.length() <= s.length()) {
                int i = 0, j = 0;
                for (; i < s.length() && j < d.length(); ) {
                    if (s.charAt(i) == d.charAt(j)) {
                        i++;
                        j++;
                    } else {
                        i++;
                    }
                }
                if (j >= d.length()) return d;
            }
        }
        return "";
    }


}
