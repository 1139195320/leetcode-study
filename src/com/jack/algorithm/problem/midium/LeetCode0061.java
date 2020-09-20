package com.jack.algorithm.problem.midium;

/**
 * @author jack
 */
public class LeetCode0061 {

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

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        ListNode l = head;
        ListNode r = head;
        int n = 1;
        while (r.next != null) {
            n ++;
            r = r.next;
            if (k > 0) {
                k --;
            } else {
                l = l.next;
            }
        }
        ListNode res = l.next;
        l.next = null;
        r.next = head;
        if (k > 0) {
            k %= n;
            res = rotateRight(res, k);
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode0061 main = new LeetCode0061();
        System.out.println(main.rotateRight(
                main.getListNode(1, 2, 3, 4, 5), 2));
        System.out.println(main.rotateRight(
                main.getListNode(1, 2, 3, 4, 5), 5));
        System.out.println(main.rotateRight(
                main.getListNode(0, 1, 2), 4));
        System.out.println(main.rotateRight(
                main.getListNode(0), 1));
    }
}