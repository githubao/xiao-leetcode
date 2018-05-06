package me.xiao.leetcode.depth_first_search;

import java.util.*;

/**
 * 合并name和邮箱地址
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/6 19:45
 */

public class Medium07_AccountsMerge {

    private Map<Integer, Account> numMap;
    private Map<String, Integer> emailMap;
    private Map<Integer, List<Integer>> graph;
    private BitSet done;

    public static void main(String[] args) {
        List<List<String>> accounts = buildAccounts();
        List<List<String>> results = new Medium07_AccountsMerge().accountMerge(accounts);
        System.out.println(results);
    }

    private static List<List<String>> buildAccounts() {
        List<List<String>> accounts = new ArrayList<>();

        List<String> account1 = new ArrayList<>();
        account1.add("John");
        account1.add("johnsmith@mail.com");
        account1.add("john00@mail.com");
        accounts.add(account1);

        List<String> account2 = new ArrayList<>();
        account2.add("John");
        account2.add("johnnybravo@mail.com");
        accounts.add(account2);

        List<String> account3 = new ArrayList<>();
        account3.add("John");
        account3.add("johnsmith@mail.com");
        account3.add("john_newyork@mail.com");
        accounts.add(account3);

        List<String> account4 = new ArrayList<>();
        account4.add("Mary");
        account4.add("mary@mail.com");
        accounts.add(account4);

        return accounts;
    }

    private List<List<String>> accountMerge(List<List<String>> accounts) {
        done = new BitSet();
        numMap = new HashMap<>();
        emailMap = new HashMap<>();
        graph = new HashMap<>();

        int index = 0;
        for (List<String> account : accounts) {
            String name = account.get(0);
            int prev = -1;
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);

                int vertex;
                if (!emailMap.containsKey(email)) {
                    vertex = ++index;
                    emailMap.put(email, vertex);
                    numMap.put(vertex, new Account(email, name));
                } else {
                    vertex = emailMap.get(email);
                }

                graph.putIfAbsent(vertex, new ArrayList<>());

                if (i != 1) {
                    graph.get(prev).add(vertex);
                    graph.get(vertex).add(prev);
                }

                prev = vertex;
            }
        }

        List<List<String>> results = new ArrayList<>();
        for (int i : graph.keySet()) {
            if (!done.get(i)) {
                List<Integer> list = new ArrayList<>();
                List<String> account = new ArrayList<>();

                dfs(i, list);

                list.forEach(x -> account.add(numMap.get(x).email));
                account.sort(String::compareTo);

                Account acc = numMap.get(list.get(0));
                account.add(0, acc.name);
                results.add(account);
            }
        }
        return results;
    }

    private void dfs(int i, List<Integer> list) {
        done.set(i);
        list.add(i);

        List<Integer> child = graph.get(i);
        if (child != null) {
            for (int c : child) {
                if (!done.get(c)) {
                    dfs(c, list);
                }
            }
        }
    }

    class Account {
        String email;
        String name;

        public Account(String email, String name) {
            this.email = email;
            this.name = name;
        }
    }


}
