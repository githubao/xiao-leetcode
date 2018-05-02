package me.xiao.leetcode.tree;

/**
 * @author pacman
 * @version 1.0
 * date: 2018/5/2 14:45
 */

public class Easy04_ConstructStringFromBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.right = new TreeNode(3);
        System.out.println(new Easy04_ConstructStringFromBinaryTree().tree2str(root));
    }

    private String tree2str(TreeNode root) {
        if (root == null) return "";
        String left = tree2str(root.left);
        String right = tree2str(root.right);

        if (left.equals("") && right.equals("")) {
            return String.valueOf(root.value);
        }
        if (left.equals("")) {
            left = "()";
        } else {
            left = String.format("(%s)", left);
        }

        if (!right.equals("")) {
            right = String.format("(%s)", right);
        }
        return root.value + left + right;

    }
}
