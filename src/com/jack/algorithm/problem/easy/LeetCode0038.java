package com.jack.algorithm.problem.easy;

/**
 * @author jack
 */
public class LeetCode0038 {

    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        if (n == 2) {
            return "11";
        }
        if (n == 3) {
            return "21";
        }
        String pre = countAndSay(n - 1);
        StringBuilder sb = new StringBuilder();
        char preC = '0';
        int preCount = 0;
        for (int i = 0; i < pre.length(); i++) {
            char c = pre.charAt(i);
            if (preC == c) {
                preCount ++;
            } else {
                if (preC != '0') {
                    sb.append(preCount).append(preC);
                }
                preC = c;
                preCount = 1;
            }
            if (i == pre.length() - 1) {
                sb.append(preCount).append(preC);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LeetCode0038 main = new LeetCode0038();
        System.out.println(main.countAndSay(5));
    }
}
