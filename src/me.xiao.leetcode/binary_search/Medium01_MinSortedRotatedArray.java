package me.xiao.leetcode.binary_search;

/**
 * 寻找排好序的旋转数组 的最小值
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/3 17:42
 */

public class Medium01_MinSortedRotatedArray {

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 1, 2, 3};
        System.out.println(new Medium01_MinSortedRotatedArray().findMin(nums));
    }

    private int findMin(int[] nums) {
        if (nums.length == 0) return -1;
        else if (nums.length == 1) return nums[0];

        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (mid > 0 && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }

            if (nums[low] > nums[mid]) {
                high = mid - 1;
            } else if (nums[high] < nums[mid]) {
                low = mid + 1;
            } else {
//                正常的排序的情况，就一直向左移
                high = mid - 1;
            }
        }
        return nums[low];
    }
}
