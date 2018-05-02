package me.xiao.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 所有root到leaf的路径
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/2 15:52
 */

public class Easy08_BinaryTreePaths {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(new Easy08_BinaryTreePaths().binaryTreePaths(root));
    }

    private List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> results = new ArrayList<>();
        inorder(root, results, "");
        return results;
    }

    private void inorder(TreeNode node, ArrayList<String> list, String path) {
        if (node != null) {
            if (node.left == null && node.right == null) {
                list.add(path + node.value);
            } else {
                inorder(node.left, list, path + node.value + "->");
                inorder(node.right, list, path + node.value + "->");
            }
        }
    }
}
