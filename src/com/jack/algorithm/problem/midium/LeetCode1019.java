package com.jack.algorithm.problem.midium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author jack
 */
public class LeetCode1019 {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { this.val = x; }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(val).append(", ");
            ListNode cur = next;
            while (cur != null) {
                sb.append(cur.val).append(", ");
                cur = cur.next;
            }
            return sb.toString().substring(0, sb.length() - 2);
        }
        ListNode(int... valArr) {
            this.val = valArr[0];
            ListNode cur = this;
            for (int i = 1; i < valArr.length; i++) {
                ListNode next = new ListNode(valArr[i]);
                cur.next = next;
                cur = next;
            }
        }
    }

    public int[] nextLargerNodes(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur.val);
            cur = cur.next;
        }
        int[] res = new int[stack.size()];
        List<Integer> list = new ArrayList<>();
        for (int i = stack.size() - 1; i >= 0; i--) {
            int curData = stack.pop();
            list.add(curData);
            for (int j = list.size() - 2; j >= 0; j--) {
                int tmp = list.get(j);
                if (tmp > curData) {
                    res[i] = tmp;
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode1019 main = new LeetCode1019();
        System.out.println(Arrays.toString(main.nextLargerNodes(
                new ListNode(2, 1, 5)
        )));
        System.out.println(Arrays.toString(main.nextLargerNodes(
                new ListNode(2, 7, 4, 3, 5)
        )));
        System.out.println(Arrays.toString(main.nextLargerNodes(
                new ListNode(1, 7, 5, 1, 9, 2, 5, 1)
        )));
    }
}