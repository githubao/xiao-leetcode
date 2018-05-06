package me.xiao.leetcode.depth_first_search;

import java.util.*;

/**
 * 如果可以遍历完成的话，输出一条路径
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/6 19:17
 */

public class Medium05_CourseSchedule2 {
    private Map<Integer, List<Integer>> graph;
    private BitSet visited;
    private Queue<Integer> topoSorted;

    public static void main(String[] args) {
        int[][] pre = {{1, 0}, {2, 0}, {3, 1}, {1, 2}};
        int[] orders = new Medium05_CourseSchedule2().findOrder(4, pre);
        System.out.println(Arrays.toString(orders));
    }

    private int[] findOrder(int num, int[][] prerequisites) {
        int[] courses = new int[num];
        int[] results = new int[num];
        for (int i = 0; i < num; i++) {
            courses[i] = i;
        }

        graph = new HashMap<>();
        visited = new BitSet();
        topoSorted = new ArrayDeque<>();

        for (int[] child : prerequisites) {
            graph.putIfAbsent(child[0], new ArrayList<>());
            graph.get(child[0]).add(child[1]);
        }

        graph.keySet().stream().filter(v -> !visited.get(v)).forEach(this::dfs);

        visited.clear();

        int i = 0;
        while (!topoSorted.isEmpty()) {
            int v = topoSorted.poll();
            if (visited.get(v)) {
                return new int[0];
            }
            relax(v);
            results[i++] = v;
            courses[v] = -1;
        }

        //添加剩下的课程
        for (int c : courses) {
            if (c != -1) {
                results[i++] = c;
            }
        }
        return results;

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
