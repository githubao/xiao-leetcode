package me.xiao.leetcode.tree;

/**
 * 找到二叉搜索树里面跟target最近的元素
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/2 14:36
 */

public class Easy03_ClosestBinarySearchTreeValue {
    private int closest;
    private double absDiff = Double.MAX_VALUE;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(9);
        root.left.left = new TreeNode(8);
        System.out.println(new Easy03_ClosestBinarySearchTreeValue().closestValue(root, 7.63));
    }

    private int closestValue(TreeNode root, double target) {
        if (root == null) return closest;
        if (Math.abs(target - root.value) < absDiff) {
            absDiff = Math.abs(target - root.value);
            closest = root.value;
        }
        if (root.value > target) {
            return closestValue(root.left, target);
        } else {
            return closestValue(root.right, target);
        }
    }
}
