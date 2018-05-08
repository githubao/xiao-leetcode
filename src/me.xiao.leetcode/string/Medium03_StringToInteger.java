package me.xiao.leetcode.string;

/**
 * string to integer
 *
 * 1, 去除空格
 * 2，去除其他字符
 * 3，正负号的判断
 * 4，越界的处理
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/8 16:23
 */

public class Medium03_StringToInteger {
    public static void main(String[] args) throws Exception {
        System.out.println(new Medium03_StringToInteger().myAtoi("    2147483649a sdfasdf"));
    }

    private int myAtoi(String s) {
        if (s == null || s.trim().length() == 0) return 0;

        boolean isPositive = true;
        s = s.trim();
        if (s.charAt(0) == '+') {
            s = s.substring(1, s.length());
        } else if (s.charAt(0) == '-') {
            isPositive = false;
            s = s.substring(1, s.length());
        } else if (s.charAt(0) > '9' || s.charAt(0) < '0') {
            return 0;
        }

        int i;
        for (i = 0; i < s.length(); i++) {
            if (s.charAt(0) > '9' || s.charAt(0) < '0')
                break;
        }

//        找到所有的数字
        s = s.substring(0, i);
        long num = 0;
        for (int j = 0; j < s.length(); j++) {
            int n = (s.charAt(j) - '0');
            num *= 10;
            num += n;
            if (isPositive) {
                if (num > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            } else {
                if ((num * -1) < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            }
        }

        return isPositive ? (int) num : (int) -num;

    }

}
