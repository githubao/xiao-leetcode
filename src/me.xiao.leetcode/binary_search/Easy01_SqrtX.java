package me.xiao.leetcode.binary_search;

/**
 * 算开方
 *
 * @author pacman
 * @version 1.0
 * date: 2018/4/11 11:43
 */

public class Easy01_SqrtX {
    public static void main(String[] args) {
//        System.out.println(new Easy01_SqrtX().mySqrt(Integer.MAX_VALUE));
        System.out.println(new Easy01_SqrtX().mySqrt(30));
    }

    private int mySqrt(int x) {
        int start = 0, end = x;
        long ans = 0;
        while (start <= end) {
            long medium = start + (end - start) / 2;
            long prod = medium * medium;
            if (prod <= x) {
                start = (int) medium + 1;
                ans = medium;
            } else {
                end = (int) medium - 1;
            }
        }

        return (int) ans;
    }
}
