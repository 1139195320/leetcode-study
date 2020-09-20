package com.jack.algorithm.problem.midium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author fy
 */
public class LeetCode0055 {

    public boolean canJump(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return true;
        }
        List<Integer> toList = new ArrayList<>();
        toList.add(len - 1);
        List<Integer> newList = new ArrayList<>();
        boolean res = false;
        while (!res) {
            for (int i = 0; i < toList.get(toList.size() - 1) && !res; i++) {
                for (int toIndex : toList) {
                    if (nums[i] + i >= toIndex) {
                        // this num can to toIndex
                        if (i == 0) {
                            res = true;
                        }
                        newList.add(i);
                        break;
                    }
                }
            }
            if (newList.size() == 0) {
                break;
            }
            toList.clear();
            toList.addAll(newList);
            newList.clear();
        }
        return res;
    }

    public boolean canJump2(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return true;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        boolean res = false;
        while (!queue.isEmpty()) {
            int curIndex = queue.remove();
            int curNum = nums[curIndex];
            if (curIndex + curNum >= len - 1) {
                res = true;
                break;
            }
            for (int i = 1; i <= curNum; i++) {
                queue.add(curIndex + i);
            }
        }
        return res;
    }

    public boolean canJump3(int[] nums) {
        int maxToIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxToIndex) {
                // 从前面走不到这里
                return false;
            }
            maxToIndex = Math.max(maxToIndex, nums[i] + i);
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode0055 main = new LeetCode0055();
        System.out.println(main.canJump3(new int[]{2,3,1,1,4}));
        System.out.println(main.canJump3(new int[]{3,2,1,0,4}));
    }
}
