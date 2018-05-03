package me.xiao.leetcode.array;

/**
 * 只交换一次，然后得到最大的整数。
 * 最后位置的最大的数，与第一个交换
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/3 11:13
 */

public class Medium09_MaximumSwap {
    public static void main(String[] args) {
        System.out.println(new Medium09_MaximumSwap().maximumSwap(234379656));
    }

    private int maximumSwap(int num) {
        int[] digits = new int[10];
        char[] chars = String.valueOf(num).toCharArray();
        for (int i = 0; i < chars.length; i++) {
            digits[chars[i] - '0'] = i;
        }

        boolean found = false;
        for (int i = 0; i < chars.length; i++) {
            int digit = chars[i] - '0';
            for (int j = 9; j > digit; j--) {
                if (digits[j] > i) {
                    char temp = chars[i];
                    chars[i] = (char) (j + '0');
                    chars[digits[j]] = temp;
                    found = true;
                    break;
                }
            }
            if (found) break;
        }

        return Integer.parseInt(String.valueOf(chars));
    }
}
