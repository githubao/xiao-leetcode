package me.xiao.leetcode.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * 树的每一层的平均值
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/2 16:11
 */

public class Easy11_AverageOfLevelInBinaryTree {
    public static void main(String[] args) {
        TreeNode root = BinaryTree.defaultBuild();
        System.out.println(new Easy11_AverageOfLevelInBinaryTree().averageOfLevels(root));
    }

    private List<Double> averageOfLevels(TreeNode root) {
        ArrayDeque<LevelNode> queue = new ArrayDeque<>();
        LevelNode node = new LevelNode(0, root);
        queue.offer(node);

        int curLevel = 0, count = 0;
        long sum = 0L;

        List<Double> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            LevelNode first = queue.poll();
            if (first.level == curLevel) {
                sum += first.node.value;
                count++;
            } else {
                result.add((double) sum / count);
                sum = first.node.value;
                count = 1;
                curLevel++;
            }

            if (first.node.left != null) {
                queue.offer(new LevelNode(curLevel + 1, first.node.left));
            }
            if (first.node.right != null) {
                queue.offer(new LevelNode(curLevel + 1, first.node.right));
            }
        }

        result.add((double) sum / count);
        return result;
    }

}
