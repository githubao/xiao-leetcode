package me.xiao.leetcode.linked_list;

/**
 * 判断是不是循环列表
 *
 * @author pacman
 * @version 1.0
 * date: 2018/4/13 20:46
 */

public class Easy02_LinkedListCycle {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node1;
        System.out.println(new Easy02_LinkedListCycle().hasCycle(node1));
    }

    private boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (slow != null && fast != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            } else {
                break;
            }

            if (fast != null && slow != null) {
                if (fast.equals(slow)) {
                    return true;
                }
            }

        }
        return false;
    }
}
