package me.xiao.leetcode.linked_list;

/**
 * 删除一个链表中的节点
 *
 * @author pacman
 * @version 1.0
 * date: 2018/4/13 21:01
 */

public class Easy06_DeleteNode {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(3);
        ListNode head4 = new ListNode(4);

        head1.next = head2;
        head2.next = head3;
        head3.next = head4;

//        System.out.println(new Easy06_DeleteNode().deleteNode(head1, 3));
        new Easy06_DeleteNode().deleteNode2(head2);
        System.out.println(head1);

    }

    /*把所有数据向前移动一位*/
    private void deleteNode2(ListNode node) {
        ListNode pre = node;
        ListNode current = node.next;
        ListNode last = node;
        while (current != null) {
            last = pre;

            int temp = pre.val;
            pre.val = current.val;
            current.val = temp;

            pre = current;
            current = current.next;
        }
        last.next = null;
    }

    private ListNode deleteNode(ListNode head, int value) {
        ListNode pre = head;
        ListNode current = head.next;

        while (current != null) {
            if (current.val == value) {
                pre.next = current.next;
            }
            pre = current;
            current = current.next;
        }

        return head;
    }
}
