package com.jack.algorithm.problem.pre;

/**
 * @author jack
 */
public class Easy1370 {

    public String sortString(String s) {
        int[] arr = new int[26];
        for (char c : s.toCharArray()) {
            arr[c - 'a'] ++;
        }
        int n = s.length();
        StringBuilder sb = new StringBuilder(n);
        boolean flag = true;
        for (int i = 0; i < n; i++) {
            if (flag) {
                for (int j = 0; j < arr.length; j++) {
                    if (arr[j] > 0) {
                        sb.append((char) ('a' + j));
                        arr[j] --;
                    }
                }
                flag = false;
            } else {
                for (int j = arr.length - 1; j >= 0; j--) {
                    if (arr[j] > 0) {
                        sb.append((char) ('a' + j));
                        arr[j] --;
                    }
                }
                flag = true;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Easy1370 main = new Easy1370();
        System.out.println(main.sortString("aaaabbbbcccc"));
        System.out.println(main.sortString("rat"));
        System.out.println(main.sortString("leetcode"));
        System.out.println(main.sortString("ggggggg"));
        System.out.println(main.sortString("spo"));
    }
}