package com.jack.algorithm.problem.easy;

/**
 * @author jack
 */
public class LeetCode0521 {

    public int findLUSlength(String a, String b) {
        int n1 = a.length();
        int n2 = b.length();
        if (n1 != n2) {
            return Math.max(n1, n2);
        }
        if (a.equals(b)) {
            return -1;
        }
        int l = 0, r = n1 - 1;
        char[] arr1 = a.toCharArray();
        char[] arr2 = b.toCharArray();
        while (l < r) {
            byte flag = 0;
            if (arr1[l] == arr2[l]) {
                l ++;
                flag ++;
            }
            if (arr1[r] == arr2[r]) {
                r --;
                flag ++;
            }
            if (flag == 0) {
                break;
            }
        }
        return r - l + 1;
    }

    public int findLUSlength2(String a, String b) {
        if (a.equals(b)) {
            return -1;
        }
        return Math.max(a.length(), b.length());
    }
}
