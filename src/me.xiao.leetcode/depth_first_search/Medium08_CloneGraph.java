package me.xiao.leetcode.depth_first_search;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 拷贝一个图
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/6 19:45
 */

public class Medium08_CloneGraph {
    private Map<Integer, UndirectedGraphNode> map;

    public static void main(String[] args) {
        UndirectedGraphNode node1 = new UndirectedGraphNode(0);
        UndirectedGraphNode node2 = new UndirectedGraphNode(1);
        UndirectedGraphNode node3 = new UndirectedGraphNode(2);
        node1.neighbors.add(node2);
        node1.neighbors.add(node3);

        node2.neighbors.add(node1);
        node2.neighbors.add(node3);

        node3.neighbors.add(node1);
        node3.neighbors.add(node2);

        node3.neighbors.add(node3);
        UndirectedGraphNode result = new Medium08_CloneGraph().cloneGraph(node1);

        result.print();
    }

    private UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        map = new HashMap<>();
        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);

        dfs(node, clone);
        return clone;

    }

    private void dfs(UndirectedGraphNode node, UndirectedGraphNode clone) {
        map.put(node.label, clone);

        List<UndirectedGraphNode> neighbors = clone.neighbors;

        for (UndirectedGraphNode child : node.neighbors) {
            if (map.containsKey(child.label)) {
                neighbors.add(map.get(child.label));
            } else {
                UndirectedGraphNode newNode = new UndirectedGraphNode(child.label);
                neighbors.add(newNode);

                dfs(child, newNode);
            }
        }

    }

    static class UndirectedGraphNode {
        private static BitSet visited = new BitSet();

        int label;
        List<UndirectedGraphNode> neighbors;

        public UndirectedGraphNode(int label) {
            this.label = label;
            neighbors = new ArrayList<>();
        }

        /**
         * 0: [1, 2]
         * 1: [0, 2]
         * 2: [0, 1, 2]
         */
        public void print() {
            visited.set(this.label);

            List<Integer> collect = neighbors.stream().map(it -> it.label).collect(Collectors.toList());
            System.out.println(this.label + ": " + collect);

            for (UndirectedGraphNode node : this.neighbors) {
                if (!visited.get(node.label)) {
                    node.print();
                }

            }
        }
    }

}
