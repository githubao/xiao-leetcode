package me.xiao.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 如果前面的尾大于下一个的头，那个合并
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/2 18:45
 */

public class Medium04_MergeIntervals {
    public static void main(String[] args) {
        Interval i1 = new Interval(1, 2);
        Interval i2 = new Interval(3, 4);
        Interval i3 = new Interval(5, 6);
        Interval i4 = new Interval(1, 10);
        List<Interval> result = new Medium04_MergeIntervals().merge(Arrays.asList(i1, i2, i3, i4));
        result.forEach((it) -> System.out.println(it.start + " " + it.end));
    }

    private List<Interval> merge(List<Interval> intervals) {
        if (intervals.isEmpty()) return new ArrayList<>();

        intervals.sort(Comparator.comparingInt(it -> it.start));
        ArrayList<Interval> result = new ArrayList<>();
        Interval curr = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            if (interval.start >= curr.start && interval.start <= curr.end) {
                curr.end = curr.end > interval.end ? curr.end : interval.end;
            } else {
                result.add(curr);
                curr = interval;
            }
        }
        result.add(curr);
        return result;

    }

    static class Interval {
        int start;
        int end;

        public Interval() {
            this.start = this.end = 0;
        }

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
