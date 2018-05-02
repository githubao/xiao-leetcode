package me.xiao.leetcode.tree;

/**
 * 判断一个数是不是另一个的子树
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/2 14:56
 */

public class Easy05_SubtreeOfAnotherTree {

    public static void main(String[] args) {
        TreeNode parent = BinaryTree.defaultBuild();
        System.out.println(new Easy05_SubtreeOfAnotherTree().isSubtree(parent, parent));
    }

    private boolean isSubtree(TreeNode parent, TreeNode child) {
        if (parent != null) {
            if (parent.value == child.value) {
                if (equals(parent, child)) {
                    return true;
                } else {
                    return (isSubtree(parent.left, child) || isSubtree(parent.right, child));
                }
            } else {
                return (isSubtree(parent.left, child) || isSubtree(parent.right, child));
            }
        }
        return false;
    }

    private boolean equals(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        } else if (node1 == null || node2 == null) {
            return false;
        } else if (node1.value != node2.value) {
            return false;
        } else {
            return equals(node1.left, node2.left) && equals(node1.right, node2.right);
        }
    }
}
