package com.jack.algorithm.problem.midium;

/**
 * @author jack
 */
public class LeetCode0151 {

    public String reverseWords(String s) {
        s = s.trim();
        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder(s.length());
        for (int i = arr.length - 1; i >= 0; i--) {
            if (!"".equals(arr[i])) {
                sb.append(arr[i]);
                if (i != 0) {
                    sb.append(" ");
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LeetCode0151 main = new LeetCode0151();
        System.out.println(main.reverseWords("  hello world!  "));
        System.out.println(main.reverseWords("the sky is blue"));
        System.out.println(main.reverseWords("a good   example"));
    }
}