package com.jack.algorithm.problem.midium;

/**
 * @author jack
 */
public class LeetCode0165 {

    public int compareVersion(String version1, String version2) {
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");
        int i = 0;
        int m = arr1.length, n = arr2.length;
        while (i < Math.min(m, n)) {
            int a = Integer.parseInt(arr1[i]);
            int b = Integer.parseInt(arr2[i]);
            if (a > b) {
                return 1;
            } else if (a < b) {
                return -1;
            }
            i ++;
        }
        if (m > n) {
            while (i < m) {
                if (Integer.parseInt(arr1[i]) != 0) {
                    return 1;
                }
                i ++;
            }
        } else if (m < n) {
            while (i < n) {
                if (Integer.parseInt(arr2[i]) != 0) {
                    return -1;
                }
                i ++;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        LeetCode0165 main = new LeetCode0165();
        System.out.println(main.compareVersion("1.01", "1.001"));
        System.out.println(main.compareVersion("1.0.1", "1"));
        System.out.println(main.compareVersion("1.0", "1.00"));
        System.out.println(main.compareVersion("7.5.2.4", "7.5.3"));
    }
}