package me.xiao.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 两个list里面的相同的index和的最小值
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/3 12:15
 */

public class Easy17_MinimumIndexSumOfTwoLists {

    public static void main(String[] args) {
        String[] A1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] A2 = {"Tapioca Express", "Shogun", "Burger King"};
        String[] ans = new Easy17_MinimumIndexSumOfTwoLists().findRestaurant(A1, A2);
        System.out.println(Arrays.asList(ans));
    }

    private String[] findRestaurant(String[] arr1, String[] arr2) {
        int min = Integer.MAX_VALUE;
        HashMap<String, Integer> map = new HashMap<>();
        List<String> results = new ArrayList<>();

        for (int i = 0; i < arr1.length; i++) {
            map.put(arr1[i], i);
        }

        for (int i = 0; i < arr2.length; i++) {
            if (map.containsKey(arr2[i])) {
                int sum = map.get(arr2[i]) + i;
                min = Math.min(min, sum);
            }
        }

        for (int i = 0; i < arr2.length; i++) {
            String s = arr2[i];
            if (map.containsKey(s)) {
                int sum = map.get(s) + i;
                if (sum == min) results.add(s);
            }
        }

        String[] res = new String[results.size()];
        results.toArray(res);
        return res;

    }

}
