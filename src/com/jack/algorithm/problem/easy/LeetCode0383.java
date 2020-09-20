package com.jack.algorithm.problem.easy;

/**
 * @author jack
 */
public class LeetCode0383 {

    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        int[] count = new int[26];
        for (char c : magazine.toCharArray()) {
            count[c - 'a'] ++;
        }
        for (char c : ransomNote.toCharArray()) {
            if (count[c - 'a'] == 0) {
                return false;
            }
            count[c - 'a'] --;
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode0383 main = new LeetCode0383();
        System.out.println(main.canConstruct("a", "b"));
        System.out.println(main.canConstruct("aa", "ab"));
        System.out.println(main.canConstruct("aa", "aba"));
    }
}