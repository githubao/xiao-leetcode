package me.xiao.leetcode.stack;

import java.util.Stack;

/**
 * 用堆栈实现一个队列，push pop peek empty
 *
 * @author pacman
 * @version 1.0
 * date: 2018/4/14 20:34
 */

public class Easy03_MyQueue {
    private Stack<Integer> stack;

    public Easy03_MyQueue() {
        this.stack = new Stack<>();
    }

    public static void main(String[] args) {
        Easy03_MyQueue myQueue = new Easy03_MyQueue();
        myQueue.push(5);
        myQueue.push(12);
        myQueue.push(7);
        myQueue.push(9);
        System.out.println(myQueue.peek());
        System.out.println(myQueue.pop());
        myQueue.push(56);
        myQueue.push(53);
        System.out.println(myQueue.pop());
    }

    private int peek() {
        // aux 辅助的
        Stack<Integer> auxStack = new Stack<>();
        while (!stack.isEmpty()) {
            auxStack.push(stack.pop());
        }
        int result = auxStack.peek();
        while (!auxStack.isEmpty()) {
            stack.push(auxStack.pop());
        }
        return result;
    }

    private int pop() {
        // aux 辅助的
        Stack<Integer> auxStack = new Stack<>();
        while (!stack.isEmpty()) {
            auxStack.push(stack.pop());
        }
        int result = auxStack.pop();
        while (!auxStack.isEmpty()) {
            stack.push(auxStack.pop());
        }
        return result;
    }

    private void push(int x) {
        stack.push(x);
    }

    private boolean empty() {
        return stack.isEmpty();
    }
}
