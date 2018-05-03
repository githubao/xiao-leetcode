package me.xiao.leetcode.binary_search;

/**
 * 实现pow
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/3 18:21
 */

public class Medium04_PowXN {
    public static void main(String[] args) {
        System.out.println(new Medium04_PowXN().myPow(2, 15));
    }

    private double myPow(int x, int n) {
        if (n < 0) {
            return 1 / pow(x, -n);
        } else return pow(x, n);
    }

    private double pow(int x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }

        double val = pow(x, n / 2);

        if (n % 2 == 0) {
            return val * val;
        } else {
            return val * val * x;
        }
    }
}
