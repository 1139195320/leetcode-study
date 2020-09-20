package com.jack.algorithm.problem.midium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author jack
 * // 以数字集合 1, 2 和 3 初始化数组。
 * int[] nums = {1,2,3};
 * Solution solution = new Solution(nums);
 *
 * // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。
 * solution.shuffle();
 *
 * // 重设数组到它的初始状态[1,2,3]。
 * solution.reset();
 *
 * // 随机返回数组[1,2,3]打乱后的结果。
 * solution.shuffle();
 *
 */
public class LeetCode0384 {

    public static void main(String[] args) {
        Solution2 obj = new Solution2(new int[]{-6, 10, 64});
//        Solution obj = new Solution(new int[]{});
        System.out.println(Arrays.toString(obj.shuffle()));
        System.out.println(Arrays.toString(obj.reset()));
        System.out.println(Arrays.toString(obj.shuffle()));
        System.out.println(Arrays.toString(obj.reset()));
        System.out.println(Arrays.toString(obj.shuffle()));
    }
}

class Solution2 {
    private Random random = new Random();
    private int[] nums;
    private int[] defaultData;

    public Solution2(int[] nums) {
        this.nums = nums;
        defaultData = nums.clone();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        nums = defaultData;
        defaultData = defaultData.clone();
        return nums;
    }

    private void swapNums(int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for (int i = 0; i < nums.length; i++) {
            swapNums(i, random.nextInt(nums.length - i) + i);
        }
        return nums;
    }
}

class Solution {

    private int[] nums;
    private List<Integer> dataList = new ArrayList<>();
    private List<Integer> saveList = new ArrayList<>();
    public Solution(int[] nums) {
        this.nums = nums;
        for (int num : nums) {
            dataList.add(num);
        }
        saveList.addAll(dataList);
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = saveList.get(i);
        }
        return nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        Random random = new Random();
        int size = dataList.size();
        int i = 0;
        while (size > 0) {
            int tmpIndex = random.nextInt(size);
            nums[i ++] = dataList.get(tmpIndex);
            dataList.remove(tmpIndex);
            size --;
        }
        dataList = new ArrayList<>(saveList);
        return nums;
    }
}