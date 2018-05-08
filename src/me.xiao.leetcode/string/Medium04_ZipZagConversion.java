package me.xiao.leetcode.string;

import java.util.Arrays;

/**
 * zigzag 竖着下来，然后斜着上去
 *
 * 要求按照行输出
 *
 * PAYPALISHIRING n=3 输出 PAHNAPLSIIGYIR
 *
 * P A H N
 * APLSIIG
 * Y I R
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/8 17:15
 */

public class Medium04_ZipZagConversion {
    public static void main(String[] args) {
        System.out.println(new Medium04_ZipZagConversion().convert("PAYPALISHIRING",3));
    }

    private String convert(String s, int n) {
        int len = s.length();

        if (len == 0 || n <= 1) return s;

        String[] ans = new String[n];
        Arrays.fill(ans,"");

        int row = 0, delta = 1;
        for (int i = 0; i < len; i++) {
            ans[row] += s.charAt(i);
            row += delta;
            if (row >= n){
                row = n - 2;
                delta = -1;
            }

            if (row < 0){
                row = 1;
                delta = 1;
            }
        }
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < n; i++) {
            ret.append(ans[i]);
        }
        return ret.toString();
    }
}
