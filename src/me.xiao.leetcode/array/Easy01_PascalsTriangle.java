package me.xiao.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 杨辉三角
 *
 * @author pacman
 * @version 1.0
 * date: 2018/3/15 19:00
 */

public class Easy01_PascalsTriangle {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            List<Integer> results = new Easy01_PascalsTriangle().getRow2(i);
            System.out.println(results);
        }
    }

    private List<Integer> getRow(int rowIndex) {
        int k = rowIndex;
        if (k == 0) {
            return Collections.singletonList(1);
        } else if (k == 1) {
            return Arrays.asList(1, 1);
        } else if (k == 2) {
            return Arrays.asList(1, 2, 1);
        }

        ArrayList<Integer> result = new ArrayList<>();
        result.add(2);
        k = k - 2;
        int p, c;
        while (k-- > 0) {
            p = 1;
            for (int i = 0; i < result.size(); i++) {
                c = result.get(i);
                result.set(i, p + c);
                p = c;
            }
            result.add(p + 1);
        }

        result.add(0, 1);
        result.add(1);

        return result;
    }

    /**
     * 二项式的系数 组合系数
     *
     * @param rowIndex
     * @return
     */
    private List<Integer> getRow2(int rowIndex) {
        ArrayList<Integer> results = new ArrayList<>();

        results.add(1);

        for (int i = 1; i <= rowIndex; i++) {
            int res = 1;
            int k = rowIndex;
            for (int j = 1; j <= i; j++) {
                res *= k;
                k = k - 1;
            }

            for (int j = 1; j <= i; j++) {
                res /= j;
            }

            results.add(res);
        }

        return results;

    }

}
