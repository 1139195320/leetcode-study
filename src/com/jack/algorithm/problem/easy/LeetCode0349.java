package com.jack.algorithm.problem.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jack
 */
public class LeetCode0349 {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }
        Set<Integer> resSet = new HashSet<>();
        for (int num : nums2) {
            if (set.contains(num)) {
                resSet.add(num);
            }
        }
        int[] res = new int[resSet.size()];
        int i = 0;
        for (int data : resSet) {
            res[i ++] = data;
        }
        return res;
    }

    public int[] intersection2(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        Set<Integer> set2 = new HashSet<>();
        for (int num : nums2) {
            set2.add(num);
        }
        set1.retainAll(set2);
        int[] res = new int[set1.size()];
        int i = 0;
        for (int data : set1) {
            res[i ++] = data;
        }
        return res;
    }
}