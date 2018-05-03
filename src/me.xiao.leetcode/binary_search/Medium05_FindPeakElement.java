package me.xiao.leetcode.binary_search;

/**
 * 找到尖部的元素，比左右的元素都大，返回该元素的索引
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/3 18:38
 */

public class Medium05_FindPeakElement {
    public static void main(String[] args) {
        int[] nums = {3, 4, 3, 2, 1};
        System.out.println(new Medium05_FindPeakElement().findPeakElement(nums));
    }

    private int findPeakElement(int[] nums) {
        if (nums.length == 1) return 0;
        if (nums[0] > nums[1]) return 0;
        if (nums[nums.length - 1] > nums[nums.length - 2]) return nums.length - 1;

        int start = 0, end = nums.length - 1;
        int result = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (mid - 1 > 0 && mid + 1 < nums.length) {
                if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                    return mid;
                }
            }

            // 如果前面一个值大，那么end往前移
            if (mid - 1 >= 0 && nums[mid - 1] > nums[mid]) {
                end = mid - 1;
            } else {
                result = start;
                start = mid + 1;
            }
        }

        return result;
    }
}
