package com.jack.algorithm.problem.easy;

/**
 * @author jack
 */
public class LeetCode0067 {

    public String addBinary(String a, String b) {
        if (a.length() == 0 || "0".equals(a)) {
            return b;
        }
        if (b.length() == 0 || "0".equals(b)) {
            return a;
        }
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int lenA = a.length();
        int lenB = b.length();
        int i = lenA - 1;
        int j = lenB - 1;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) {
                sum += (a.charAt(i) - '0');
                i --;
            }
            if (j >= 0) {
                sum += (b.charAt(j) - '0');
                j --;
            }
            switch (sum) {
                case 0 :
                    sb.insert(0, "0");
                    carry = 0;
                    break;
                case 1 :
                    sb.insert(0, "1");
                    carry = 0;
                    break;
                case 2 :
                    sb.insert(0, "0");
                    carry = 1;
                    break;
                case 3 :
                    sb.insert(0, "1");
                    carry = 1;
                    break;
                default: break;
            }
        }
        if (carry == 1) {
            sb.insert(0, "1");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LeetCode0067 main = new LeetCode0067();
        System.out.println(main.addBinary("10", "1011"));
        System.out.println(main.addBinary("1010", "1011"));
    }
}