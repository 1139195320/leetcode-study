package com.jack.algorithm.problem.midium;

import java.util.*;

/**
 * @author jack
 */
public class LeetCode0508 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public int[] findFrequentTreeSum(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            boolean allNull = true;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.remove();
                if (cur != null) {
                    list.add(cur.val);
                    queue.add(cur.left);
                    queue.add(cur.right);
                    allNull = false;
                } else {
                    list.add(null);
                    queue.add(null);
                    queue.add(null);
                }
            }
            if (allNull) {
                break;
            }
        }
        Integer[] arr = new Integer[list.size()];
        for (int i = list.size() - 1; i >= 0; i--) {
            arr[i] = list.get(i);
            int il = (i << 1) + 1;
            int ir = (i << 1) + 2;
            if (il < list.size() && arr[il] != null) {
                arr[i] += arr[il];
            }
            if (ir < list.size() && arr[ir] != null) {
                arr[i] += arr[ir];
            }
        }
        Map<Integer, Integer> map = new HashMap<>(arr.length);
        for (Integer data : arr) {
            if (data != null) {
                map.put(data, map.getOrDefault(data, 0) + 1);
            }
        }
        return getRes(map);
    }
    private int[] getRes(Map<Integer, Integer> map){
        int maxSize = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            maxSize = Math.max(maxSize, entry.getValue());
        }
        List<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxSize) {
                res.add(entry.getKey());
            }
        }
        int[] resArr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            resArr[i] = res.get(i);
        }
        return resArr;
    }

    public int[] findFrequentTreeSum2(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        doPostOrder(root, map);
        return getRes(map);
    }
    private void doPostOrder(TreeNode node, Map<Integer, Integer> map) {
        if (node != null) {
            int curVal = node.val;
            TreeNode left = node.left;
            if (left != null) {
                doPostOrder(left, map);
                curVal += left.val;
            }
            TreeNode right = node.right;
            if (right != null) {
                doPostOrder(right, map);
                curVal += right.val;
            }
            node.val = curVal;
            map.put(curVal, map.getOrDefault(curVal, 0) + 1);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(-5);
        LeetCode0508 main = new LeetCode0508();
        System.out.println(Arrays.toString(main.findFrequentTreeSum(root)));
        System.out.println(Arrays.toString(main.findFrequentTreeSum2(root)));
    }
}