package me.xiao.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 和为k的连续子数组的个数
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/3 12:31
 */

public class Medium12_SubArraySumEqualsK {

    public static void main(String[] args) {
        int[] A = {1, 2, 1, -2, 3, -1, -1};
        System.out.println(new Medium12_SubArraySumEqualsK().subArraySum(A, 2));
    }

    private int subArraySum2(int[] numbers, int target) {
        int res = 0;
        for (int i = 0; i < numbers.length; i++) {
            int sum = numbers[i];
            if (sum == target) ++res;
            for (int j = i + 1; j < numbers.length; j++) {
                sum += numbers[j];
                if (sum == target) ++res;
            }
        }
        return res;
    }

    private int subArraySum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for (int num : numbers) {
            sum += num;
            map.merge(sum, 1, (a, b) -> a + b);
        }
        sum = 0;
        int result = 0;
        for (int num : numbers) {
            int key = sum + target;
            if (map.containsKey(key)) {
                int count = map.get(key);
                result += count;
            }
            sum += num;
            if (map.containsKey(sum)) {
                int count = map.get(sum);
                if (count - 1 > 0) {
                    map.put(sum, count - 1);
                } else {
                    map.remove(sum);
                }
            }
        }
        return result;
    }
}
