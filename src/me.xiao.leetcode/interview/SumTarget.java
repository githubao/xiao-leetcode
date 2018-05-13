package me.xiao.leetcode.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * nums里面挑选k个数，和为target
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/10 14:46
 */

public class SumTarget {
    List<Integer> mylist = new ArrayList<>();

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
//        new SumTarget().find(nums, 0, 7);
        new SumTarget().find(nums, 0, 7, 3);
    }

    private void find(int[] nums, int i, int sum, int count) {
        if (sum <= 0 || i == nums.length || count <= 0) {
            return;
        }

        if (sum == nums[i] && count == 1) {
            mylist.forEach(it -> System.out.print(it + ", "));
            System.out.println(nums[i]);
        }

        mylist.add(nums[i]);
        find(nums, i + 1, sum - nums[i], count - 1);

        mylist.remove(mylist.size() - 1);
        find(nums, i + 1, sum, count);
    }

    private void find(int[] nums, int i, int sum) {
        if (sum <= 0 || i == nums.length) {
            return;
        }

        if (sum == nums[i]) {
            mylist.forEach(it -> System.out.print(it + ", "));
            System.out.println(nums[i]);
        }

        mylist.add(nums[i]);
        find(nums, i + 1, sum - nums[i]);

        mylist.remove(mylist.size() - 1);
        find(nums, i + 1, sum);
    }
}
