package me.xiao.leetcode.stack;

import java.util.Stack;

/**
 * 实现一个栈，支持pop top push getMin
 *
 * @author pacman
 * @version 1.0
 * date: 2018/4/14 20:03
 */

public class Easy01_MinStack {
    private Stack<Node> stack = new Stack<>();

    public static void main(String[] args) {
        Easy01_MinStack minStack = new Easy01_MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }

    private int getMin() {
        return stack.peek().min;
    }

    private int top() {
        return stack.peek().value;
    }

    private void pop() {
        stack.pop();
    }

    private void push(int x) {
        Node node;
        if (!stack.isEmpty()) {
            Node top = stack.peek();
            node = new Node(x, Math.min(top.min, x));
        } else {
            node = new Node(x, x);
        }
        stack.push(node);
    }

    class Node {
        int value;
        int min;

        public Node(int value, int min) {
            this.value = value;
            this.min = min;
        }
    }
}
