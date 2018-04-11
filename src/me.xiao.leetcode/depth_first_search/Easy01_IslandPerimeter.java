package me.xiao.leetcode.depth_first_search;

/**
 * 二维数据表格，1代表陆地，0代表海洋
 * <p>
 * 计算所有的岛屿的海岸线长度。
 * <p>
 * 其实就是把所有的1能到之处连起来
 * <p>
 * [
 * [0,1,0,0],
 * [1,1,1,0],
 * [0,1,0,0],
 * [1,1,0,0]
 * ]
 * <p>
 * 011110
 * 010110
 * 111000
 * 000010
 * 000000
 * <p>
 * <p>
 * 到了海域的边缘或者旁边就是海，那么把1的这条边的数字加上。如果四面是海，就四面都加
 * <p>
 * 如果需要去除内陆湖，那么就再遍历一遍，
 *
 * @author pacman
 * @version 1.0
 * date: 2018/4/11 12:55
 */

public class Easy01_IslandPerimeter {
    int[] ROW = {1, -1, 0, 0};
    int[] COL = {0, 0, 1, -1};

    boolean[][] done;
    int perimeter;

    public static void main(String[] args) {
//        int[][] grid = {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        int[][] grid = {{0, 1, 1, 1, 1, 0}, {0, 1, 0, 1, 1, 0}, {1, 1, 1, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {0, 0, 0, 0, 0, 0}};
//        System.out.println(new Easy01_IslandPerimeter().islandPerimeter(grid));
        System.out.println(new Easy01_IslandPerimeter().lakePerimeter(grid));
    }

    /* 计算包含内陆湖的海岸线的长度 */
    private int islandPerimeter(int[][] grid) {
        done = new boolean[grid.length][grid[0].length];
        perimeter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !done[i][j]) {
                    dfs(i, j, grid);
//                    break;
                }

            }
        }
        return perimeter;
    }

    private void dfs(int r, int c, int[][] grid) {
        done[r][c] = true;
        for (int i = 0; i < 4; i++) {
            int newRow = r + ROW[i];
            int newCol = c + COL[i];
            if (newRow < 0 || newCol < 0 || newRow >= grid.length || newCol >= grid[0].length) {
                perimeter++;
            } else if (grid[newRow][newCol] == 0) {
                perimeter++;
            } else if (!done[newRow][newCol]) {
                dfs(newRow, newCol, grid);
            }
        }
    }

    /* 内陆湖的长度 */
    private int lakePerimeter(int[][] grid) {
        done = new boolean[grid.length][grid[0].length];
        perimeter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0 && !done[i][j]) {
                    int result = dfs2(i, j, grid);
                    System.out.println(String.format("%s-%s result is: %s", i, j, result));
                    perimeter += result;

                    success = true;
                    count = 0;
//                    break;
                }

            }
        }
        return perimeter;
    }

    int count = 0;
    boolean success = true;

    private int dfs2(int r, int c, int[][] grid) {
        done[r][c] = true;
        for (int i = 0; i < 4; i++) {
            int newRow = r + ROW[i];
            int newCol = c + COL[i];
            if (newRow < 0 || newCol < 0 || newRow >= grid.length || newCol >= grid[0].length) {
                //表示失败
                success = false;
            } else if (grid[newRow][newCol] == 1) {
                count += 1;
            } else if (!done[newRow][newCol]) {
                dfs2(newRow, newCol, grid);
            }
        }
        return success ? count : 0;
    }
}
