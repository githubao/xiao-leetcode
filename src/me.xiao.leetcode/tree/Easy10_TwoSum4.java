package me.xiao.leetcode.tree;

import java.util.HashSet;

/**
 * BST的两个数，加和能不能是target
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/2 16:03
 */

public class Easy10_TwoSum4 {
    public static void main(String[] args) {

    }

    private boolean findTarget(TreeNode root, int target) {
        return inorder(root, new HashSet<>(), target);
    }

    private boolean inorder(TreeNode node, HashSet<Object> set, int target) {
        if (null != node) {
            int req = target - node.value;
            if (set.contains(req)) {
                return true;
            }
            set.add(node.value);

            if (inorder(node.left, set, target)) {
                return true;
            } else return inorder(node.right, set, target);
        }
        return false;
    }

}
