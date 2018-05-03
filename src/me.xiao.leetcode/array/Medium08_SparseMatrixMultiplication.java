package me.xiao.leetcode.array;

import java.util.Arrays;

/**
 * 稀疏矩阵的乘积
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/2 21:49
 */

public class Medium08_SparseMatrixMultiplication {
    public static void main(String[] args) {
        int[][] A = {{1, 0, 0, 1}, {2, 0, 0, 2}};
        int[][] B = {{7, 0, 0}, {0, 0, 0}, {0, 0, 1}, {0, 0, 1}};
        int[][] C = new Medium08_SparseMatrixMultiplication().multiply(A, B);
        for (int[] ic : C) {
            System.out.println(Arrays.toString(ic));
        }
    }

    private int[][] multiply(int[][] a, int[][] b) {
        boolean[] aBools = new boolean[a.length];
        boolean[] bBools = new boolean[b[0].length];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (a[i][j] != 0) {
                    aBools[i] = true;
                    break;
                }
            }
        }

        for (int i = 0; i < b[0].length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (b[j][i] != 0) {
                    bBools[i] = true;
                    break;
                }
            }
        }

        int[][] c = new int[a.length][b[0].length];
        for (int i = 0; i < c.length; i++) {
            if (aBools[i]) {
                for (int j = 0; j < c[0].length; j++) {
                    if (bBools[j]) {
                        int sum = 0;
                        for (int k = 0; k < a[0].length; k++) {
                            sum += a[i][k] * b[k][j];
                        }
                        c[i][j] = sum;
                    }
                }
            }
        }

        return c;
    }
}
