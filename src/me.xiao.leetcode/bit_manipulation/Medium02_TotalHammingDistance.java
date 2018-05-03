package me.xiao.leetcode.bit_manipulation;

/**
 * 数组的两两的汉明距离的和
 * <p>
 * 每一个具体的位，如果4个1,3个0，那么两两就需要做12次变化
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/3 23:02
 */

public class Medium02_TotalHammingDistance {
    public static void main(String[] args) {
        int[] nums = {2, 4, 14};
        System.out.println(new Medium02_TotalHammingDistance().totalHammingDistance(nums));
    }

    private int totalHammingDistance(int[] nums) {
        int sum = 0;
        for (int i = 0; i < 32; i++) {
            int numsOfOnes = 0;
            int p = (1 << i);
            for (int num : nums) {
                if ((num & p) > 0) {
                    numsOfOnes++;
                }
            }
            sum += (nums.length - numsOfOnes) * numsOfOnes;
        }
        return sum;
    }
}
