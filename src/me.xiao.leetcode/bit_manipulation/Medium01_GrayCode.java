package me.xiao.leetcode.bit_manipulation;

import java.util.ArrayList;
import java.util.List;

/**
 * gray code
 * 给定一个数字，打印二进制，两个挨着的，只能相差一个字符
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/3 21:19
 */

public class Medium01_GrayCode {
    public static void main(String[] args) {
        List<Integer> results = new Medium01_GrayCode().grayCode(3);
        results.forEach(it -> System.out.println(Integer.toString(it, 2)));
    }

    private List<Integer> grayCode(int n) {
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < ((1 << n) - 1); i++) {
            results.add(i ^ (i >> 1));
        }
        return results;
    }
}
