package com.jack.algorithm.problem.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jack
 */
public class LeetCode0167 {

    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        if (n <= 1) {
            return new int[]{};
        }
        int i = 0;
        int j = n - 1;
        while (i < j) {
            int l = numbers[i];
            int r = numbers[j];
            if (l + r < target) {
                i ++;
            }
            else if (l + r > target) {
                j --;
            }
            else {
                break;
            }
        }
        return new int[] {i + 1, j + 1};
    }

    public int[] twoSum2(int[] numbers, int target) {
        int n = numbers.length;
        if (n <= 1) {
            return new int[]{};
        }
        Map<Integer, Integer> map = new HashMap<>(n);
        int l = 0;
        int r = n - 1;
        for (int i = 0; i < numbers.length; i++) {
            int cur = numbers[i];
            if (map.containsKey(target - cur)
                    && i + 1 != map.get(target - cur)) {
                r = i + 1;
                l = map.get(target - cur);
                break;
            }
            if (!map.containsKey(cur)) {
                map.put(cur, i + 1);
            }
        }
        return new int[] {l, r};
    }

    public static void main(String[] args) {
        LeetCode0167 main = new LeetCode0167();
        System.out.println(Arrays.toString(main.twoSum(
                new int[]{2, 7, 11, 15}, 9
        )));
        System.out.println(Arrays.toString(main.twoSum2(
                new int[]{2, 7, 11, 15}, 9
        )));
    }
}