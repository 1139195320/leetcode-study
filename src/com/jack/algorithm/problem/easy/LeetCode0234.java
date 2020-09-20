package com.jack.algorithm.problem.easy;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author jack
 */
public class LeetCode0234 {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { this.val = x; }
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            ListNode cur = this;
            while (cur != null) {
                sb.append(cur.val).append(", ");
                cur = cur.next;
            }
            return sb.length() > 0 ? sb.substring(0, sb.length() - 2) : "";
        }
    }


    private ListNode getListNode(int ... dataArr) {
        return getListNode(dataArr, 0);
    }
    private ListNode getListNode(int[] dataArr, int i) {
        if (i >= dataArr.length) {
            return null;
        }
        ListNode res = new ListNode(dataArr[i]);
        res.next = getListNode(dataArr, i + 1);
        return res;
    }

    public boolean isPalindrome(ListNode head) {
        Deque<Integer> deque = new LinkedList<>();
        while (head != null) {
            deque.push(head.val);
            head = head.next;
        }
        while (!deque.isEmpty() && deque.size() > 1) {
            if (!deque.pollFirst().equals(deque.pollLast())) {
                return false;
            }
        }
        return true;
    }

    private ListNode preHead;
    public boolean isPalindrome2(ListNode head) {
        preHead = head;
        return doIsPalindrome(head);
    }
    private boolean doIsPalindrome(ListNode node) {
        if (node != null) {
            if (!doIsPalindrome(node.next)) {
                return false;
            }
            if (preHead.val != node.val) {
                return false;
            }
            preHead = preHead.next;
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode0234 main = new LeetCode0234();
        System.out.println(main.isPalindrome(
                main.getListNode(1, 2)
        ));
        System.out.println(main.isPalindrome(
                main.getListNode(1, 2, 2, 1)
        ));
    }
}