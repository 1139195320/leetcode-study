package com.jack.algorithm.problem.midium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jack
 */
public class LeetCode0932 {
    public static void main(String[] args) {
        LeetCode0932 main = new LeetCode0932();
        System.out.println(Arrays.toString(main.beautifulArray(4)));
        System.out.println(Arrays.toString(main.beautifulArray(5)));
        System.out.println(Arrays.toString(main.beautifulArray(10)));
        main.printMono();
    }
    private void printMono() {
        for (Map.Entry<Integer, int[]> entry : mono.entrySet()) {
            System.out.println(entry.getKey() + " -> " + Arrays.toString(entry.getValue()));
        }
    }

    public int[] beautifulArray(int N) {
        mono = new HashMap<>();
        return f(N);
    }

    private Map<Integer, int[]> mono;
    private int[] f(int n) {
        if (mono.containsKey(n)) {
            return mono.get(n);
        }
        int [] res = new int[n];
        if (n == 1) {
            res[0] = 1;
        } else {
            int t = 0;
            // 奇数
            for (int i : f((n + 1) >> 1)) {
                res[t ++] = (i << 1) - 1;
            }
            // 偶数
            for (int i : f(n >> 1)) {
                res[t ++] = i << 1;
            }
        }
        System.out.println(n + " -> " +  Arrays.toString(res));
        mono.put(n, res);
        return res;
    }
}
