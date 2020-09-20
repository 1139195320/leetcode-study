package com.jack.algorithm.problem.pre;

import java.util.*;

/**
 * @author jack
 */
public class Easy0653 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { this.val = x; }
    }

    public TreeNode getNode(String src) {
        String[] arr = src.split(",");
        String val = arr[0];
        if (val != null && !"#".equals(val)) {
            TreeNode root = new TreeNode(Integer.parseInt(val));
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            int index = 1;
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode cur = queue.remove();
                    String leftVal = arr[index ++];
                    if (leftVal != null && !"#".equals(leftVal)) {
                        cur.left = new TreeNode(Integer.parseInt(leftVal));
                        queue.add(cur.left);
                    }
                    String rightVal = arr[index ++];
                    if (rightVal != null && !"#".equals(rightVal)) {
                        cur.right = new TreeNode(Integer.parseInt(rightVal));
                        queue.add(cur.right);
                    }
                }
            }
            return root;
        }
        return null;
    }

    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.empty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
        if (list.size() < 2) {
            return false;
        }
        int l = 0;
        int r = list.size() - 1;
        int minSum = list.get(l) + list.get(l + 1);
        if (minSum == k) {
            return true;
        }
        if (minSum > k) {
            return false;
        }
        int maxSum = list.get(r) + list.get(r - 1);
        if (maxSum == k){
            return true;
        }
        if (maxSum < k) {
            return false;
        }
        while (l < r) {
            int sum = list.get(l) + list.get(r);
            if (sum == k) {
                return true;
            } else if (sum < k) {
                l ++;
            } else {
                r --;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Easy0653 main = new Easy0653();
        System.out.println(main.findTarget(
                main.getNode("5,3,6,2,4,#,7,#,#,#,#,#,#"), 9
        ));
    }
}
