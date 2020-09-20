package com.jack.algorithm.problem.easy;

/**
 * @author jack
 */
public class LeetCode0058 {

    public int lengthOfLastWord(String s) {
        int n = s.length();
        if (n == 0) {
            return 0;
        }
        int count = 0;
        boolean counting = false;
        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c != ' ') {
                counting = true;
                count ++;
            }
            else if (counting) {
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        LeetCode0058 main = new LeetCode0058();
        System.out.println(main.lengthOfLastWord("Hello World  "));
        System.out.println(main.lengthOfLastWord("Hello Wor  "));
    }
}