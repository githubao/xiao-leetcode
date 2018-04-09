package me.xiao.leetcode.array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 数组的数组的时间间隔，能否连接起来
 * <p>
 * [[0,30], [5,10], [15,20]]
 *
 * @author pacman
 * @version 1.0
 * date: 2018/4/9 18:59
 */

public class Easy10_MeetingRooms {

    static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        Interval i1 = new Interval(0, 30);
        Interval i2 = new Interval(5, 10);
        Interval i3 = new Interval(15, 20);
        Interval[] intervals = {i1, i2, i3};

        System.out.println(new Easy10_MeetingRooms().canAttendMeetings(intervals));
    }

    private boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a.start));
//        Arrays.sort(intervals,(a,b) -> Integer.compare(a.start,b.start));
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start > intervals[i - 1].end) {
                return false;
            }
        }
        return true;
    }

}
