package me.xiao.leetcode.linked_list;

/**
 * 合并两个排好序的列表
 *
 * @author pacman
 * @version 1.0
 * date: 2018/4/13 20:53
 */

public class Easy03_MergeTwoSortedList {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(0);
        ListNode head2 = new ListNode(3);
        ListNode head3 = new ListNode(8);

        ListNode head4 = new ListNode(1);
        ListNode head5 = new ListNode(2);
        ListNode head6 = new ListNode(7);
        ListNode head7 = new ListNode(10);

        head1.next = head2;
        head2.next = head3;

        head4.next = head5;
        head5.next = head6;
        head6.next = head7;

        System.out.println(new Easy03_MergeTwoSortedList().mergeTwoLists(head1, head4));
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
