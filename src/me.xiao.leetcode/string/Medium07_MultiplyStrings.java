package me.xiao.leetcode.string;

/**
 * 计算乘法
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/8 18:28
 */

public class Medium07_MultiplyStrings {
    public static void main(String[] args) {
        System.out.println(new Medium07_MultiplyStrings().multiply("12", "13"));
    }

    private String multiply(String num1, String num2) {
        if (num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0) {
            return "";
        }
        if (num1.charAt(0) == '0' || num2.charAt(0) == '0') {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        int num = 0;
        for (int i = num1.length() + num2.length(); i > 0; i--) {
            for (int j = Math.min(i - 1, num1.length()); j > 0; j--) {
                if ((i - j) <= num2.length()) {
                    num += (num1.charAt(j - 1) - '0') * (num2.charAt(i - j - 1) - '0');
                }
            }

            if (i != 1 || num > 0) {
                sb.append(num % 10);
            }
            num = num / 10;
        }

        return sb.reverse().toString();
    }
}
