package me.xiao.leetcode.linked_list;

/**
 * 两个链表的交集，从哪个节点开始一样
 *
 * @author pacman
 * @version 1.0
 * date: 2018/4/13 20:36
 */

public class Easy01_IntersectionOfTwoLinkedLists {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        node1.next = node2;
        System.out.println(new Easy01_IntersectionOfTwoLinkedLists().getIntersectionNode(node1, node2));
    }

    private ListNode getIntersectionNode(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return null;
        }

//        求长度
        int l1len = 0, l2len = 0;
        ListNode temp1 = head1;
        while (temp1 != null) {
            temp1 = temp1.next;
            l1len++;
        }

        ListNode temp2 = head2;
        while (temp2 != null) {
            temp2 = temp2.next;
            l2len++;
        }

//        变成统一的长度
        int diff = Math.abs(l1len - l2len);
        if (l1len > l2len) {
            temp1 = head1;
            temp2 = head2;
        } else {
            temp1 = head2;
            temp2 = head1;
        }

        while (diff != 0) {
            temp1 = temp1.next;
            diff--;
        }

//        找相等
        while (!temp1.equals(temp2)) {
            temp1 = temp1.next;
            temp2 = temp2.next;
            if (temp1 == null || temp2 == null) {
                return null;
            }
        }

        if (temp1.equals(temp2)) {
            return temp1;
        }
        return null;
    }
}
