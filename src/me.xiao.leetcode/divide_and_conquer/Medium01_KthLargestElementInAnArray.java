package me.xiao.leetcode.divide_and_conquer;

/**
 * 未排序的数组，k大的
 * <p>
 * index位置，是第几大的数， 然后小的数都在这个数的前面，大的数都在这个数的后面
 * <p>
 * 类似快排的原理
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/4 14:25
 */

public class Medium01_KthLargestElementInAnArray {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};

        System.out.println(new Medium01_KthLargestElementInAnArray().findKthLargest(nums, 2));
    }

    private int findKthLargest(int[] nums, int k) {
        return solve(nums, 0, nums.length - 1, k);
    }

    private int solve(int[] nums, int index, int end, int k) {
        int pivot = nums[end];
        int start = index;

        for (int i = index; i < end; i++) {
            if (nums[i] <= pivot) {
                swap(nums, index, i);
                index += 1;
            }
        }

        swap(nums, index, end);

        int pos = (end - index) + 1;
        if (pos == k) return nums[index];
        else if (pos > k) {
            return solve(nums, index + 1, end, k);
        } else {
            return solve(nums, start, index - 1, k - pos);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
