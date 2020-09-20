package com.jack.algorithm.problem.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author jack
 */
public class LeetCode000402 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        int n = 0;
        if (nums1 != null && nums1.length > 0) {
            n += nums1.length;
            for (int num : nums1) {
                list.add(num);
            }
        }
        if (nums2 != null && nums2.length > 0) {
            n += nums2.length;
            for (int num : nums2) {
                list.add(num);
            }
        }
        Collections.sort(list);
        double res;
        int val2 = 2;
        int k = n / val2;
        if (n % val2 == 0) {
            res = (list.get(k) + list.get(k - 1)) / 2.0;
        } else {
            res = list.get(k) * 1.0;
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode000402 main = new LeetCode000402();
        System.out.println(main.findMedianSortedArrays(
                new int[]{1, 3},
                new int[]{2}));
        System.out.println(main.findMedianSortedArrays(
                new int[]{1, 2},
                new int[]{3, 4}));
    }
}
