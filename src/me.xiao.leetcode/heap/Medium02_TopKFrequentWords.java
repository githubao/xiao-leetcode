package me.xiao.leetcode.heap;

import java.util.*;

/**
 * 数组里面最常见的前k个单词
 * O(n log k)时间复杂度 O（n）的空间复杂度
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/4 16:31
 */

public class Medium02_TopKFrequentWords {
    public static void main(String[] args) {
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        List<String> sorted = new Medium02_TopKFrequentWords().topKFrequent(words, 2);
        System.out.println(sorted);
    }

    private List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.merge(word, 1, (a, b) -> a + b);
        }

//        优先级队列，升序，大的在后面
        Queue<Pair> pq = new PriorityQueue<>((o1, o2) -> (o1.freq == o2.freq) ? o2.word.compareTo(o1.word) : Integer.compare(o1.freq, o2.freq));

        for (String w : map.keySet()) {
            int f = map.get(w);
            pq.offer(new Pair(w, f));
            if (pq.size() > k) {
                pq.poll();
            }
        }

        List<String> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.poll().word);
        }

        Collections.reverse(result);

        return result;
    }

    class Pair {
        String word;
        int freq;

        Pair(String word, int freq) {
            this.word = word;
            this.freq = freq;
        }
    }
}
