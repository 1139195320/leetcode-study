package com.jack.algorithm.problem.easy;

/**
 * @author jack
 */
public class LeetCode0405 {

    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        char[] arr = "0123456789abcdef".toCharArray();
        while (num != 0) {
            int tmp = num & 15;
            sb.insert(0, arr[tmp]);
            num >>>= 4;
        }
        return sb.toString();
    }
}
