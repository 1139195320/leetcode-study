package com.jack.algorithm.problem.midium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jack
 */
public class LeetCode1296 {

    public boolean isPossibleDivide(int[] nums, int k) {
        if (k == 1) {
            return true;
        }
        Arrays.sort(nums);
        List<List<Integer>> allList = new ArrayList<>();
        int pos = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (pos == 0 || num == nums[i - 1]){
                // 位置回到了第 0 位，或当前数和前一个数相等
                if (allList.size() <= pos) {
                    allList.add(new ArrayList<>());
                    allList.get(allList.size() - 1).add(num);
                }
                else {
                    allList.get(pos).add(num);
                }
                pos ++;
            } else if (num == nums[i - 1] + 1) {
                // 当前数与前一个数连续
                List<Integer> tailList = allList.get(allList.size() - 1);
                if (tailList.size() > 0) {
                    // 防止此情况：1, 1, 1, 2, 2, 3, 3, 3, 4, 4, 5, 6
                    // 123 123 134 456
                    if (tailList.get(tailList.size() - 1) + 1 != num) {
                        return false;
                    }
                }
                allList.get(0).add(num);
                pos = 1;
            } else {
                return false;
            }
            if (allList.get(0).size() == k) {
                // 切割
                allList.remove(0);
                pos = 0;
            }
        }
        // 全部都是 k 大小，没有剩余
        return allList.size() == 0;
    }

    public boolean isPossibleDivide2(int[] nums, int k) {
        if (nums.length % k != 0) {
            return false;
        }
        int[] tmp = new int[k];
        for (int num : nums) {
            tmp[num % k] ++;
        }
        for (int i = 1; i < k; i++) {
            if (tmp[i] != tmp[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode1296 main = new LeetCode1296();
        System.out.println(main.isPossibleDivide(
                new int[]{16,5,15,15,20,16,20,14,21,20,19,20,12,17,13,15,11,17,18,18,11,13,13,14,14,9,20,18,10,4,4,6,15,19,8,15,7,17,15,9,24,2,23,22,26,8,21,22,14,13,16,2,25,23,17,19,17,3,22,23,19,12,21,12,16,27,28,10,13,8,24,3,22,6,10,9,14,7,11,22,11,5,16,19,21,2,8,24,16,21,7,29,18,9,10,18,6,17,21,20}, 10
        ));
        System.out.println(main.isPossibleDivide(
                new int[]{1, 2, 3, 3, 4, 4, 5, 6}, 4
        ));
        System.out.println(main.isPossibleDivide(
                new int[]{1, 2, 3, 7, 8, 9}, 3
        ));
        System.out.println(main.isPossibleDivide(
                new int[]{3, 3, 2, 2, 1, 1}, 3
        ));
        System.out.println(main.isPossibleDivide(
                new int[]{3, 2, 1, 2, 3, 4, 3, 4, 5, 9, 10, 11}, 3
        ));
        System.out.println(main.isPossibleDivide(
                new int[]{1, 2, 3, 4}, 3
        ));
    }
}