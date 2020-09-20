package com.jack.algorithm.problem.pre;

/**
 * @author jack
 */
public class Easy10202 {

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

    public int kthToLast(ListNode head, int k) {
        ListNode first = head;
        ListNode second = head;
        while (second != null) {
            second = second.next;
            if (k > 0) {
                k --;
            } else {
                first = first.next;
            }
        }
        return first.val;
    }

    public static void main(String[] args) {
        Easy10202 main = new Easy10202();
        System.out.println(main.kthToLast(
                main.getListNode(1, 2, 3, 4, 5), 2
        ));
    }
}