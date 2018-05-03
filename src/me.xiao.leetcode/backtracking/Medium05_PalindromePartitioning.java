package me.xiao.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 切分一个字符串，保证子数组都是回文的，罗列所有可能的组合
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/3 15:35
 */

public class Medium05_PalindromePartitioning {
    public static void main(String[] args) {
        System.out.println(new Medium05_PalindromePartitioning().partition("aab"));
    }

    private List<List<String>> partition(String str) {
        List<List<String>> results = new ArrayList<>();
        doNext(0, new ArrayList<>(), str, results);
        return results;
    }

    private void doNext(int i, List<String> row, String s, List<List<String>> results) {
        if (i == s.length()) {
            ArrayList<String> list = new ArrayList<>(row);
            results.add(list);
        } else {
            for (int j = i; j < s.length(); j++) {
                String sub = s.substring(i, j + 1);
                if (isPalinedrome(sub)) {
                    row.add(sub);
                    doNext(j + 1, row, s, results);
                    row.remove(row.size() - 1);
                }
            }
        }
    }

    private boolean isPalinedrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
