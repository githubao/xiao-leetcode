package me.xiao.leetcode.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 会议的起始时间，返回最少的需要的会议室的数量
 * <p>
 * Given [[0, 30],[5, 10],[15, 20]]
 * return 2
 * <p>
 * 把end时间大于其他的开始时间的，通过优先级队列沉到队列底部，然后计数加一
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/4 15:43
 */

public class Medium01_MeetingRooms2 {
    public static void main(String[] args) {
        Interval[] intervals = {new Interval(0, 30), new Interval(5, 10), new Interval(15, 20)};
        System.out.println(new Medium01_MeetingRooms2().minMeetingRooms(intervals));
    }

    private int minMeetingRooms(Interval[] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(it -> it.start));
        PriorityQueue<Interval> queue = new PriorityQueue<>(Comparator.comparingInt(it -> it.end));

        int max = 0;
        for (Interval interval : intervals) {
            while (!queue.isEmpty() && queue.peek().end <= interval.start) {
                queue.poll();
            }
            queue.offer(interval);
            max = Math.max(max, queue.size());
        }

        return max;
    }

    public static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
}
