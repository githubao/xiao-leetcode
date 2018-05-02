package me.xiao.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * bst 所有左节点的值小于根节点的值，所有右节点的值大于根节点的值
 * <p>
 * 把bst转化为双向链表
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/2 16:25
 */

public class Easy12_BstToDoubleLinkedList {

    public static void main(String[] args) {
        TreeNode root = BinaryTree.defaultBuild();

        DoubleList head = new Easy12_BstToDoubleLinkedList().treeToDoubleList(root);

        head.print();

    }

    private DoubleList treeToDoubleList(TreeNode root) {
        if (root == null) return null;

        List<TreeNode> list = new ArrayList<>();
        preorder(root, list);

        DoubleList head = null;
        DoubleList prev = null;
        DoubleList current = null;

        for (TreeNode node : list) {
            DoubleList temp = new DoubleList();
            temp.value = node.value;

            if (null == head) {
                head = temp;
                head.prev = null;

                current = head;
            } else {
                current.next = temp;
                temp.prev = current;

                current = current.next;
            }

        }

        return head;

    }

    private void preorder(TreeNode root, List<TreeNode> results) {
        if (null != root) {
            results.add(root);
            preorder(root.left, results);
            preorder(root.right, results);
        }
    }

    class DoubleList {
        int value;
        DoubleList prev;
        DoubleList next;

        public DoubleList() {
        }

        public DoubleList(int value) {
            this.value = value;
            this.prev = this.next = null;
        }

        @Override
        public String toString() {
            return "DoubleList{" +
                    "value=" + value +
                    ", prev=" + prev +
                    ", next=" + next +
                    '}';
        }

        void print() {
            DoubleList current = this;
            while (current != null) {
                int prev = 0;
                if (null != current.prev) {
                    prev = current.prev.value;
                }
                int next = 0;
                if (null != current.next) {
                    next = current.next.value;
                }

                System.out.println(String.format("%s %s %s", prev, current.value, next));

                current = current.next;
            }
        }

    }
}
