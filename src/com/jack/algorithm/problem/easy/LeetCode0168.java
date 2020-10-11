package com.jack.algorithm.problem.easy;

/**
 * @author jack
 */
public class LeetCode0168 {

    public String convertToTitle(int n) {
        int mod = 26;
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n --;
            sb.insert(0, (char) ('A' + n % mod));
            n /= mod;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LeetCode0168 main = new LeetCode0168();
        System.out.println(main.convertToTitle(25));
        System.out.println(main.convertToTitle(26));
        System.out.println(main.convertToTitle(27));
        System.out.println(main.convertToTitle(52));
    }
}
