package com.jack.algorithm.problem.midium;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author jack
 */
public class LeetCode0002 {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            ListNode cur = this;
            while (cur != null) {
                sb.append(cur.val);
                if (cur.next != null) {
                    sb.append(", ");
                }
                cur = cur.next;
            }
            return sb.toString();
        }
    }
    public ListNode addTwoNumbers3(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
            }
            if (l2 != null) {
                sum += l2.val;
            }
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Queue<Integer> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();
        putNodeToQueue(l1, queue1);
        putNodeToQueue(l2, queue2);
        int carry = 0;
        ListNode curNode = null;
        Stack<Integer> stack = new Stack<>();
        while (!queue1.isEmpty() || !queue2.isEmpty() || carry != 0) {
            int data = carry;
            if (!queue1.isEmpty()) {
                data += queue1.remove();
            }
            if (!queue2.isEmpty()) {
                data += queue2.remove();
            }
            carry = data / 10;
            data %= 10;
            stack.add(data);
        }
        while (!stack.isEmpty()) {
            if (curNode == null) {
                curNode = new ListNode(stack.pop());
            } else {
                ListNode tempNode = curNode;
                curNode = new ListNode(stack.pop());
                curNode.next = tempNode;
            }
        }
        return curNode;
    }

    private void putNodeToQueue(ListNode listNode, Queue<Integer> queue) {
        ListNode cur = listNode;
        while (cur != null) {
            queue.add(cur.val);
            cur = cur.next;
        }
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        // it's error if to much node
        ListNode curNode = null;
        StringBuilder sb1 = new StringBuilder();
        while (l1 != null) {
            sb1.insert(0, l1.val);
            l1 = l1.next;
        }
        StringBuilder sb2 = new StringBuilder();
        while (l2 != null) {
            sb2.insert(0, l2.val);
            l2 = l2.next;
        }
        long res = Long.parseLong(sb1.toString())
                + Long.parseLong(sb2.toString());
        String resStr = Long.toString(res);
        int i = 0;
        while (i != resStr.length()) {
            char data = resStr.charAt(i);
            if (curNode == null) {
                curNode = new ListNode(data - '0');
            } else {
                ListNode temp = curNode;
                curNode = new ListNode(data - '0');
                curNode.next = temp;
            }
            i ++;
        }
        return curNode;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l11 = new ListNode(4);
        l11.next = new ListNode(3);
        l1.next = l11;

        ListNode l2 = new ListNode(5);
        ListNode l21 = new ListNode(6);
        l21.next = new ListNode(4);
        l2.next = l21;

        System.out.println(l1);
        System.out.println(l2);

        LeetCode0002 main = new LeetCode0002();
        System.out.println(main.addTwoNumbers(l1, l2));
        System.out.println(main.addTwoNumbers2(l1, l2));
    }
}
