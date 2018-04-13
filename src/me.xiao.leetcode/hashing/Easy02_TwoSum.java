package me.xiao.leetcode.hashing;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 获取加和的两个数的索引
 *
 * @author pacman
 * @version 1.0
 * date: 2018/4/13 19:59
 */

public class Easy02_TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int[] results = new Easy02_TwoSum().twoSum(nums, 9);
        System.out.println(Arrays.toString(results));
    }

    private int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] results = new int[2];
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int i = 0; i < nums.length; i++) {
            int ele = nums[i];
            int req = target - ele;
            if (map.containsKey(req)) {
                results[0] = i;
                if (req == ele) {
                    int count = map.get(req);
                    if (count > 1) {
                        for (int j = i + 1; j < nums.length; j++) {
                            if (nums[j] == req) {
                                results[1] = j;
                                return results;
                            }
                        }
                    }
                } else {
                    for (int j = i + 1; j < nums.length; j++) {
                        if (nums[j] == req) {
                            results[1] = j;
                            return results;
                        }
                    }
                }
            }
        }
        return null;
    }
}
