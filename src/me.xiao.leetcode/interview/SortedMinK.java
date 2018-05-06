package me.xiao.leetcode.interview;

/**
 * 两个排好序的数组，两两相加，求第k个最大的
 * <p>
 * 二分，每次最大值最小值对半，然后查看这个数是“第几大”的数
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/5 13:26
 */

public class SortedMinK {

    public static void main(String[] args) {
        int[] num1 = {1, 2, 7};
        int[] num2 = {3, 4, 5};
        System.out.println(new SortedMinK().getKthSum(num1, num2, 4));
    }

    private int getKthSum(int[] A, int[] B, int K) {
        if (A.length == 0 && B.length == 0)
            return 0;
        if (A.length == 0)
            return K > 1 ? B[K - 1] : 0;
        if (B.length == 0)
            return K > 1 ? A[K - 1] : 0;
        if (K == 0)
            return 0;

        int m = A.length - 1;
        int n = B.length - 1;
        int min = A[0] + B[0], max = A[m] + B[n];
        while (min < max) {
            int mid = (max + min) >>> 1;
            int count = Count(mid, A, m, B, n);
            if (count >= K) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }
        return min;
    }

    /**
     * 计算A和B的和中比value大的元素的个数有多少
     *
     * @param value
     * @return
     */
    public int Count(int value, int[] A, int m, int[] B, int n) {
        int count = 0;
        for (int i = 0, j = n; i <= m && j >= 0; ) {
            if (A[i] + B[j] > value) {
                count += m - i + 1;  //因为A[p]+B[j]>value, i<p<=m
                j--;
            } else
                i++;
        }
        return count;
    }

}
