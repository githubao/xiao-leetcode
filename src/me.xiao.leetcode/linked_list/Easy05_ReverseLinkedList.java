package me.xiao.leetcode.linked_list;

/**
 * 反转一个链表
 *
 * @author pacman
 * @version 1.0
 * date: 2018/4/13 21:27
 */

public class Easy05_ReverseLinkedList {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
//        ListNode node4 = new ListNode(4);
//        ListNode node5 = new ListNode(5);
//        ListNode node6 = new ListNode(6);

        node1.next = node2;
        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
//        node5.next = node6;

        ListNode newNode = new Easy05_ReverseLinkedList().reverseList2(node1);
        System.out.println(newNode);
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = head;
        ListNode current = head.next;
        ListNode next;

        head.next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;

            prev = current;
            current = next;
        }

        return prev;
    }

    /* 找到最后一个节点的时候把该节点保存，递归保存了上一个节点的信息，反转两个节点的同时就顺便把newHead的链信息更新了 */
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        } else {
            ListNode newHead = reverseList2(head.next);
            head.next.next = head;
            head.next = null;
            return newHead;
        }
    }
}
