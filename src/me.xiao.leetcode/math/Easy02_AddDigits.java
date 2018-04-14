package me.xiao.leetcode.math;

/**
 * 把所有的数加起来，直到加到一位数
 * <p>
 * num = a * 10000 + b * 1000 + c * 100 + d * 10 + e
 * num = (a + b + c + d + e) + (a * 9999 + b * 999 + c * 99 + d * 9)
 *
 * @author pacman
 * @version 1.0
 * date: 2018/4/14 18:46
 */

public class Easy02_AddDigits {
    public static void main(String[] args) {
        System.out.println(new Easy02_AddDigits().addDigits(876));
    }

    private int addDigits(int num) {
        if (num == 0) return 0;
        return num % 9 == 0 ? 9 : num % 9;
    }
}
