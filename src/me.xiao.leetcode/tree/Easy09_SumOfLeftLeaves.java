package me.xiao.leetcode.tree;

/**
 * 所有左子树的和
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/2 15:59
 */

public class Easy09_SumOfLeftLeaves {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        System.out.println(new Easy09_SumOfLeftLeaves().sumOfLeftLeaves(root));
    }

    private int sumOfLeftLeaves(TreeNode root) {
        return inorder(root, false);
    }

    private int inorder(TreeNode node, boolean isLeft) {
        if (null != node) {
            if (node.left == null && node.right == null) {
                if (isLeft) {
                    return node.value;
                } else {
                    return 0;
                }
            }
            return inorder(node.left, true) + inorder(node.right, false);
        }
        return 0;
    }
}
