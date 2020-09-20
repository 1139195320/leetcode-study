package com.jack.algorithm.problem.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author fy
 */
public class LeetCode0004 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        if (nums1 != null) {
            for (int i : nums1) {
                list.add(i);
            }
        }
        if (nums2 != null) {
            for (int i : nums2) {
                list.add(i);
            }
        }
        Collections.sort(list);
        int size = list.size();
        double res;
        if (size % 2 == 0) {
            int r = size / 2;
            int l = r - 1;
            res = (list.get(l) + list.get(r)) / 2.0;
        } else {
            int m = size / 2;
            res = list.get(m) * 1.0;
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode0004 main =  new LeetCode0004();
        System.out.println(main.findMedianSortedArrays(
                new int[]{1, 2}, new int[]{3, 4}));
        System.out.println(main.findMedianSortedArrays(
                new int[]{1, 3}, new int[]{2}));
    }
}
