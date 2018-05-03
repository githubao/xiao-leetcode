package me.xiao.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 给n对括号，输出所有的可能的组合
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/3 16:43
 */

public class Medium11_GenerateParentheses {

    public static void main(String[] args) {
        System.out.println(new Medium11_GenerateParentheses().generateParentheses(4));
    }

    private List<String> generateParentheses(int n) {
        List<String> list = new ArrayList<>();
        backTrack(list, "", 0, 0, n);
        return list;
    }

    /**
     * 任何情况下，从左边开始数数，左边的括号比右边的多就行
     *
     * @param list
     * @param str
     * @param open
     * @param close
     * @param n
     */
    private void backTrack(List<String> list, String str, int open, int close, int n) {
        if (str.length() == n * 2) {
            list.add(str);
        } else {
            if (open < n) {
                backTrack(list, str.concat("("), open + 1, close, n);
            }
            if (close < open) {
                backTrack(list, str.concat(")"), open, close + 1, n);
            }
        }
    }
}
