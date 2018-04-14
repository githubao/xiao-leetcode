package me.xiao.leetcode.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 括号是不是匹配
 *
 * @author pacman
 * @version 1.0
 * date: 2018/4/14 20:12
 */

public class Easy02_ValidParentheses {
    private static Map<Character, Character> map = new HashMap<>();

    static {
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        map.put('>', '<');
    }

    public static void main(String[] args) {
        System.out.println(hasBalancedBrackets("({([]])"));
    }

    private static boolean hasBalancedBrackets(String str) {
        if (str == null || str.length() == 0) {
            return true;
        }

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            switch (c) {
                case '(':
                case '{':
                case '[':
                case '<':
                    stack.push(c);
                    break;
                case ')':
                case '}':
                case ']':
                case '>':
                    if (stack.isEmpty()) return false;
                    char top = stack.pop();
                    if (top != map.get(c)) {
                        return false;
                    }
                    break;

                default:

            }
        }
        return stack.isEmpty();
    }
}
