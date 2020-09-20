package com.jack.algorithm.problem.pre;

import java.util.Arrays;

/**
 * @author jack
 */
public class Medium1433 {

    public boolean checkIfCanBreak(String s1, String s2) {
        int n = s1.length();
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int i = 0;
        // 过滤掉前面相等的部分，因为相等的可算 ≥ 也可算 ≤
        while (i < n && arr1[i] == arr2[i]) {
            i ++;
        }
        boolean flag = arr1[i] >= arr2[i];
        for (; i < n; i++) {
            if (flag != (arr1[i] >= arr2[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Medium1433 main = new Medium1433();
        System.out.println(main.checkIfCanBreak("abc", "xya"));
        System.out.println(main.checkIfCanBreak("abe", "acd"));
        System.out.println(main.checkIfCanBreak("leetcode", "interview"));
    }
}