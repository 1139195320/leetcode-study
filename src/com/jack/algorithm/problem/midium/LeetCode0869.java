package com.jack.algorithm.problem.midium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jack
 */
public class LeetCode0869 {

    public boolean reorderedPowerOf2(int n) {
        List<int[]> list = new ArrayList<>();
        int maxPower = 31;
        for (int i = 0; i <= maxPower; i++) {
            list.add(numToArr(1 << i));
        }
        int[] arr = numToArr(n);
        for (int[] curArr : list) {
            byte flag = 1;
            for (int i = 0; i < arr.length; i++) {
                if (curArr[i] != arr[i]) {
                    flag = 0;
                    break;
                }
            }
            if (flag == 1) {
                return true;
            }
        }
        return false;
    }
    private int[] numToArr(int n) {
        int[] arr = new int[10];
        while (n > 0) {
            arr[n % 10] ++;
            n /= 10;
        }
        return arr;
    }
}
