package me.xiao.leetcode.tree;

/**
 * 表示树的层级
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/4 10:19
 */

public class LevelNode {
    public int level;
    public TreeNode node;

    public LevelNode(int level, TreeNode node) {
        this.level = level;
        this.node = node;
    }
}
