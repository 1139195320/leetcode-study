package com.jack.algorithm.problem.midium;

/**
 * @author jack
 */
public class LeetCode0024 {

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
        private ListNode(int ... valArr) {
            if (valArr != null && valArr.length > 0) {
                this.val = valArr[0];
                ListNode curNext = null;
                for (int i = 1; i < valArr.length; i++) {
                    ListNode newNode = new ListNode(valArr[i]);
                    if (curNext == null) {
                        this.next = newNode;
                        curNext = this.next;
                    } else {
                        curNext.next = newNode;
                        curNext = newNode;
                    }
                }
            }
        }
    }


    public ListNode swapPairs(ListNode head) {
        // LeetCode0025 的简易版
        return null;
    }
}
