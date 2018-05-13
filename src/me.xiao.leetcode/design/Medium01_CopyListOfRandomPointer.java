package me.xiao.leetcode.design;

/**
 * 链表多了一个属性，随机指向另外一个节点或者null
 * 深拷贝整个链表
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/4 18:20
 */

public class Medium01_CopyListOfRandomPointer {

    public static void main(String[] args) {
        RandomListNode root = build();
        RandomListNode result = new Medium01_CopyListOfRandomPointer().copyRandomList(root);
        result.print();
    }

    private static RandomListNode build() {
        RandomListNode one = new RandomListNode(1);
        RandomListNode two = new RandomListNode(2);
        RandomListNode three = new RandomListNode(3);
        RandomListNode four = new RandomListNode(4);
        RandomListNode five = new RandomListNode(5);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;

        one.random = three;
        two.random = five;
        three.random = null;
        four.random = two;
        five.random = four;

        return one;
    }

    private RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        RandomListNode item = head, next;
        while (item != null) {
            next = item.next;
            RandomListNode node = new RandomListNode(item.value);
            item.next = node;
            node.next = next;
            item = next;
        }

        item = head;
        while (item != null) {
            if (item.random != null) {
                item.next.random = item.random.next;
            }
            item = item.next.next;
        }

        item = head;
        RandomListNode copyItem = item.next;
        RandomListNode copyHead = item.next;
        while (copyItem.next != null) {
            item.next = copyItem.next;
            copyItem.next = item.next.next;
            copyItem = copyItem.next;
            item = item.next;
        }
        item.next = null;
        return copyHead;
    }

    static class RandomListNode {
        int value;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.value = x;
        }

        @Override
        public String toString() {
            return "RandomListNode{" +
                    "value=" + value +
                    ", next=" + next.value +
                    ", random=" + random.value +
                    '}';
        }


        public void print() {
            RandomListNode curr = this;
            while (curr != null) {
                int randomValue = curr.random == null ? -1 : curr.random.value;
                System.out.println(String.format("{%s} {%s}", curr.value, randomValue));
                curr = curr.next;
            }
        }
    }
}
