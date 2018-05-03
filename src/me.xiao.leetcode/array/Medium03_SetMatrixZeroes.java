package me.xiao.leetcode.array;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 使用常数的空间，把矩阵i,j点为0的行和列都变成0
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/2 17:55
 */

public class Medium03_SetMatrixZeroes {

    public static void main(String[] args) {
        int[][] matrix = {{0, 8, 7}, {9, 0, 8}, {9, 9, 0}};
        new Medium03_SetMatrixZeroes().setZeroes(matrix);
        for (int[] item : matrix) {
            System.out.println(Arrays.toString(item));
        }
    }

    private void setZeroes(int[][] matrix) {
        HashSet<Integer> row = new HashSet<>();
        HashSet<Integer> col = new HashSet<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row.add(i);
                    col.add(j);
                }
            }
        }

        for (int r : row) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[r][j] = 0;
            }
        }

        for (int c : col) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][c] = 0;
            }
        }

    }
}
