package com.jack.algorithm.problem.hard;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jack
 */
public class LeetCode1028 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { this.val = x; }
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            Queue<TreeNode> queue = new LinkedList<>();
            sb.append(this.val).append(",");
            queue.add(this);
            while (!queue.isEmpty()) {
                TreeNode cur = queue.remove();
                if (cur.left != null) {
                    queue.add(cur.left);
                    sb.append(cur.left.val).append(",");
                } else {
                    sb.append("#,");
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                    sb.append(cur.right.val).append(",");
                } else {
                    sb.append("#,");
                }
            }
            return sb.toString();
        }
    }

    public TreeNode recoverFromPreorder(String S) {
        if (S == null || S.length() == 0) {
            return null;
        }
        int i = 0;
        int j = i;
        Deque<TreeNode> deque = new LinkedList<>();
        while (i < S.length()) {
            int count = 0;
            while (j < S.length() && S.charAt(j) == '-') {
                count ++;
                j ++;
                i ++;
            }
            while (j < S.length() && S.charAt(j) != '-') {
                j ++;
            }
            TreeNode cur = new TreeNode(Integer.parseInt(S.substring(i, j)));
            i = j;
            if (count == deque.size()) {
                if (!deque.isEmpty()) {
                    deque.peek().left = cur;
                }
            }
            else {
                while (count != deque.size()) {
                    deque.pop();
                }
                if (!deque.isEmpty()) {
                    deque.peek().right = cur;
                }
            }
            deque.push(cur);
        }
        while (deque.size() > 1) {
            deque.pop();
        }
        return deque.pop();
    }

    public static void main(String[] args) {
        LeetCode1028 main = new LeetCode1028();
        // 1,2,5,3,#,6,#,4,#,7
        System.out.println(main.recoverFromPreorder("1-2--3---4-5--6---7"));
        // 1,401,#,349,88,90
        System.out.println(main.recoverFromPreorder("1-401--349---90--88"));
    }
}