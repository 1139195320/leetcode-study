package com.jack.algorithm.problem.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jack
 */
public class LeetCode0496 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>(nums2.length);
        for (int i = 0; i < nums2.length - 1; i++) {
            int cur = nums2[i];
            for (int j = i; j < nums2.length; j++) {
                int next = nums2[j];
                if (next > cur) {
                    map.put(cur, next);
                    break;
                }
            }
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.getOrDefault(nums1[i], -1);
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode0496 main = new LeetCode0496();
        System.out.println(Arrays.toString(main.nextGreaterElement(
                new int[] {4, 1, 2},
                new int[] {1, 3, 4, 2}
        )));
        System.out.println(Arrays.toString(main.nextGreaterElement(
                new int[] {2, 4},
                new int[] {1, 2, 3, 4}
        )));
    }
}
