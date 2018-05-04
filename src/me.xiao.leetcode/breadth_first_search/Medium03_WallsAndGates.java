package me.xiao.leetcode.breadth_first_search;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * -1 是墙，0是门，填写INF距离0的最近距离
 * <p>
 * 一定算的是最小距离，最小的在队列的前段
 * <p>
 * <p>
 * For example, given the 2D grid:
 * INF  -1  0  INF
 * INF INF INF  -1
 * INF  -1 INF  -1
 * 0  -1 INF INF
 * After running your function, the 2D grid should be:
 * 3  -1   0   1
 * 2   2   1  -1
 * 1  -1   2  -1
 * 0  -1   3   4
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/4 11:10
 */

public class Medium03_WallsAndGates {
    private static final int[] R = {0, 0, 1, -1};
    private static final int[] C = {1, -1, 0, 0};

    public static void main(String[] args) {
        int[][] grid = {{Integer.MAX_VALUE, -1, 0, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, -1},
                {Integer.MAX_VALUE, -1, Integer.MAX_VALUE, -1},
                {0, -1, Integer.MAX_VALUE, Integer.MAX_VALUE}};

        new Medium03_WallsAndGates().wallsAndGates(grid);

        for (int[] item : grid) {
            System.out.println(Arrays.toString(item));
        }
    }

    private void wallsAndGates(int[][] room) {
        Queue<Cell> queue = new ArrayDeque<>();

        for (int i = 0; i < room.length; i++) {
            for (int j = 0; j < room[0].length; j++) {
                if (room[i][j] == 0) {
                    Cell cell = new Cell(i, j);
                    queue.offer(cell);
                }
            }
        }

        while (!queue.isEmpty()) {
            Cell top = queue.poll();
            for (int i = 0; i < 4; i++) {
                int rr = top.r + R[i];
                int cc = top.c + C[i];
                if (rr >= 0 && cc >= 0 && rr < room.length && cc < room[0].length) {
                    if (room[rr][cc] == Integer.MAX_VALUE) {
                        room[rr][cc] = room[top.r][top.c] + 1;
                        queue.offer(new Cell(rr, cc));
                    }
                }
            }
        }
    }

    class Cell {
        int r, c;

        Cell(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

}
