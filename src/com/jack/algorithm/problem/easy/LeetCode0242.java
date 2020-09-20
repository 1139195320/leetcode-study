package com.jack.algorithm.problem.easy;

/**
 * @author jack
 */
public class LeetCode0242 {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        for (char c : s.toCharArray()) {
            arr1[c - 'a'] ++;
        }
        for (char c : t.toCharArray()) {
            arr2[c - 'a'] ++;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode0242 main = new LeetCode0242();
    }
}