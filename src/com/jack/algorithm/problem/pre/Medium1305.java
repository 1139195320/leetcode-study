package com.jack.algorithm.problem.pre;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author jack
 */
public class Medium1305 {

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
    private static TreeNode getNode(Integer[] arr) {
        if (arr == null) {
            return null;
        }
        return doGetNode(arr, 0);
    }
    private static TreeNode doGetNode(Integer[] arr, int i) {
        if (i >= arr.length) {
            return null;
        }
        Integer data = arr[i];
        if (data == null) {
            return null;
        }
        TreeNode node = new TreeNode(data);
        node.left = doGetNode(arr, (i << 1) + 1);
        node.right = doGetNode(arr, (i << 1) + 2);
        return node;
    }

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> res = new ArrayList<>();
        List<Integer> list1 = innerOrder(root1);
        List<Integer> list2 = innerOrder(root2);
        if (list1.size() == 0) {
            return list2;
        }
        if (list2.size() == 0) {
            return list1;
        }
        int i = 0, j = 0;
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) <= list2.get(j)) {
                res.add(list1.get(i ++));
            } else {
                res.add(list2.get(j ++));
            }
        }
        if (i == list1.size()) {
            for (; j < list2.size(); j++) {
                res.add(list2.get(j));
            }
        } else {
            for (; i < list1.size(); i++) {
                res.add(list1.get(i));
            }
        }
        return res;
    }
    private List<Integer> innerOrder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        doInnerOrder(list, root);
        return list;
    }
    private void doInnerOrder(List<Integer> list, TreeNode node) {
        if (node == null) {
            return;
        }
        doInnerOrder(list, node.left);
        list.add(node.val);
        doInnerOrder(list, node.right);
    }

    public static void main(String[] args) {
        Medium1305 main = new Medium1305();
        System.out.println(main.getAllElements(
                getNode(new Integer[]{2, 1, 4}), getNode(new Integer[]{1, 0, 3})
        ));
        System.out.println(main.getAllElements(
                getNode(new Integer[]{1, null, 8}), getNode(new Integer[]{8, 1})
        ));
    }
}