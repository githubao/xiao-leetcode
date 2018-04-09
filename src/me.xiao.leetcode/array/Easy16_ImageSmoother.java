package me.xiao.leetcode.array;

import java.util.Arrays;

/**
 * 图片平滑，取最近的8个点数据的平均值
 *
 * @author pacman
 * @version 1.0
 * date: 2018/4/9 22:11
 */

public class Easy16_ImageSmoother {
    int[] R = {1, -1, 0, 0, 1, -1, 1, -1};
    int[] C = {0, 0, -1, 1, 1, 1, -1, -1};

    public static void main(String[] args) {
        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        float[][] results = new Easy16_ImageSmoother().imageSmoother(matrix);
        Arrays.stream(results).forEach(it -> System.out.println(Arrays.toString(it)));
    }

    private float[][] imageSmoother(int[][] matrix) {
        float[][] results = new float[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int numCount = 0;
                int totalCount = 1;
                for (int k = 0; k < 8; k++) {
                    int newR = i + R[k];
                    int newC = j + C[k];

                    if (newR >= 0 && newC >= 0 && newR < matrix.length && newC < matrix[0].length) {
                        numCount += matrix[newR][newC];
                        totalCount++;
                    }
                }
                if (matrix[i][j] == 1) {
                    numCount++;
                }
                results[i][j] = (float) numCount / totalCount;
            }
        }
        return results;
    }

}
