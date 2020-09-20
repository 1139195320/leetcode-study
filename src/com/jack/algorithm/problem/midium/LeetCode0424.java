package com.jack.algorithm.problem.midium;

/**
 * @author jack
 */
public class LeetCode0424 {

    public int characterReplacement(String s, int k) {
        int[] map = new int[26];
        int maxCount = 1;
        if (s == null) {
            return 0;
        }
        char[] arr = s.toCharArray();
        int l = 0;
        for (int r = 0; r < arr.length; r++) {
            int i = arr[r] - 'A';
            map[i] ++;
            maxCount = Math.max(maxCount, map[i]);
            if (r - l  + 1 > maxCount + k) {
                map[arr[l] - 'A'] --;
                l ++;
            }
        }
        return arr.length - l;
    }

    public static void main(String[] args) {
        LeetCode0424 main = new LeetCode0424();
        System.out.println(main.characterReplacement(
                "ABAB", 2
        ));
        System.out.println(main.characterReplacement(
                "AABABBA", 1
        ));
        System.out.println(main.characterReplacement(
                "AABBBBA", 2
        ));
    }
}