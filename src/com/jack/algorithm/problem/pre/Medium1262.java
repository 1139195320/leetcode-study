package com.jack.algorithm.problem.pre;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author jack
 */
public class Medium1262 {

    public int maxSumDivThree(int[] nums) {
        Arrays.sort(nums);
        // 余1 余2
        ArrayList<Integer>[] dataArr = new ArrayList[2];
        for (int i = 0; i < dataArr.length; i++) {
            dataArr[i] = new ArrayList();
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
            int mod = num % 3;
            if (mod == 1) {
                dataArr[0].add(num);
            } else if (mod == 2) {
                dataArr[1].add(num);
            }
        }
        int mod = sum % 3;
        if (mod == 1) {
            if (dataArr[0].size() == 0) {
                return 0;
            } else {
                sum -= dataArr[0].get(0);
            }
        } else if (mod == 2) {
            if (dataArr[0].size() < 2 && dataArr[1].size() == 0) {
                return 0;
            } else {
                int one = Integer.MAX_VALUE;
                int two = Integer.MAX_VALUE;
                if (dataArr[0].size() >= 2) {
                    one = dataArr[0].get(0) + dataArr[0].get(1);
                }
                if (dataArr[1].size() > 0) {
                    two = dataArr[1].get(0);
                }
                sum -= Math.min(one, two);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Medium1262 main = new Medium1262();
        System.out.println(main.maxSumDivThree(
                new int[]{3, 6, 5, 1, 8}
        ));
        System.out.println(main.maxSumDivThree(
                new int[]{4}
        ));
        System.out.println(main.maxSumDivThree(
                new int[]{1, 2, 3, 4, 4}
        ));
    }
}