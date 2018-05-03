package me.xiao.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 求组合数
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/3 14:18
 */

public class Medium01_Combinations {
    public static void main(String[] args) {
        System.out.println(new Medium01_Combinations().combine(5, 3));
    }

    private List<List<Integer>> combine(int n, int k) {
        int[] subArr = new int[k];
        List<List<Integer>> results = new ArrayList<>();
        getNext(0, 0, 5, 3, subArr, results);
        return results;
    }

    private void getNext(int i, int count, int n, int k, int[] subArr, List<List<Integer>> results) {
        if (k == 0) {
            List<Integer> subList = new ArrayList<>();
            for (int item : subArr) {
                subList.add(item);
            }
            results.add(subList);
        } else {
            for (int j = i + 1; j <= n; j++) {
                subArr[count] = j;
                getNext(j, count + 1, n, k - 1, subArr, results);
            }
        }
    }
}
