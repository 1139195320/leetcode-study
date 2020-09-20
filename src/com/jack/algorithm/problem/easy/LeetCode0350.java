package com.jack.algorithm.problem.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jack
 */
public class LeetCode0350 {

    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list1 = new ArrayList<>();
        for (int num : nums1) {
            list1.add(num);
        }
        List<Integer> list = new ArrayList<>();
        for (Integer num : nums2) {
            if (list1.contains(num)) {
                list.add(num);
                list1.remove(num);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public int[] intersect2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        // 若已排好序
        int i = 0;
        int j = 0;
        List<Integer> list = new ArrayList<>();
        while (i < nums1.length && j < nums2.length) {
            int cur1 = nums1[i];
            int cur2 = nums2[j];
            if (cur1 == cur2) {
                list.add(cur1);
                i ++;
                j ++;
            }
            else if (cur1 < cur2) {
                i ++;
            }
            else {
                j ++;
            }
        }
        int[] res = new int[list.size()];
        for (int k = 0; k < res.length; k++) {
            res[k] = list.get(k);
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode0350 main = new LeetCode0350();
        System.out.println(Arrays.toString(
                main.intersect(
                        new int[]{1, 2, 2, 1},
                        new int[]{2, 2}
                )
        ));
        System.out.println(Arrays.toString(
                main.intersect(
                        new int[]{4, 9, 5},
                        new int[]{9, 4, 9, 8, 4}
                )
        ));
        System.out.println(Arrays.toString(
                main.intersect2(
                        new int[]{4, 5, 9},
                        new int[]{4, 4, 8, 9, 9}
                )
        ));
    }
}