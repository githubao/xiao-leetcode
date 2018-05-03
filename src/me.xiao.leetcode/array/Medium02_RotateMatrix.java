package me.xiao.leetcode.array;

import java.util.Arrays;

/**
 * 翻转矩阵
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/2 18:12
 */

public class Medium02_RotateMatrix {

    public static void main(String[] args) {
        int[][] A = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//        new Medium02_RotateMatrix().rotate(A);
        new Medium02_RotateMatrix().rotate2(A);
        for (int[] aA : A) {
            System.out.println(Arrays.toString(aA));
        }
    }

    private void rotate2(int[][] matrix) {
        int n = matrix.length;

        for (int layer = 0; layer < n / 2; layer++) {
            for (int x = layer; x < n - layer - 1; x++) {
                int value = matrix[layer][x];
                matrix[layer][x] = matrix[n - x - 1][layer];
                matrix[n - x - 1][layer] = matrix[n - layer - 1][n - x - 1];
                matrix[n - layer - 1][n - x - 1] = matrix[x][n - layer - 1];
                matrix[x][n - layer - 1] = value;
            }
        }
    }

    /**
     * start-row start-col
     * end-row end-col
     *
     * @param matrix
     */
    private void rotate(int[][] matrix) {
        int start_row = 0, start_col = 0;
        int end_row = matrix.length - 1, end_col = matrix[0].length - 1;

        while (start_row < end_row) {
            for (int i = start_col, j = start_row, k = end_col, l = end_row; i < end_col && j < end_row && k > start_col && l > start_row; i++, j++, k--, l--) {

                int temp1 = matrix[j][end_col];
                matrix[j][end_col] = matrix[start_row][i];

                int temp2 = matrix[end_row][k];
                matrix[end_row][k] = temp1;

                temp1 = matrix[l][start_col];
                matrix[l][start_col] = temp2;
                matrix[start_row][i] = temp1;
            }

            start_row++;
            start_col++;
            end_row--;
            end_col--;
        }

    }
}
