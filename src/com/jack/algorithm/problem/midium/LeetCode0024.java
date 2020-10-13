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


    public ListNode swapPairs2(ListNode head) {
        boolean tag = false;
        int pre = -1;
        ListNode preNode = head;
        ListNode cur = head;
        while (cur != null) {
            if (!tag) {
                pre = cur.val;
                preNode = cur;
                tag = true;
            } else {
                preNode.val = cur.val;
                cur.val = pre;
                tag = false;
            }
            cur = cur.next;
        }
        return head;
    }

    public static void main(String[] args) {
        LeetCode0024 main = new LeetCode0024();
        System.out.println(main.swapPairs2(new ListNode(1, 2, 3, 4)));
        System.out.println(main.swapPairs2(new ListNode(1, 2, 3, 4, 5)));
    }
}
