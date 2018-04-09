package me.xiao.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 相对分值的名次，金银铜牌
 *
 * @author pacman
 * @version 1.0
 * date: 2018/4/9 21:47
 */

public class Easy13_RelativeRanks {
    class Position {
        int score;
        int position;

        public Position(int score, int position) {
            this.score = score;
            this.position = position;
        }
    }

    public static void main(String[] args) {
//        int[] scores = {5, 4, 3, 2, 1};
        int[] scores = {8, 10, 2, 6, 4};
        String[] results = new Easy13_RelativeRanks().findRelativeRanks(scores);
        System.out.println(Arrays.toString(results));
    }

    private String[] findRelativeRanks(int[] scores) {
        String[] strings = new String[scores.length];
        ArrayList<Position> list = new ArrayList<>();
        for (int i = 0; i < scores.length; i++) {
            list.add(new Position(scores[i], i));
        }
        list.sort((o1, o2) -> Integer.compare(o2.score, o1.score));

        for (int i = 0; i < list.size(); i++) {
            if (i == 0) {
                strings[list.get(i).position] = "Gold Medal";
            } else if (i == 1) {
                strings[list.get(i).position] = "Sliver Medal";
            } else if (i == 2) {
                strings[list.get(i).position] = "Bronze Medal";
            } else {
                strings[list.get(i).position] = String.valueOf(i + 1);
            }
        }

        return strings;
    }

}
