package me.xiao.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 电话号码上的数字组合
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/3 15:18
 */

public class Medium04_LetterPhoneNumber {
    private String[] NUMBER_ALPHA = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static void main(String[] args) {
        System.out.println(new Medium04_LetterPhoneNumber().letterCombinations("23"));
    }

    private List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty() || digits.contains("1") || digits.contains("0")) {
            return new ArrayList<>();
        }
        List<String> prev = new ArrayList<>();
        prev.add("");

        for (int i = digits.length() - 1; i >= 0; i--) {
            String str = NUMBER_ALPHA[Integer.parseInt(String.valueOf(digits.charAt(i)))];
            List<String> curr = new ArrayList<>();
            for (int j = 0; j < str.length(); j++) {
                for (String s : prev) {
                    s = str.charAt(j) + s;
                    curr.add(s);
                }
            }

            prev = curr;
        }
        return prev;
    }
}
