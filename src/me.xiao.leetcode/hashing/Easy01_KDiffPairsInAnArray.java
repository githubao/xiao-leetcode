package me.xiao.leetcode.hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * 一个数组中，相差为k的pair对有几个
 *
 * @author pacman
 * @version 1.0
 * date: 2018/4/13 19:02
 */

public class Easy01_KDiffPairsInAnArray {
    public static void main(String[] args) {
        int[] nums = {3, 1, 4, 1, 5};
        System.out.println(new Easy01_KDiffPairsInAnArray().findPairs(nums, 2));
    }

    private int findPairs(int[] nums, int k) {
        if (nums.length == 0) {
            return 0;
        }
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (k == 0) {
                if (entry.getValue() > 1) {
                    count++;
                }
            } else {
                if (map.containsKey(entry.getKey() + k)) {
                    count++;
                }
            }
        }

        return count;
    }
}
