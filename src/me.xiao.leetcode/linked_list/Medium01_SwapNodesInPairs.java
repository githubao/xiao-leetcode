package me.xiao.leetcode.linked_list;

/**
 * 链表的节点，两两交换
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/4 17:06
 */

public class Medium01_SwapNodesInPairs {
    public static void main(String[] args) {

        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next = new ListNode(6);

        ListNode head = new Medium01_SwapNodesInPairs().swapPairs(node);
        System.out.println(head);
    }

    private ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode reverse = head.next;
        ListNode curr = head.next;
        ListNode prev = head;

//        负责把链表连接起来
        ListNode prevPrev = new ListNode(-1);

        while (curr != null) {
            prev.next = curr.next;
            curr.next = prev;

            prevPrev.next = curr;
            if (prev.next != null) {
                curr = prev.next.next;
                prev = prev.next;
                prevPrev = prevPrev.next.next;
            } else {
                curr = null;
            }

        }

        return reverse;

    }
}
