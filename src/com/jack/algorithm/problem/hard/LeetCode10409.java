package com.jack.algorithm.problem.hard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jack
 */
public class LeetCode10409 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { this.val = x; }
    }

    public static List<List<Integer>> BSTSequences(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root != null) {
            List<Integer> single = new ArrayList<>();
            List<TreeNode> free = new LinkedList<>();
            single.add(root.val);
            doSequences(root, single, free, res);
        }
        if(res.size() == 0) {
            res.add(new ArrayList<>());
        }
        return res;
    }

    private static void doSequences(TreeNode root, List<Integer> single,
                                    List<TreeNode> free, List<List<Integer>> res) {
        if(root == null) {
            return;
        }
        if(root.left != null) {
            free.add(root.left);
        }
        if(root.right != null) {
            free.add(root.right);
        }
        if(free.size() == 0) {
            List<Integer> one = new ArrayList<>(single);
            res.add(one);
        }
        for (int i = 0; i < free.size(); i ++) {
            single.add(free.get(i).val);
            TreeNode removeNode = free.remove(i);
            doSequences(removeNode, single, free, res);
            free.add(i, removeNode);
            single.remove(single.size() - 1);
        }
        if(root.right != null) {
            free.remove(root.right);
        }
        if(root.left != null) {
            free.remove(root.left);
        }
    }
}
