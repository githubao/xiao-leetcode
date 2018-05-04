package me.xiao.leetcode.divide_and_conquer;

/**
 * 行升序，列升序，在矩阵里面找target
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/4 15:06
 */

public class Medium02_SearchA2DMatrix {
    public static void main(String[] args) {
        int[][] matrix =
                {{1, 3, 5, 7, 9}, {2, 4, 6, 8, 10}, {11, 13, 15, 17, 19}, {12, 14, 16, 18, 20}, {21, 22, 23, 24, 25}};

        System.out.println(new Medium02_SearchA2DMatrix().searchMatrix(matrix, 11));
    }

    private boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length;
        int n = matrix[0].length;
        int r = 0, c = n - 1;
        while (r < m && c >= 0) {
            if (matrix[r][c] == target) return true;
            else if (matrix[r][c] < target) r++;
            else if (matrix[r][c] > target) c--;
        }
        return false;
    }
}
