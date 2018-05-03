package me.xiao.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 获得所有的set的子集
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/3 16:05
 */

public class Medium08_SubSets {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(new Medium08_SubSets().subsets(nums));
    }

    private List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        results.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0, len = results.size(); j < len; j++) {
                ArrayList<Integer> list = new ArrayList<>(results.get(j));
                list.add(nums[i]);
                results.add(list);
            }
        }
        return results;
    }
}
