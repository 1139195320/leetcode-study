package com.jack.algorithm.problem.midium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author jack
 */
public class LeetCode0095 {

    public String fractionToDecimal(int numerator, int denominator) {
        return "";
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { this.val = x; }
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(this);
            while (!queue.isEmpty()) {
                TreeNode cur = queue.remove();
                sb.append(cur.val).append(", ");
                TreeNode left = cur.left;
                TreeNode right = cur.right;
                if (left != null) {
                    queue.add(left);
                }
                if (right != null) {
                    queue.add(right);
                }
            }
            return sb.toString().substring(0, sb.length() - 2);
        }
    }
    private List<TreeNode> buildNode(int l, int r) {
        if (l > r) {
            return new ArrayList<>();
        }
        List<TreeNode> list = new ArrayList<>();
        for (int i = l; i <= r; i++) {
            List<TreeNode> leftList = buildNode(l, i - 1);
            List<TreeNode> rightList = buildNode(i + 1, r);
            if (leftList.size() == 0) {
                leftList.add(null);
            }
            if (rightList.size() == 0) {
                rightList.add(null);
            }
            for (TreeNode left : leftList) {
                for (TreeNode right : rightList) {
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    list.add(node);
                }
            }
        }
        return list;
    }
    public List<TreeNode> generateTrees(int n) {
        return buildNode(1, n);
    }

    public static void main(String[] args) {
        LeetCode0095 main = new LeetCode0095();
        for (TreeNode node : main.generateTrees(4)) {
            System.out.println(node);
        }
    }
}