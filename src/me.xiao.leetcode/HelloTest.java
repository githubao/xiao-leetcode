package me.xiao.leetcode;

import java.util.*;

/**
 * java 语言测试
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/4 16:49
 */

public class HelloTest {

    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>(4);
        map.put(1, "1");
        map.put(2, "2");
        map.put(3, "3");
        map.put(4, "4");
        System.out.println(map);
    }

    public static void main2(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3);
        System.out.println(list.stream().limit(2).count());
    }

    public static void main1(String[] args) {
//        System.out.println("a".compareTo("b"));
//        System.out.println(Integer.compare(1, 2));

        Queue<String> pq = new PriorityQueue<>((o1, o2) -> (o1.compareTo(o2)));
        pq.offer("i");
        pq.offer("love");

        System.out.println(pq);
    }
}
