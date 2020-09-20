package com.jack.algorithm.problem.midium;

import java.util.Stack;

/**
 * @author fy
 */
public class LeetCode0445 {

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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        putNodeToStack(l1, stack1);
        putNodeToStack(l2, stack2);
        int carry = 0;
        ListNode tempNode;
        ListNode resNode = null;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int data = carry;
            if (!stack1.isEmpty()) {
                data += stack1.pop();
            }
            if (!stack2.isEmpty()) {
                data += stack2.pop();
            }
            carry = data / 10;
            data %= 10;
            tempNode = new ListNode(data);
            if (resNode == null) {
                resNode = tempNode;
            } else {
                ListNode temp = resNode;
                resNode = new ListNode(data);
                resNode.next = temp;
            }
        }
        return resNode;
    }

    private void putNodeToStack(ListNode listNode, Stack<Integer> stack) {
        ListNode cur = listNode;
        while (cur != null) {
            stack.add(cur.val);
            cur = cur.next;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(7);
        ListNode l11 = new ListNode(2);
        ListNode l12 = new ListNode(4);
        l12.next = new ListNode(3);
        l11.next = l12;
        l1.next = l11;

        ListNode l2 = new ListNode(5);
        ListNode l21 = new ListNode(6);
        l21.next = new ListNode(4);
        l2.next = l21;

        System.out.println(l1);
        System.out.println(l2);

        LeetCode0445 main = new LeetCode0445();
        System.out.println(main.addTwoNumbers(l1, l2));
    }
}
