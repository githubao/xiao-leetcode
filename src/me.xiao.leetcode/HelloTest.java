package me.xiao.leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * java 语言测试
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/4 16:49
 */

public class HelloTest {
    public static void main(String[] args) {
//        System.out.println("a".compareTo("b"));
//        System.out.println(Integer.compare(1, 2));

        Queue<String> pq = new PriorityQueue<>((o1, o2) -> (true ? o1.compareTo(o2) : 0));
        pq.offer("i");
        pq.offer("love");

        System.out.println(pq);

    }
}
