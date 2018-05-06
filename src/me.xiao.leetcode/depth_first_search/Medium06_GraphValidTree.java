package me.xiao.leetcode.depth_first_search;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

/**
 * 给定一组0,n-1一组数，和一组无向边，看能否构成树
 * <p>
 * 解法：树不是图的条件：没有循环，且必须要有连接不能孤立
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/6 19:29
 */

public class Medium06_GraphValidTree {
    List[] graph;
    private BitSet done;

    public static void main(String[] args) {
//        int[][] graph = {{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}};
        int[][] graph = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
        System.out.println(new Medium06_GraphValidTree().validTree(5, graph));
    }

    private boolean validTree(int n, int[][] edges) {
        graph = new List[n];
        done = new BitSet();
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList();
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            graph[u].add(v);
            graph[v].add(u);
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!done.get(i)) {
                if (!dfs(graph, 0, -1)) {
                    return false;
                }
                count++;
            }
        }
        return count <= 1;
    }

    private boolean dfs(List[] graph, int u, int p) {
        done.set(u);
        List<Integer> child = graph[u];
        if (child != null) {
            for (int c : child) {
                if (p != c) {
                    if (!done.get(c)) {
                        if (!dfs(graph, c, u)) {
                            return false;
                        }
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }

}
