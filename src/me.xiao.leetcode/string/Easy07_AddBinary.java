package me.xiao.leetcode.string;

/**
 * 二进制相加
 * 后面的位先相加，如果等于2那么进位
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/1 22:18
 */

public class Easy07_AddBinary {
    public static void main(String[] args) {
        System.out.println(new Easy07_AddBinary().addBinary("111", "11"));
    }

    private String addBinary(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return calculate(s1, s2);
        } else return calculate(s2, s1);
    }

    private String calculate(String s1, String s2) {
        int carry = 0;
        int d = s1.length() - s2.length();
        StringBuilder sb = new StringBuilder();
        for (int i = s1.length() - 1; i >= 0; i--) {
            int first = Integer.parseInt(String.valueOf(s1.charAt(i)));
            int second = i - d >= 0 ? Integer.parseInt(String.valueOf(s1.charAt(i - d))) : 0;
            int sum = (first + second + carry);
            carry = sum / 2;
            sb.append(sum % 2);
        }
        if (carry != 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

}
