package com.jack.algorithm.problem.midium;

/**
 * @author jack
 */
public class LeetCode0331 {

    public boolean isValidSerialization(String preorder) {
        // 初始槽位为 1
        int slots = 1;
        String[] arr = preorder.split(",");
        for (String s : arr) {
            // 每到一个节点，槽位 -1
            slots --;
            if (slots < 0) {
                return false;
            }
            if (!"#".equals(s)) {
                // 遇到一个非空节点，槽位 +2
                slots += 2;
            }
        }
        return slots == 0;
    }

    public boolean isValidSerialization2(String preorder) {
        int slots = 1;
        int n = preorder.length();
        for (int i = 0; i < n; i++) {
            if (preorder.charAt(i) == ',') {
                slots --;
                if (slots < 0) {
                    return false;
                }
                if (preorder.charAt(i - 1) != '#') {
                    slots += 2;
                }
            }
        }
        slots = preorder.charAt(n - 1) == '#' ? slots - 1 : slots + 1;
        return slots == 0;
    }

    public static void main(String[] args) {
        LeetCode0331 main = new LeetCode0331();
        System.out.println(main.isValidSerialization(
                "9,3,4,#,#,1,#,#,2,#,6,#,#"));
        System.out.println(main.isValidSerialization("1,#"));
        System.out.println(main.isValidSerialization("9,#,#,1"));
    }
}