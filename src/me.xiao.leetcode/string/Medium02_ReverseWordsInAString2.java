package me.xiao.leetcode.string;

/**
 * 按照空格交换，不分配新的空间
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/8 16:05
 */

public class Medium02_ReverseWordsInAString2 {
    public static void main(String[] args) {
        char[] chars = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        new Medium02_ReverseWordsInAString2().reverseWords(chars);
        for (char c : chars) {
            System.out.print(c);
        }
    }

    private void reverseWords(char[] chars) {
        int start = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                reverseWords(chars, start, i-1);
                start = i + 1;
            }
        }
        reverseWords(chars,start,chars.length - 1);

        reverseWords(chars, 0, chars.length - 1);
    }

    private void reverseWords(char[] chars, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            swap(chars, i, j);
        }
    }

    private void swap(char[] chars, int i, int j) {
        char c = chars[i];
        chars[i] = chars[j];
        chars[j] = c;
    }
}
