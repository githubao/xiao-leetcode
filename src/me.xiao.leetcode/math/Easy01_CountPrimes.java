package me.xiao.leetcode.math;

import java.util.BitSet;

/**
 * 计算素数
 * <p>
 * 把所有的合数都减去，bitset里面存储的是所有的合数
 * <p>
 * set.get(i) 如果这个已经是合数的话，前面的循环已经处理过了，把i可能的合数都加到bitset里面了
 * <p>
 * 最后把数字“1”减去
 *
 * @author pacman
 * @version 1.0
 * date: 2018/4/13 22:42
 */

public class Easy01_CountPrimes {
    public static void main(String[] args) {
//        78446
//        System.out.println(new Easy01_CountPrimes().countPrimes(999187));
        System.out.println(new Easy01_CountPrimes().countPrimes(17));
    }

    private int countPrimes(int n) {
        if (n <= 2) return 0;
        if (n == 3) return 1;
        BitSet set = new BitSet();
        n = n - 1;
        int sqrt = (int) Math.sqrt(n);
        int count = n;
        for (int i = 2; i <= sqrt; i++) {
            if (!set.get(i)) {
                for (int j = 2; (i * j) <= n; j++) {
                    if (!set.get(i * j)) {
                        count--;
                        set.set(i * j);
                    }
                }
            }
        }
        return count - 1;
    }
}
