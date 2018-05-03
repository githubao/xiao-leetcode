package me.xiao.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 大小写转化的排列组合
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/3 14:02
 */

public class Easy01_LetterCasePermutation {

    public static void main(String[] args) {
        System.out.println(new Easy01_LetterCasePermutation().letterCasePermutation("a1b2"));
    }

    private List<String> letterCasePermutation(String source) {
        List<String> results = new ArrayList<>();
        backtrack(source, results, 0, "");
        return results;
    }

    private void backtrack(String source, List<String> results, int i, String s) {
        if (i == source.length()) {
            results.add(s);
        } else {
            backtrack(source, results, i + 1, s + source.charAt(i));
            if (Character.isLowerCase(source.charAt(i))) {
                backtrack(source, results, i + 1, s + Character.toUpperCase(source.charAt(i)));
            }
            if (Character.isUpperCase(source.charAt(i))) {
                backtrack(source, results, i + 1, s + Character.toLowerCase(source.charAt(i)));
            }
        }
    }
}
