package com.jack.algorithm.problem.easy;

/**
 * @author jack
 */
public class LeetCode0345 {

    public String reverseVowels(String s) {
        int n = s.length();
        if (s.length() < 2) {
            return s;
        }
        char[] arr = s.toCharArray();
        int i = 0, j = n - 1;
        while (i < j) {
            while (i < j && isNotVowel(arr[i])) {
                i++;
            }
            if (i == j) {
                break;
            }
            while (i < j && isNotVowel(arr[j])) {
                j --;
            }
            if (i == j) {
                break;
            }
            if (arr[i] != arr[j]) {
                swap(arr, i, j);
            }
            i ++;
            j --;
        }
        return new String(arr);
    }
    private void swap(char[] arr, int i, int j) {
        char c = arr[j];
        arr[j] = arr[i];
        arr[i] = c;
    }
    private boolean isNotVowel(char c) {
        return c != 'a' && c != 'e' && c != 'i'
                && c != 'o' && c != 'u'
                && c != 'A' && c != 'E' && c != 'I'
                && c != 'O' && c != 'U';
    }

    public static void main(String[] args) {
        LeetCode0345 main = new LeetCode0345();
        System.out.println(main.reverseVowels("hello"));
        System.out.println(main.reverseVowels("leetcode"));
    }
}