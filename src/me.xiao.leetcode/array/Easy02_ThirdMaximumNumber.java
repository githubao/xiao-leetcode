package me.xiao.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 第三大的数
 *
 * @author pacman
 * @version 1.0
 * date: 2018/3/16 10:19
 */

public class Easy02_ThirdMaximumNumber {
    public static void main(String[] args) {
        int[] a = {1, 2, 2, 3, 3, 4};
//        System.out.println(new Easy02_ThirdMaximumNumber().max(a));
        System.out.println(new Easy02_ThirdMaximumNumber().max(a, null));
    }

    private int thirdMax(int[] nums) {
        int[] max = {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
        int count = 0;

        for (int num : nums) {
            for (int i = 0; i < 3; i++) {
                if (max[i] > num) {
                    continue;
                } else if (max[i] == num) {
                    break;
                }

                int k = i;
                int temp1, temp2;
                temp1 = num;
                count++;
                while (k < 3) {
                    temp2 = max[k];
                    max[k] = temp1;
                    temp1 = temp2;
                    k++;
                }

                break;
            }
        }

        System.out.println(Integer.MIN_VALUE);
        return (count >= 3) ? max[2] : max[0];
    }

    private int max(int[] nums, List<Integer> nLargest) {
        if (null == nLargest) {
            nLargest = new ArrayList<>();
        }

//        如果运行完了还没有找到第三大的
        if (nLargest.size() > 0 && nLargest.size() < 3 && nLargest.get(nLargest.size() - 1) == -1) {
            return nLargest.get(0);
        }

        if (nLargest.size() == 3) {
            System.out.println(nLargest);
            return nLargest.get(2);
        }

        int currentMax = -1;

        for (int num : nums) {
            if (nLargest.size() > 0 && num >= nLargest.get(nLargest.size() - 1)) {
                continue;
            }

            if (num > currentMax) {
                currentMax = num;
            }
        }

//        结束的条件，如果是-1，说明已经排完序。这时候返回的是最小的
        if (currentMax == -1){
            System.out.println(nLargest);
            return nLargest.get(nLargest.size() - 1);
        }

        nLargest.add(currentMax);

        max(nums, nLargest);

        if (nLargest.size() == 0){
            return -1;
        }

        return nLargest.get(nLargest.size() - 1);
    }

}
