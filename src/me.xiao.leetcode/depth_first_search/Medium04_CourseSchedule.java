package me.xiao.leetcode.depth_first_search;

import java.util.*;

/**
 * 课程学习计划, n门课，有先后上的依赖关系，[0,1]表示想上0，必须先上1
 * <p>
 * 其实就是看有没有循环依赖。dfs顺序遍历的时候，出现过的不要再出现就好了
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/6 19:06
 */

public class Medium04_CourseSchedule {
    private Map<Integer, List<Integer>> graph;
    private BitSet visited;
    private Queue<Integer> topoSorted;

    public static void main(String[] args) {
        int[][] pre = {{1, 0}, {0, 1}};
        System.out.println(new Medium04_CourseSchedule().canFinish(2, pre));
    }

    private boolean canFinish(int num, int[][] prerequisites) {
        graph = new HashMap<>();
        visited = new BitSet();
        topoSorted = new ArrayDeque<>();

        for (int[] child : prerequisites) {
            graph.putIfAbsent(child[0], new ArrayList<>());
            graph.get(child[0]).add(child[1]);
        }

        graph.keySet().stream().filter(v -> !visited.get(v)).forEach(this::dfs);

        visited.clear();

        while (!topoSorted.isEmpty()) {
            int v = topoSorted.poll();
            if (visited.get(v)) {
                return false;
            }
            relax(v);
        }
        return true;

    }

    private void relax(int v) {
        visited.set(v);
        List<Integer> child = graph.get(v);
        if (child != null) {
            for (int c : child) {
                visited.set(c);
            }
        }

    }

    private void dfs(int v) {
        visited.set(v);
        List<Integer> child = graph.get(v);
        if (child != null) {
            for (int c : child) {
                if (!visited.get(c)) {
                    dfs(c);
                }
            }
        }
        topoSorted.offer(v);
    }

}
