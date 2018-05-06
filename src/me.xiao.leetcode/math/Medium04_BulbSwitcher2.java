package me.xiao.leetcode.math;

/**
 * n盏灯全亮，m步操作之后，灯的状态
 * <p>
 * 可选的步骤：所有相反，奇数相反，偶数相反，3k+1位置的相反
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/6 16:37
 */

public class Medium04_BulbSwitcher2 {
    public static void main(String[] args) {
        System.out.println(new Medium04_BulbSwitcher2().flipLights(3, 1));
    }

    private int flipLights(int n, int m) {
        if (n == 0) return 0;
        if (m == 0) return 1;
        if (n == 1 && m >= 1) return 2;
        if (n == 2) {
            if (m == 1) return 3;
            if (m >= 2) return 4;
        } else if (n >= 3) {
            if (m == 1) return 4;
            if (m == 2) return 7;
        }
        return 8;
    }
}
