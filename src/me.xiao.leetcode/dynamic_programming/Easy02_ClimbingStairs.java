package me.xiao.leetcode.dynamic_programming;

/**
 * 爬楼梯 走一步或者走两步，一共有多少种走的方案.
 *
 * 最后一步要么是两步，要么是一步，这两种情况，然后把前面的加起来
 *
 * @author pacman
 * @version 1.0
 * date: 2018/4/13 17:15
 */

public class Easy02_ClimbingStairs {
    public static void main(String[] args) {
        System.out.println(new Easy02_ClimbingStairs().climbStairs(4));
    }

    private int climbStairs(int n) {
        if (n == 0 || n == 1) return 1;
        int[] A = new int[n + 1];
        A[n] = 1;
        A[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            A[i] = A[i + 1] + A[i + 2];
        }
        return A[0];
    }
}
