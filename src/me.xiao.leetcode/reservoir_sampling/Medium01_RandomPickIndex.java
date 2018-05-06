package me.xiao.leetcode.reservoir_sampling;

import java.util.Arrays;
import java.util.Random;

/**
 * 随机序列取样,返回任意一个index的索引值
 * <p>
 * 遍历两遍，然后随机树，第二次遍历输出一个就可以
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/4 17:32
 */

public class Medium01_RandomPickIndex {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 3};
        System.out.println(new Medium01_RandomPickIndex().pick(nums, 3));
    }

    private int pick(int[] nums, int target) {
        int count = (int) Arrays.stream(nums).filter(it -> it == target).count();

        Random random = new Random();
        int nPick = 1 + random.nextInt(count);
        count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                if (++count == nPick) {
                    return i;
                }
            }
        }

        return -1;
    }


}
