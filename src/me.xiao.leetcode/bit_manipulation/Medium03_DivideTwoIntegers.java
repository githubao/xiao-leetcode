package me.xiao.leetcode.bit_manipulation;

/**
 * 位操作的除法
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/3 23:18
 */

public class Medium03_DivideTwoIntegers {
    public static void main(String[] args) {
        System.out.println(new Medium03_DivideTwoIntegers().divide(15, 3));
    }

    private int divide(int dividend, int divisor) {
        if (divisor == 0) return Integer.MAX_VALUE;
        else if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        else if (divisor == 1) return dividend;

        boolean isNegative = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0);

        dividend = (dividend < 0) ? -dividend : dividend;
        divisor = (divisor < 0) ? -divisor : divisor;

        int sum = 0, result = 0;

        while (true) {
            int base = divisor;

            sum = 0;
            if (dividend - base == 0) {
                sum += 1;
                result += sum;
                break;
            }
            if (dividend - base < 0) {
                break;
            }

            while (dividend - (base << 1) > 0) {
                base <<= 1;
                sum += 1;
            }

            result += (1 << sum);
            dividend = dividend - base;
        }

        return isNegative ? -result : result;
    }
}
