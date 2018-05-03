package me.xiao.leetcode.binary_search;

/**
 * 排好序的值旋转之后，找target。
 * <p>
 * target在任何地方的各个情况，应该向左还是向右移动
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/3 17:57
 */

public class Medium02_SearchSortedRotatedArray {

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 1, 2, 3};
        System.out.println(new Medium02_SearchSortedRotatedArray().search(nums, 6));
    }

    private int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        else if (nums.length == 1) return nums[0] == target ? 0 : -1;

        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if ((nums[low] <= nums[mid] && (target > nums[mid] || target < low)) ||
                    (nums[low] >= nums[mid] && (target > nums[mid] || target < high))) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return nums[low] == target ? low : -1;
    }
}
