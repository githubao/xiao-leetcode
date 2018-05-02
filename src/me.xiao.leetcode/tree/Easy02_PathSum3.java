package me.xiao.leetcode.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一颗树，给定一个和，遍历怎么样的路径加起来可以得到这个和
 * 统计路径的条数
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/2 13:20
 */

public class Easy02_PathSum3 {
    private Map<Integer, Integer> pathCount = new HashMap<>();
    private int totalCount;

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        System.out.println(new Easy02_PathSum3().pathSum(node, 0));
    }

    private int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return dfs(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int dfs(TreeNode root, int sum) {
        int res = 0;
        if (root == null) return res;

        if (sum == root.value) res++;

        res += dfs(root.left, sum - root.value);
        res += dfs(root.right, sum - root.value);

        return res;
    }

//    private int pathSum(TreeNode root, int sum) {
//        if (root == null) return 0;
//        dfs(root, sum, 0);
//        return totalCount;
//    }
//
//    private void dfs(TreeNode root, int target, int pSum) {
//        if (root != null) {
//            pSum += root.value;
//            if (pSum == target) totalCount++;
//            totalCount += pathCount.getOrDefault(pSum - target, 0);
//            pathCount.put(pSum, pathCount.getOrDefault(pSum, 0) + 1);
//            dfs(root.left, target, pSum);
//            dfs(root.right, target, pSum);
//            pathCount.put(pSum, pathCount.get(pSum) - 1);
//        }
//    }
}
