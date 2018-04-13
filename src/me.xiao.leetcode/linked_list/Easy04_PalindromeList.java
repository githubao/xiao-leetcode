package me.xiao.leetcode.linked_list;

/**
 * 判断一个链表是不是回文链表
 *
 * @author pacman
 * @version 1.0
 * date: 2018/4/13 21:20
 */

public class Easy04_PalindromeList {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        System.out.println(new Easy04_PalindromeList().isPalindrome(node1));
    }

    private boolean isPalindrome(ListNode head) {
        ListNode head2 = deepCopy(head);
        ListNode tail = new Easy05_ReverseLinkedList().reverseList2(head2);

        ListNode positive = head;
        ListNode negative = tail;

        System.out.println(positive);
        System.out.println(negative);

        while (positive != null) {
            if (positive.val != negative.val) {
                return false;
            }

            positive = positive.next;
            negative = negative.next;
        }

        return true;
    }

    private ListNode deepCopy(ListNode head) {
        ListNode mirrorHead = new ListNode(head.val);
        ListNode mirrorCurrent = mirrorHead;

        ListNode current = head.next;
        while (current != null) {
            ListNode mirrorNext = new ListNode(current.val);

            mirrorCurrent.next = mirrorNext;

            mirrorCurrent = mirrorNext;
            current = current.next;
        }
        return mirrorHead;
    }
}
