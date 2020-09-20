package com.jack.algorithm.problem.pre;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jack
 */
public class Medium0228 {

    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        int i = 0;
        int n = nums.length;
        while (i < n) {
            int start = nums[i];
            int end = start;
            int j = i + 1;
            while (j < n && nums[j] == nums[j - 1] + 1) {
                end = nums[j];
                j ++;
            }
            res.add(start == end ? String.valueOf(start) : start + "->" + end);
            i = j;
        }
        return res;
    }

    public static void main(String[] args) {
        Medium0228 main = new Medium0228();
        System.out.println(main.summaryRanges(
                new int[]{0, 1, 2, 4, 5, 7}
        ));
        System.out.println(main.summaryRanges(
                new int[]{0, 2, 3, 4, 6, 8, 9}
        ));
    }
}