package me.xiao.leetcode.tree;

/**
 * 二叉树的直径，任意两个节点之间的最远路径的长度，也就是边的个数
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/2 15:15
 */

public class Easy07_DiameterOfBinaryTree {

    int max;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(5);
        System.out.println(new Easy07_DiameterOfBinaryTree().diameterOfBinaryTree(root));
    }

    private int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return max;
    }

    private int dfs(TreeNode root) {
        if (null != root) {
            int left = dfs(root.left);
            int right = dfs(root.right);
            max = Math.max(max, left + right);
            return left > right ? left + 1 : right + 1;
        }
        return 0;
    }

}
