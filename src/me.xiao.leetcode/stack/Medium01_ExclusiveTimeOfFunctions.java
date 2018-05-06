package me.xiao.leetcode.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * function_id:start_or_end:timestamp
 * <p>
 * 统计该函数用了多少时间，函数内部调用其他函数使用的时间不算
 * <p>
 * 函数是堆栈调用了，到了end的时候，统计该函数的时间，并pop掉
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/4 17:43
 */

public class Medium01_ExclusiveTimeOfFunctions {
    public static void main(String[] args) {
        List<String> logs = Arrays.asList("0:start:0", "1:start:2", "1:end:5", "0:end:6");
        int[] results = new Medium01_ExclusiveTimeOfFunctions().exclusiveTime(2, logs);
        System.out.println(Arrays.toString(results));
    }

    private int[] exclusiveTime(int cnt, List<String> logs) {
        int[] times = new int[cnt];

        List<Log> functions = new ArrayList<>();
        for (String s : logs) {
            String[] parts = s.split(":");
            functions.add(new Log(Integer.parseInt(parts[0]), parts[1], Integer.parseInt(parts[2])));
        }

        Stack<Log> stack = new Stack<>();
        stack.push(functions.get(0));

        for (int i = 1; i < functions.size(); i++) {
            Log next = functions.get(i);

            if (stack.isEmpty()) {
                stack.push(next);
                continue;
            }

            Log curr = stack.peek();
            if (next.func.equals("end")) {
                times[curr.id] += (next.time - curr.time + 1);

                stack.pop();
                if (!stack.isEmpty()) {
                    stack.peek().time = next.time + 1;
                }
            } else {
                stack.push(next);
                times[curr.id] += (next.time - curr.time);
            }
        }

        return times;

    }

    class Log {
        int id;
        int time;
        String func;

        public Log(int id, String func, int time) {
            this.id = id;
            this.time = time;
            this.func = func;
        }
    }

}
