package me.xiao.leetcode.breadth_first_search;

import java.util.*;

/**
 * 0000 -> target
 * <p>
 * 不能经历数组里面的dead ends的状态
 * <p>
 * ["0201","0101","0102","1212","2002"]
 * <p>
 * 所有可行的状态，挨个+1，只要找到符合条件的
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/4 13:19
 */

public class Medium04_OpenTheLock {
    private Set<String> done;

    public static void main(String[] args) {
        String[] deads = {"0201", "0101", "0102", "1212", "2002"};
        System.out.println(new Medium04_OpenTheLock().openLock(deads, "0202"));
    }

    private int openLock(String[] deads, String target) {
        done = new HashSet<>();
        done.addAll(Arrays.asList(deads));

        if (done.contains("0000")) return -1;
        if (target.equals("0000")) return 0;

        Queue<State> queue = new ArrayDeque<>();
        queue.offer(new State("0000", 0));
        done.add("0000");

        while (!queue.isEmpty()) {
            State state = queue.poll();

            if (state.state.equals(target)) return state.dist;
            String curr = state.state;

            for (int i = 0; i < 4; i++) {
                int c = Integer.parseInt(String.valueOf(curr.charAt(i)));

                String prefix = curr.substring(0, i);
                String postfix = curr.substring(i + 1, 4);

                String next1 = prefix + (((c + 1) > 9) ? 0 : (c + 1)) + postfix;
                if (!done.contains(next1)) {
                    queue.offer(new State(next1, state.dist + 1));
                    done.add(next1);
                }

                String next2 = prefix + (((c - 1) < 0) ? 0 : (c - 1)) + postfix;
                if (!done.contains(next2)) {
                    queue.offer(new State(next2, state.dist + 1));
                    done.add(next2);
                }
            }
        }
        return -1;
    }

    class State {
        String state;
        int dist;

        public State(String state, int dist) {
            this.state = state;
            this.dist = dist;
        }
    }

}
