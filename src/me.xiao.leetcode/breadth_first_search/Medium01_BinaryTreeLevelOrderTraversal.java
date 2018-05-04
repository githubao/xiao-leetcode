package me.xiao.leetcode.breadth_first_search;

import me.xiao.leetcode.tree.BinaryTree;
import me.xiao.leetcode.tree.LevelNode;
import me.xiao.leetcode.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 层级遍历 二叉树
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/4 10:20
 */

public class Medium01_BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = BinaryTree.defaultBuild();
        System.out.println(new Medium01_BinaryTreeLevelOrderTraversal().levelOrder(root));
    }

    /**
     * @param root root node
     * @return [[13], [65, 5], [97, 25, 37], [22, 4, 28, 32]]
     */
    private List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        if (root == null) return results;
        Queue<LevelNode> queue = new ArrayDeque<>();
        queue.offer(new LevelNode(0, root));

        int currentLevel = 0;
        List<Integer> row = new ArrayList<>();
        while (!queue.isEmpty()) {
            LevelNode levelNode = queue.poll();
            if (levelNode.node != null) {

                if (levelNode.level != currentLevel) {
                    results.add(row);
                    row = new ArrayList<>();
                    currentLevel++;
                }

                row.add(levelNode.node.value);
                TreeNode left = levelNode.node.left;
                TreeNode right = levelNode.node.right;

                LevelNode leftLevelNode = new LevelNode(levelNode.level + 1, left);
                LevelNode rightLevelNode = new LevelNode(levelNode.level + 1, right);

                queue.offer(leftLevelNode);
                queue.offer(rightLevelNode);
            }
        }
        results.add(row);

        return results;
    }
}
