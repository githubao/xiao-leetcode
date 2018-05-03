package me.xiao.leetcode.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 找到名人，别人都认识他，但是他不一定认识别人
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/2 21:21
 */

public class Medium07_FindTheCelebrity {
    private static Map<Integer, Set<Integer>> map = new HashMap<>();

    static {
        map.put(0, new HashSet<>());
        map.put(1, new HashSet<>());
        map.put(2, new HashSet<>());
        map.put(3, new HashSet<>());
        map.put(4, new HashSet<>());
        map.put(5, new HashSet<>());
        map.put(6, new HashSet<>());

        map.get(0).add(1);
        map.get(0).add(2);
        map.get(0).add(3);
        map.get(0).add(4);
        map.get(0).add(5);
        map.get(0).add(6);

        map.get(1).add(0);
        map.get(1).add(3);
        map.get(1).add(2);

        map.get(2).add(1);
        map.get(2).add(3);
        map.get(2).add(4);

        map.get(4).add(2);
        map.get(4).add(3);
        map.get(4).add(5);

        map.get(5).add(4);
        map.get(5).add(3);
        map.get(5).add(6);

        map.get(6).add(5);
        map.get(6).add(3);
        map.get(6).add(0);

    }

    public static void main(String[] args) {
        System.out.println(new Medium07_FindTheCelebrity().findCelebrity2(map.size()));
    }

    private int findCelebrity2(int n) {
        if (n == 0) return -1;
        int can = 0;
        for (int i = 1; i < n; i++) {
            if (!knows(i, can)) can = i;
        }
        for (int i = 0; i < n; i++) {
            if (i != can) {
                if (!knows(i, can) || knows(can, i)) return -1;
            }
        }
        return can;
    }

    private int findCelebrity(int n) {
        int candidate = -1, i = 0, next = 1;
        while (i < n) {
            if (next >= n) break;
            if (knows(i, next) && !knows(next, i)) {
                i = next;
                next = i + 1;
            } else if ((!knows(i, next) && !knows(next, i)) || (knows(i, next) && knows(next, i))) {
                i = next + 1;
                next = i + 1;
            } else {
                next++;
            }
            candidate = i;
        }
        if (candidate == -1 || candidate >= n) {
            return -1;
        }
        for (int j = 0; j < candidate; j++) {
            if (!knows(j, candidate) || knows(candidate, j)) {
                candidate = -1;
                break;
            }
        }
        return candidate;
    }

    private boolean knows(int a, int b) {
        return map.get(a).contains(b);
    }
}
