package me.xiao.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 获取两个加和的target的索引
 *
 * @author pacman
 * @version 1.0
 * date: 2018/3/16 11:20
 */

public class Easy03_TwoSum {

    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int target = 6;

        int[] ans = new Easy03_TwoSum().towSum(nums, target);

        System.out.println(Arrays.toString(ans));
    }

    class NumIndex {
        int idx, num;

        NumIndex(int idx, int num) {
            this.idx = idx;
            this.num = num;
        }
    }


    private int[] towSum(int[] nums, int target) {
        List<NumIndex> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            list.add(new NumIndex(i, nums[i]));
        }

        list.sort(Comparator.comparingInt(it -> it.num));

        int[] ans = new int[2];
        for (int i = 0, j = nums.length - 1; i < j; ) {
            NumIndex small = list.get(i);
            NumIndex large = list.get(j);
            int sum = small.num + large.num;
            if (sum == target) {
                ans[0] = small.idx;
                ans[1] = large.idx;
                return ans;
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }

        return null;
    }
}
