package com.jack.algorithm.problem.easy;

/**
 * @author jack
 */
public class LeetCode1290 {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { this.val = x; }
    }

    public int getDecimalValue(ListNode head) {
        int res = 0;
        while (head != null) {
            res <<= 1;
            res += head.val;
            head = head.next;
        }
        return res;
    }
}
