package me.xiao.leetcode.tree;

/**
 * 判断两棵树是否相同
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/2 16:22
 */

public class Easy13_SameTree {

    public static void main(String[] args) {
        TreeNode root = BinaryTree.defaultBuild();
        System.out.println(new Easy13_SameTree().isSameTree(root, root));
    }

    private boolean isSameTree(TreeNode p, TreeNode q) {
        if (null == p && null == q) return true;
        else if (null == p || null == q) return false;
        return p.value == q.value && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
