package me.xiao.leetcode.breadth_first_search;

import java.util.*;

/**
 * 一个dictionary，从开始词语变成结束词语，每次只能变换一个字母，而且单词要在dictionary里面
 * <p>
 * 求总共的步数
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/4 10:33
 */

public class Medium02_WordLadder {
    private static final String CONST = "abcdefghijklmnopqrstuvwxyz";

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        System.out.println(new Medium02_WordLadder().ladderLength("hit", "cog", list));
    }

    private int ladderLength(String start, String end, List<String> words) {
        Queue<State> queue = new ArrayDeque<>();
        Set<String> dictionary = new HashSet<>(words);
        Set<String> done = new HashSet<>();

        queue.offer(new State(start, 0));
        done.add(start);

        while (!queue.isEmpty()) {
            State head = queue.poll();
            if (head.word.equals(end)) {
                return head.len + 1;
            }
            for (int i = 0; i < CONST.length(); i++) {
                StringBuilder word = new StringBuilder(head.word);
                for (int j = 0; j < word.length(); j++) {

                    char old = word.charAt(j);
                    word.replace(j, j + 1, String.valueOf(CONST.charAt(i)));

                    if (!done.contains(word.toString())) {
                        if (dictionary.contains(word.toString())) {
                            done.add(word.toString());
                            queue.offer(new State(word.toString(), head.len + 1));
                        }
                    }

                    word.replace(j, j + 1, String.valueOf(old));
                }
            }
        }

        return 0;
    }

    class State {
        String word;
        int len;

        public State(String word, int len) {
            this.word = word;
            this.len = len;
        }
    }
}
