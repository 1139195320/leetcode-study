package com.jack.algorithm.problem.midium;

/**
 * @author jack
 */
public class LeetCode10204 {

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

    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        ListNode vMinHead = new ListNode(0);
        ListNode minHead = new ListNode(0);
        ListNode vMaxHead = new ListNode(0);
        ListNode maxHead = new ListNode(0);
        vMinHead.next = minHead;
        vMaxHead.next = maxHead;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val < x) {
                minHead.next = cur;
                minHead = cur;
            } else {
                maxHead.next = cur;
                maxHead = cur;
            }
            cur = cur.next;
        }
        maxHead.next = null;
        minHead.next = vMaxHead.next.next;
        return vMinHead.next.next;
    }

    public static void main(String[] args) {
        LeetCode10204 main = new LeetCode10204();
        System.out.println(main.partition(
                main.getListNode(3, 5, 8, 5, 10, 2, 1), 5
        ));
    }
}