package com.jack.algorithm.problem.midium;

/**
 * @author jack
 */
public class LeetCode0043 {

    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        int carry = 0;
        int len1 = num1.length();
        int len2 = num2.length();
        if (len1 < len2) {
            String strTmp = num1;
            num1 = num2;
            num2 = strTmp;
            int intTmp = len1;
            len1 = len2;
            len2 = intTmp;

        }
        StringBuilder sb = new StringBuilder(len1 + len2);
        int m = 1;
        int count = len1 + len2 - 1;
        while (m <= count) {
            int cur = carry;
            int k = 0;
            int tmp = m;
            if (m > len1) {
                tmp = len1;
                k = m - len1;
            }
            for (; k < tmp; k++) {
                int i = len1 - 1 - k;
                int j = len2 - 1 - (m - k - 1);
                if (j < 0 || j > len2 - 1) {
                    continue;
                }
                cur += (num1.charAt(i) - '0')
                        * (num2.charAt(j) - '0');
            }
            sb.insert(0, cur % 10);
            carry = cur / 10;
            m ++;
        }
        if (carry > 0) {
            sb.insert(0, carry);
        }
        return sb.toString();
    }

    public String multiply2(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        int carry = 0;
        // 较长者
        int len1 = num1.length();
        // 较短者
        int len2 = num2.length();
        if (len1 < len2) {
            String strTmp = num1;
            num1 = num2;
            num2 = strTmp;
            int intTmp = len1;
            len1 = len2;
            len2 = intTmp;
        }
        int n = len1 + len2;
        StringBuilder sb = new StringBuilder(n);
        int index = 1;
        while (index < n) {
            int cur = carry;
            for (int i = Math.min(index, len1); i >= 1; i --) {
                int j = index + 1 - i;
                if (j > len2) {
                    break;
                }
                cur += (num1.charAt(len1 - i) - '0')
                        * (num2.charAt(len2 - j) - '0');
            }
            sb.insert(0, cur % 10);
            carry = cur / 10;
            index ++;
        }
        if (carry > 0) {
            sb.insert(0, carry);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LeetCode0043 main = new LeetCode0043();
        System.out.println(main.multiply("2", "3"));
        System.out.println(main.multiply("123", "456"));
        System.out.println(main.multiply("123", "4567"));
        System.out.println(main.multiply("123456789", "45678912345678912345678900"));
    }
}