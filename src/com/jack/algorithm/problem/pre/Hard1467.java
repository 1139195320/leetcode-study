package com.jack.algorithm.problem.pre;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jack
 */
public class Hard1467 {

    private BigDecimal count;
    private int n;
    private int scale;
    private int roundingMode;
    public double getProbability(int[] balls) {
        count = new BigDecimal(0);
        n = balls.length;
        scale = 5;
        roundingMode = BigDecimal.ROUND_HALF_UP;
        dfs(balls, new HashMap<>(n), new HashMap<>(n), 0);
        BigDecimal res = count.divide(calc(balls), scale, roundingMode);
        return res.doubleValue();
    }
    private void dfs(int[] balls, Map<Integer, Integer> ballA,
                     Map<Integer, Integer> ballB, int cur) {
        if (cur == n) {
            if (ballA.size() == ballB.size()) {
                int sum1 = 0;
                for (Map.Entry<Integer, Integer> entry : ballA.entrySet()) {
                    sum1 += entry.getValue();
                }
                int sum2 = 0;
                for (Map.Entry<Integer, Integer> entry : ballB.entrySet()) {
                    sum2 += entry.getValue();
                }
                if (sum1 == sum2) {
                    count  = count.add(calc(ballA).multiply(calc(ballB)));
                }
            }
            return;
        }
        for (int i = 0; i <= balls[cur]; i++) {
            ballA.put(cur, i);
            ballB.put(cur, balls[cur] - i);
            if (ballA.get(cur) == 0) {
                ballA.remove(cur);
            }
            if (ballB.get(cur) == 0) {
                ballB.remove(cur);
            }
            dfs(balls, ballA, ballB, cur + 1);
        }
    }
    private BigDecimal calc(Map<Integer, Integer> map) {
        int sum = 0;
        BigDecimal bi = new BigDecimal(1);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            sum += entry.getValue();
            bi = bi.multiply(calc(entry.getValue()));
        }
        return calc(sum).divide(bi, scale, roundingMode);
    }
    private BigDecimal calc(int[] nums) {
        int sum = 0;
        BigDecimal bi = new BigDecimal(1);
        for (int num : nums) {
            sum += num;
            bi = bi.multiply(calc(num));
        }
        return calc(sum).divide(bi, scale, roundingMode);
    }
    private BigDecimal calc(int n) {
        BigDecimal bi = new BigDecimal(1);
        BigDecimal bi1 = new BigDecimal(1);
        // 求阶乘
        BigDecimal tmp = new BigDecimal(n);
        while (n > 1){
            bi = bi.multiply(tmp);
            tmp = tmp.subtract(bi1);
            n --;
        }
        return bi;
    }

    public static void main(String[] args) {
        Hard1467 main = new Hard1467();
        System.out.println(main.getProbability(new int[]{1, 1}));
        System.out.println(main.getProbability(new int[]{2, 1, 1}));
        System.out.println(main.getProbability(new int[]{1, 2, 1, 2}));
        System.out.println(main.getProbability(new int[]{3, 2, 1}));
        System.out.println(main.getProbability(new int[]{6, 6, 6, 6, 6, 6}));
    }
}