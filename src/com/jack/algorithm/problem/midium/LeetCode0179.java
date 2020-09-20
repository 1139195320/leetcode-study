package com.jack.algorithm.problem.midium;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author jack
 */
public class LeetCode0179 {

    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = String.valueOf(nums[i]);
        }
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                String l = arr[i];
                String r = arr[j];
                if (!compare(l + r, r + l)) {
                    swap(arr, i, j);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        if ("0".equals(arr[0])) {
            return "0";
        }
        for (String data : arr) {
            sb.append(data);
        }
        return sb.toString();
    }
    private boolean compare(String a, String b) {
        int lenA = a.length();
        if (lenA == 0) {
            return true;
        }
        int lenB = b.length();
        if (lenB == 0) {
            return false;
        }
        int i = 0, j = 0;
        while (i < lenA && j < lenB) {
            char cA = a.charAt(i);
            char cB = b.charAt(j);
            if (cA > cB) {
                return true;
            }
            if (cA < cB) {
                return false;
            }
            i ++;
            j ++;
        }
        return true;
    }
    private void swap(String[] arr, int i, int j) {
        String tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static class LargestNumberComparator
            implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            return (b + a).compareTo(a + b);
        }
    }
    public String largestNumber2(int[] nums) {
        int n = nums.length;
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(arr, new LargestNumberComparator());
        StringBuilder sb = new StringBuilder();
        if ("0".equals(arr[0])) {
            return "0";
        }
        for (String data : arr) {
            sb.append(data);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LeetCode0179 main = new LeetCode0179();
        System.out.println(main.largestNumber(new int[]{10, 2}));
        System.out.println(main.largestNumber(new int[]{3, 30, 34, 5, 9}));
    }
}