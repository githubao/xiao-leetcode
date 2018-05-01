package me.xiao.leetcode.string;

/**
 * excel 列的序号
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/1 21:42
 */

public class Easy04_ExcelSheetColumnNumber {
    String CONST = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static void main(String[] args) {
        System.out.println(new Easy04_ExcelSheetColumnNumber().titleNumber("AAB"));
    }

    private int titleNumber(String s) {
        int total = 0;
        int j = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            int pos = CONST.indexOf(c) + 1;
            int pow = (int) Math.pow(26, j++);
            total += (pow * pos);
        }
        return total;
    }
}
