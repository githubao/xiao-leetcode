package me.xiao.leetcode.tree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/2 14:07
 */

public class BinaryTree {

    private TreeNode root;

    public BinaryTree(int[] arr) {
        root = build(arr, 1);
    }

    public static TreeNode defaultBuild() {
        int[] arr = {0, 13, 65, 5, 97, 25, 0, 37, 22, 0, 4, 28, 0, 0, 32, 0};
        BinaryTree tree = new BinaryTree(arr);
        return tree.root;
    }

    public static void main(String[] args) {
        int[] arr = {0, 13, 65, 5, 97, 25, 0, 37, 22, 0, 4, 28, 0, 0, 32, 0};
        BinaryTree tree = new BinaryTree(arr);

//        tree.bsf();
//        tree.dsf();

        tree.pre(tree.root);
        System.out.println("\n");

//        tree.in(tree.root);
//        System.out.println("\n");
//
//        tree.post(tree.root);
//        System.out.println("\n");

    }

    /**
     * 构造二叉树
     *
     * @param arr
     * @param index
     * @return
     */
    private TreeNode build(int[] arr, int index) {
        if (index < arr.length) {
            int value = arr[index];
            if (value != 0) {
                TreeNode node = new TreeNode(value);
                arr[index] = 0;
                node.left = build(arr, index * 2);
                node.right = build(arr, index * 2 + 1);
                return node;
            }
        }
        return null;
    }

    /**
     * 深度优先遍历
     */
    private void dsf() {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode pNode = stack.pop();

            System.out.print(pNode.value + " ");

            if (pNode.right != null) {
                stack.push(pNode.right);
            }

            if (pNode.left != null) {
                stack.push(pNode.left);
            }
        }

        System.out.println("\n");
    }

    /**
     * 广度优先遍历
     */
    private void bsf() {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode pNode = queue.remove();

            System.out.print(pNode.value + " ");

            if (pNode.left != null) {
                queue.add(pNode.left);
            }

            if (pNode.right != null) {
                queue.add(pNode.right);
            }
        }

        System.out.println("\n");
    }

    private void pre(TreeNode node) {
        if (node != null) {
            System.out.print(node.value + " ");
            pre(node.left);
            pre(node.right);
        }
    }

    /**
     * 中序遍历
     *
     * @param node
     */
    private void in(TreeNode node) {
        if (node != null) {
            in(node.left);
            System.out.print(node.value + " ");
            in(node.right);
        }
    }

    /**
     * 后序遍历
     *
     * @param node
     */
    private void post(TreeNode node) {
        if (node != null) {
            post(node.left);
            post(node.right);
            System.out.print(node.value + " ");
        }
    }


}
