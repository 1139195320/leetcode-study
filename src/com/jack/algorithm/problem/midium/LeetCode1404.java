package com.jack.algorithm.problem.midium;

/**
 * @author jack
 */
public class LeetCode1404 {

    public int numSteps(String s) {
        int res = 0;
        int n = s.length();
        int one = '1';
        char[] arr = s.toCharArray();
        for (int i = n - 1; i >= 1; i--) {
            char c = arr[i];
            if (c == '0') {
                // >>1
                // step * 1
                res ++;
            } else if (c == one) {
                // +1 >>1
                // step * 2
                arr[i - 1] ++;
                res += 2;
            } else {
                // c == '2'
                // >>1
                // step * 1
                arr[i - 1] ++;
                res ++;
            }
        }
        if (arr[0] != one) {
            res ++;
        }
        return res;
    }
}
