package me.xiao.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 这个相比于之前那个，要求元素唯一
 * <p>
 * 元素可以重复，但是必须是给定的数列里面的
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/3 14:59
 */

public class Medium03_CombinationSum2 {

    public static void main(String[] args) {
//        int[] candidates = {2, 5, 6, 7};
//        int[] candidates = {2, 2, 3, 7};
        int[] candidates = {2, 3, 7};
        System.out.println(new Medium03_CombinationSum2().combinationSum(candidates, 7));
    }

    private List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> subList = new ArrayList<>();
        doNext(0, results, 0, candidates, target, subList);
        return results;
    }

    private void doNext(int i, List<List<Integer>> results, int count, int[] candidates, int target, List<Integer> subList) {
        if (target == 0) {
            List<Integer> result = new ArrayList<>();
            for (int j = 0; j < count; j++) {
                result.add(subList.get(j));
            }
            results.add(result);
        } else if (target > 0) {
            for (int j = i; j < candidates.length; j++) {
                subList.add(candidates[j]);
                doNext(j + 1, results, count + 1, candidates, target - candidates[j], subList);
                subList.remove(subList.size() - 1);
            }
        }
    }
}
