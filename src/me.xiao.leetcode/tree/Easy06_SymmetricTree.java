package me.xiao.leetcode.tree;

/**
 * 判断是不是镜像对称的二叉树
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/2 15:03
 */

public class Easy06_SymmetricTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        System.out.println(new Easy06_SymmetricTree().isSymmetric(root));
    }

    private boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return dfs(root.left, root.right);
    }

    private boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        else if (left == null || right == null) return false;
        return dfs(left.left, right.right) && left.value == right.value && dfs(left.right, right.left);
    }
}
