package me.xiao.leetcode.math;

/**
 * 给到数字，给定excel表格里面对应的字母
 * <p>
 * 比如 1 -> a 27->aa
 * <p>
 * n = n - 1 可以理解为能够整除没有达到把n减少 一个位数 的效果。
 * 毕竟第26位跟第25位是一样的，都可以用一个字母表示。
 *
 * @author pacman
 * @version 1.0
 * date: 2018/4/14 18:55
 */

public class Easy03_ExcelSheetColumnTitle {
    private static final String CONST = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static void main(String[] args) {
        System.out.println(new Easy03_ExcelSheetColumnTitle().convertToTitle(52));
//        System.out.println(new Easy03_ExcelSheetColumnTitle().convertToTitle(676+26));
    }

    private String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            int mod = n % 26;
            n /= 26;
            if (mod == 0) {
                sb.append('Z');
                n -= 1;
            } else {
                sb.append(CONST.charAt(mod - 1));
            }
        }
        return sb.reverse().toString();
    }
}
