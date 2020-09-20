package com.jack.algorithm.problem.pre;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jack
 */
public class Medium11705 {

    public String[] findLongestSubarray(String[] array) {
        int n = array.length;
        int[] memo = new int[n];
        for (int i = 0; i < n; i++) {
            if (array[i].compareTo("0") > 0
                    && array[i].compareTo("9") < 0) {
                memo[i] = 1;
            } else {
                memo[i] = -1;
            }
        }
        int[] prefixSum = new int[n];
        prefixSum[0] = memo[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + memo[i];
        }
        // 找出前缀和数组中相等且距离最远的目标
        int max = 0;
        int tl = 0;
        int tr = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int cur = prefixSum[i];
            Integer val = map.get(cur);
            if (val != null) {
                int count = i - val + 1;
                if (count > max) {
                    max = count;
                    tl = val;
                    tr = i;
                }
            } else {
                map.put(cur, i);
            }
        }
        return Arrays.copyOfRange(array, tl, tr);
    }

    public static void main(String[] args) {
        Medium11705 main = new Medium11705();
        System.out.println(Arrays.toString(main.findLongestSubarray(
                new String[]{"A", "1", "B", "C", "D", "2", "3", "4", "E", "5",
                        "F", "G", "6", "7", "H", "I", "J", "K", "L", "M"}
        )));
        System.out.println(Arrays.toString(main.findLongestSubarray(
                new String[]{"A", "1", "A", "B", "C", "D"}
        )));
    }
}