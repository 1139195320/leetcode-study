package com.jack.algorithm.problem.easy;

/**
 * @author jack
 */
public class LeetCode0415 {

    public String addStrings(String num1, String num2) {
        int n1 = num1.length();
        int n2 = num2.length();
        if (n1 == 0 || "0".equals(num1)) {
            return num2;
        }
        if (n2 == 0 || "0".equals(num2)) {
            return num1;
        }
        int i = n1 - 1;
        int j = n2 - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder(Math.max(n1, n2));
        while (i >= 0 && j >= 0) {
            int cur = carry
                    + (num1.charAt(i --) - '0')
                    + (num2.charAt(j --) - '0');
            carry = cur > 9 ? 1 : 0;
            sb.insert(0, cur % 10);
        }
        if (i >= 0) {
            while (i >= 0 && carry != 0) {
                int cur = carry
                        + (num1.charAt(i --) - '0');
                carry = cur > 9 ? 1 : 0;
                sb.insert(0, cur % 10);
            }
            if (i >= 0) {
                sb.insert(0, num1.substring(0, i + 1));
            }
        }
        else if (j >= 0) {
            while (j >= 0 && carry != 0) {
                int cur = carry
                        + (num2.charAt(j --) - '0');
                carry = cur > 9 ? 1 : 0;
                sb.insert(0, cur % 10);
            }
            if (j >= 0) {
                sb.insert(0, num2.substring(0, j + 1));
            }
        }
        else if (carry > 0){
            sb.insert(0, carry);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LeetCode0415 main = new LeetCode0415();
        System.out.println(main.addStrings("63", "3456"));
    }
}