package com.jack.algorithm.problem.easy;

/**
 * @author jack
 */
public class LeetCode0557 {

    public String reverseWords(String s) {
        int n = s.length();
        if (n < 2) {
            return s;
        }
        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < arr.length; i++) {
            sb.append(reverse(arr[i]));
            if (i != arr.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
    private String reverse(String t) {
        return new StringBuilder(t).reverse().toString();
    }

    public String reverseWords2(String s) {
        int n = s.length();
        if (n < 2) {
            return s;
        }
        StringBuilder sb = new StringBuilder(n);
        int i = 0;
        char[] arr = s.toCharArray();
        while (i < n) {
            while (i < n && arr[i] != ' ') {
                i ++;
            }
            // 找到了这个 word 后面的空格位置
            int j = i - 1;
            while (j >= 0 && arr[j] != ' ') {
                sb.append(arr[j --]);
            }
            if (i != n) {
                sb.append(' ');
            }
            i ++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LeetCode0557 main = new LeetCode0557();
        // s'tel og ot emoh !
        System.out.println(main.reverseWords("let's go to home !"));
        // s'tel og ot emoh !
        System.out.println(main.reverseWords2("let's go to home !"));
    }

}