package me.xiao.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * subset 里面有数字重复怎么办
 * <p>
 * 已经计算过的，如果有重复，递归的前面一部分，就不计算了
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/3 16:18
 */

public class Medium09_SubSets2 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        System.out.println(new Medium09_SubSets2().subsets(nums));
    }

    private List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        results.add(new ArrayList<>());

        Arrays.sort(nums);

        int start = 0, nextStart;

        for (int i = 0; i < nums.length; i++) {
            nextStart = results.size();
            if (i == 0 || nums[i] != nums[i - 1]) {
                start = 0;
            }
            for (int j = start, len = results.size(); j < len; j++) {
                ArrayList<Integer> list = new ArrayList<>(results.get(j));
                list.add(nums[i]);
                results.add(list);
            }
            start = nextStart;
        }
        return results;
    }
}
