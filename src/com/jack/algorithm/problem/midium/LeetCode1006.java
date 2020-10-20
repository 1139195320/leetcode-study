package com.jack.algorithm.problem.midium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jack
 */
public class LeetCode1006 {

    public int clumsy(int n) {
        // 从左到右依次 + - + - ...
        Queue<Integer> queue = new LinkedList<>();
        while (n > 0) {
            int cur = n;
            n --;
            if (n > 0) {
                cur *= n;
            }
            n --;
            if (n > 0) {
                cur /= n;
            }
            queue.add(cur);
            n --;
            if (n > 0) {
                queue.add(n);
            }
            n --;
        }
        // because 1 <= N <= 10000
        int res = queue.remove();
        int size = queue.size();
        byte flag = 0;
        for (int i = 0; i < size; i++) {
            if (flag == 0) {
                res += queue.remove();
            } else {
                res -= queue.remove();
            }
            flag ^= 1;
        }
        return res;
    }

    public int clumsy2(int n) {
        // 找规律
        int[] arr1 = {1, 2, 6, 7};
        if (n <= arr1.length) {
            return arr1[n - 1];
        }
        // n + 2 5 9
        // n + 2 6 10
        // n - 1 7 11
        // n + 1 8 12
        int[] arr2 = {2, 2, -1, 1};
        return n + arr2[(n + 3) % 4];
    }
}
