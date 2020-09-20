package com.jack.algorithm.problem.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jack
 */
public class LeetCode0679 {

    public boolean judgePoint24(int[] nums) {
        int n = nums.length;
        target = 24;
        double[] arr = new double[n];
        List<Double> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr[i] = 1.0 * nums[i];
            list.add(arr[i]);
        }
        return cal(list);
    }
    private double maxDiff = 0.000_001;
    private int target;
    private boolean cal(List<Double> list) {
        int n = list.size();
        if (n == 0) {
            return false;
        }
        if (n == 1) {
            return Math.abs(list.get(0) - target) < maxDiff;
        }
        if (n == 2) {
            return check(list.get(0), list.get(1));
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                // 合并两个数
                List<Double> curList = new ArrayList<>();
                for (int k = 0; k < n; k++) {
                    if (k != i && k != j) {
                        curList.add(list.get(k));
                    }
                }
                for (Double tmp : cal(list.get(i), list.get(j))) {
                    curList.add(tmp);
                    if (cal(curList)) {
                        return true;
                    }
                    curList.remove(curList.size() - 1);
                }
            }
        }
        return false;
    }
    private List<Double> cal(double a, double b) {
        return Arrays.asList(a + b, a - b, a * b, a / b);
    }
    private boolean check(double a, double b) {
        if (Math.abs(a + b - target) < maxDiff) {
            return true;
        }
        if (Math.abs(a - b - target) < maxDiff) {
            return true;
        }
        if (Math.abs(a * b - target) < maxDiff) {
            return true;
        }
        return Math.abs(a / b - target) < maxDiff;
    }

    public static void main(String[] args) {
        LeetCode0679 main = new LeetCode0679();
        System.out.println(main.judgePoint24(
                new int[]{1, 2, 3, 4}
        ));
        System.out.println(main.judgePoint24(
                new int[]{4, 1, 8, 7}
        ));
        System.out.println(main.judgePoint24(
                new int[]{1, 2, 1, 2}
        ));
    }
}
