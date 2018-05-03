package me.xiao.leetcode.array;

/**
 * 船上的战舰总数，只要找左边和上边不是x的就可以了
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/2 21:08
 */

public class Medium06_BattleshipsInABoard {
    public static void main(String[] args) {
        char[][] board = {{'X', '.', '.', 'X'}, {'.', '.', '.', 'X'}, {'.', '.', '.', 'X'}};
        System.out.println(new Medium06_BattleshipsInABoard().countBattleships(board));
    }

    private int countBattleships(char[][] board) {
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'X') {
                    if (i - 1 >= 0) {
                        if (board[i - 1][j] == 'X') continue;
                    }
                    if (j - 1 >= 0) {
                        if (board[i][j - 1] == 'X') continue;
                    }
                    count++;
                }
            }
        }
        return count;
    }
}
