package me.xiao.leetcode.depth_first_search;

import java.util.Arrays;

/**
 * 扫雷游戏
 * <p>
 * 点一个地方之后，更新二维数组的所有可知地点的状态
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/6 17:20
 */

public class Medium01_MineSweeper {
    private static final int[] R = {1, 1, 1, 0, 0, -1, -1, -1};
    private static final int[] C = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) {
        char[][] board = {{'E', 'E', 'E', 'E', 'E'}, {'E', 'E', 'M', 'E', 'E'}, {'E', 'E', 'E', 'E', 'E'}, {'E', 'E', 'E', 'E', 'E'}};
        int[] click = {3, 0};
        new Medium01_MineSweeper().updateBoard(board, click);
        for (char[] aBoard : board) {
            System.out.println(Arrays.toString(aBoard));
        }
    }

    private void updateBoard(char[][] board, int[] click) {
        dfs(board, click[0], click[1]);
    }

    private void dfs(char[][] board, int r, int c) {
        if (board[r][c] == 'M') {
            board[r][c] = 'X';
        } else {
            int mineCount = 0;
            for (int i = 0; i < 8; i++) {
                int rr = r + R[i];
                int cc = c + C[i];
                if (rr >= 0 && cc >= 0 && rr < board.length && cc < board[0].length && board[rr][cc] == 'M') {
                    mineCount++;
                }
            }
            if (mineCount > 0) {
                board[r][c] = (char) (mineCount + '0');
            } else {
                board[r][c] = 'B';
                for (int i = 0; i < 8; i++) {
                    int rr = r + R[i];
                    int cc = c + C[i];
                    if (rr >= 0 && cc >= 0 && rr < board.length && cc < board[0].length && board[rr][cc] == 'E') {
                        dfs(board, rr, cc);
                    }
                }
            }

        }
    }
}
