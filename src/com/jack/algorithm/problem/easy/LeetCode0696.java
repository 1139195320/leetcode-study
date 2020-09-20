package com.jack.algorithm.problem.easy;

/**
 * @author jack
 */
public class LeetCode0696 {

    public int countBinarySubstrings(String s) {
        int res = 0;
        int n = s.length();
        if (n < 2) {
            return 0;
        }
        char[] arr = s.toCharArray();
        int pre = arr[0] - '0';
        int countA = 1;
        int countB = 0;
        boolean firstEquals = true;
        for (int i = 1; i < n; i++) {
            int cur = arr[i] - '0';
            if (cur == pre && !firstEquals) {
                // 不是第一次的相等
                // 变号次数大于 1
                countA = countB;
                countB = 0;
                pre ^= 1;
            }
            if (cur == pre) {
                // 相等
                countA++;
            } else {
                // 变号
                if (countB < countA) {
                    res ++;
                }
                countB++;
                firstEquals = false;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode0696 main = new LeetCode0696();
        System.out.println(main.countBinarySubstrings(
                "11001100110"
        ));
        System.out.println(main.countBinarySubstrings(
                "10101"
        ));
        System.out.println(main.countBinarySubstrings(
                "110"
        ));
    }
}