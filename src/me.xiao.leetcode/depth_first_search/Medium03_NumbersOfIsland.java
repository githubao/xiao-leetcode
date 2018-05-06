package me.xiao.leetcode.depth_first_search;

/**
 * 1是陆地，0是海洋。统计岛屿的个数
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/6 17:59
 */

public class Medium03_NumbersOfIsland {
    private static int m, n;
    private static int temp[][];
    int[] R = {1, -1, 0, 0};
    int[] C = {0, 0, 1, -1};

    public static void main(String[] args) {
        int[][] grid = {{1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 0, 1, 1}};
        System.out.println(new Medium03_NumbersOfIsland().numberOfIslands(grid));
    }

    private int numberOfIslands(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        if (m == 0 || n == 0) return 0;
        temp = new int[m][n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            System.arraycopy(grid[i], 0, temp[i], 0, n);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (temp[i][j] == 1) {
                    ++count;
                    dfs(i, j);
                }
            }
        }
        return count;
    }

    /**
     * 把 r和c点 周围所有的1都变成0
     *
     * @param r
     * @param c
     */
    private void dfs(int r, int c) {
        temp[r][c] = 0;
        for (int i = 0; i < 4; i++) {
            int rr = r + R[i];
            int cc = c + C[i];
            if (rr >= 0 && cc >= 0 && rr < m && cc < n) {
                if (temp[rr][cc] != 0) {
                    dfs(rr, cc);
                }
            }
        }
    }


}
