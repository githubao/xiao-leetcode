package me.xiao.leetcode.math;

import java.math.BigInteger;

/**
 * x,y两个罐子，多次倒水和盛水，能不能得到z的水量的水
 * <p>
 * 最大公约数
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/6 16:27
 */

public class Medium03_WaterAndJugProblem {
    public static void main(String[] args) {
        System.out.println(new Medium03_WaterAndJugProblem().canMeatureWater(9, 11, 6));
    }

    private boolean canMeatureWater(int x, int y, int z) {
        if (x == z || y == z) return true;
        if (z > (x + y)) return false;
        BigInteger b1 = new BigInteger(String.valueOf(x));
        BigInteger b2 = new BigInteger(String.valueOf(y));

        BigInteger gcd = b1.gcd(b2);

        return gcd.intValue() != 0 && (z % gcd.intValue()) == 0;

    }
}
