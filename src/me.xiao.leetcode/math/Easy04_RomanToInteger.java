package me.xiao.leetcode.math;

import java.util.HashMap;

/**
 * 把罗马数字转化成对应的数字
 * <p>
 * 相同的数字连写，所表示的数等于这些数字相加得到的数，如 Ⅲ=3；
 * 小的数字在大的数字的右边，所表示的数等于这些数字相加得到的数，如 Ⅷ=8、Ⅻ=12；
 * 小的数字（限于 Ⅰ、X 和 C）在大的数字的左边，所表示的数等于大数减小数得到的数，如 Ⅳ=4、Ⅸ=9；
 * 在一个数的上面画一条横线，表示这个数增值 1,000 倍
 *
 * @author pacman
 * @version 1.0
 * date: 2018/4/14 19:30
 */

public class Easy04_RomanToInteger {
    public static void main(String[] args) {
        System.out.println(new Easy04_RomanToInteger().romanToInt("DXCIX"));
    }

    private int romanToInt(String roman) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        String str = new StringBuilder(roman).reverse().toString();
        int sum = 0, prev = -1;
        for (int i = 0; i < str.length(); i++) {
            int curr = map.get(str.charAt(i));
            if (curr < prev) {
                sum -= curr;
            } else {
                sum += curr;
            }
            prev = curr;
        }

        return sum;
    }
}
