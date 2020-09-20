package com.jack.algorithm.problem.easy;

/**
 * @author jack
 */
public class LeetCode10058 {

    public String reverseLeftWords(String s, int n) {
        if (n <= 0 || n >= s.length()) {
            return s;
        }
        StringBuilder sb = new StringBuilder(s.length());
        for (int i = n; i < s.length() + n; i++) {
            if (i < s.length()) {
                sb.append(s.charAt(i));
            } else {
                sb.append(s.charAt(i - s.length()));
            }
        }
        return sb.toString();
    }

    public String reverseLeftWords2(String s, int n) {
        return s.substring(n, s.length()) + s.substring(0, n);
    }

    public static void main(String[] args) {
        LeetCode10058 main = new LeetCode10058();
        System.out.println(main.reverseLeftWords("abcdefg", 2));
        System.out.println(main.reverseLeftWords("lrloseumgh", 6));
        System.out.println(main.reverseLeftWords2("abcdefg", 2));
        System.out.println(main.reverseLeftWords2("lrloseumgh", 6));
    }
}
