package me.xiao.leetcode.array;

import java.util.Arrays;

/**
 * h-index 影响因子， 至少有n篇paper引用次数都不低于n
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/3 11:28
 */

public class Medium10_HIndex {

    public static void main(String[] args) {
        int[] nums = {3, 0, 6, 1, 5};
        System.out.println(new Medium10_HIndex().hIndex(nums));
    }

    private int hIndex(int[] citations) {
        Arrays.sort(citations);

        int h = 0;
        for (int i = 0; i < citations.length; i++) {
            int curr = Math.min(citations[i], citations.length - i);
            if (curr > h) {
                h = curr;
            }
        }
        return h;
    }
}
