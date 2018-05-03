package me.xiao.leetcode.backtracking;

/**
 * 给定一个二维数组，看有没有路线可以沿着找到一个单词
 * <p>
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/3 16:28
 */

public class Medium10_WordSearch {
    private static final int[] R = {0, 0, 1, -1};
    private static final int[] C = {1, -1, 0, 0};
    private static boolean[][] visited;
    private static int length = 0, m, n;

    public static void main(String[] args) {
        char[][] grid = {{'a', 'b', 'c', 'e'}, {'s', 'f', 'c', 's'}, {'a', 'd', 'e', 'e'}};
//        System.out.println(new Medium10_WordSearch().exist(grid, "saedghje"));
        System.out.println(new Medium10_WordSearch().exist(grid, "seedfsa"));
    }

    private boolean exist(char[][] grid, String word) {
        m = grid.length;
        n = grid[0].length;
        if (m * n < word.length()) return false;
        visited = new boolean[m][n];
        length = word.length();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == word.charAt(0)) {
                    if (dfs(i, j, grid, word, 1)) return true;
                    visited[i][j] = false;
                }
            }
        }
        return false;
    }

    private boolean dfs(int r, int c, char[][] grid, String word, int pos) {
        if (pos < length) {
            visited[r][c] = true;
            for (int i = 0; i < 4; i++) {
                int rr = r + R[i];
                int cc = c + C[i];
                if (rr >= 0 && rr < m && cc >= 0 && cc < n) {
                    if (!visited[rr][cc]) {
                        if (grid[rr][cc] == word.charAt(pos)) {
                            if (dfs(rr, cc, grid, word, pos + 1)) return true;
                            visited[rr][cc] = false;
                        }
                    }
                }
            }

        } else {
            return true;
        }
        return false;
    }
}
