package me.xiao.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个数组 和 一个值，找出所有能组成的和
 * <p>
 * 总是往sub-arr里面一个又一个的添加元素：
 * 如果没有符合条件的，那么就把最后一个元素删掉，然后开始下一轮
 * 如果有符合条件的，那个就记录下来，然后开始下一轮
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/3 14:45
 */

public class Medium02_CombinationSum {
    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        System.out.println(new Medium02_CombinationSum().combinationSum(candidates, 7));
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
                doNext(j, results, count + 1, candidates, target - candidates[j], subList);
                subList.remove(subList.size() - 1);
            }
        }
    }
}
