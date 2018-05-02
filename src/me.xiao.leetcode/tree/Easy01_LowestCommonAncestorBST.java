package me.xiao.leetcode.tree;

/**
 * 找到二叉搜索树里面的“最小公共祖先”
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/1 23:18
 */

public class Easy01_LowestCommonAncestorBST {
    public static void main(String[] args) {
        TreeNode root = null;
        TreeNode p = null;
        TreeNode q = null;

        System.out.println(new Easy01_LowestCommonAncestorBST().lowestCommonAncestor(root, p, q));

    }

    private TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (p.value == root.value || q.value == root.value) {
            return root;
        } else if ((p.value < root.value && q.value > root.value) || (q.value < root.value && p.value > root.value)) {
            return root;
        } else if (p.value < root.value && q.value < root.value) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return lowestCommonAncestor(root.right, p, q);
        }
    }
}
