package me.xiao.leetcode.string;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * 简化linux的文件路径
 * <p>
 * path = "/a/./b/../../c/", => "/c"
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/8 18:45
 */

public class Medium05_SimplifyPath {
    public static void main(String[] args) {
        System.out.println(new Medium05_SimplifyPath().simplifyPath("/a/./b/../../c/"));
    }

    private String simplifyPath(String path) {
        if (path == null || path.isEmpty()) return "/";
        StringTokenizer st = new StringTokenizer(path, "/");
        Deque<String> dQueue = new ArrayDeque<>();

        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            if (token.trim().equals("..")) {
                if (!dQueue.isEmpty())
                    dQueue.pop();
            } else if (token.trim().equals(".")) {

            } else {
                dQueue.push(token);
            }
        }

        if (dQueue.isEmpty()) return "/";
        StringBuilder sb = new StringBuilder();
        while (!dQueue.isEmpty()) {
            sb.append("/").append(dQueue.removeLast());
        }
        return sb.toString();

    }
}
