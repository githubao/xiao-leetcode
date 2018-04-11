package me.xiao.leetcode.bit_manipulation;

/**
 * 异或，看某一位是不是一
 * 不同是1，相同是0
 *
 * @author pacman
 * @version 1.0
 * date: 2018/4/11 11:54
 */

public class Easy01_HammingDistance {
    public static void main(String[] args) {
        int a = 1;
        int b = 7;

        System.out.println(new Easy01_HammingDistance().hammingDistance(a, b));
    }

    private int hammingDistance(int x, int y) {
        int z = x ^ y;
        int count = 0;
        for (int i = 0; i < 31; i++) {
            if ((z & (1 << i)) > 0) {
                count++;
            }
        }

        return count;
    }
}
