package me.xiao.leetcode.binary_search;

/**
 * 排好序的数组，求hindex
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/3 19:06
 */

public class Medium06_HIndex2 {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1, 15, 20};
        System.out.println(new Medium06_HIndex2().hIndex(nums));
    }

    private int hIndex(int[] citations) {
        if (citations.length == 0) return 0;
        int s = 0, e = citations.length;
        int ans = -1;
        while (s < e) {
            int m = (s + e) / 2;
            int cit = citations.length - m;
            if (citations[m] > cit) {
                if (ans < cit) ans = cit;
                e = m;
            } else {
                if (ans < citations[m]) ans = citations[m];
                s = m + 1;
            }
        }
        return ans;
    }
}
