package com.jack.algorithm.problem.midium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jack
 */
public class LeetCode0077 {

    private List<List<Integer>> res;
    private int k;
    public List<List<Integer>> combine(int n, int k) {
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        this.k = k;
        res = new ArrayList<>();
        // 此时已是排序数组
        dfs(arr, new ArrayList<>(), 0);
        return res;
    }

    private void dfs(int[] arr, List<Integer> curList, int start) {
        if (curList.size() == k) {
            res.add(new ArrayList<>(curList));
            return;
        }
        for (int i = start; i < arr.length; i++) {
            curList.add(arr[i]);
            dfs(arr, curList, i + 1);
            curList.remove(curList.size() - 1);
        }
    }

    public static void main(String[] args) {
        LeetCode0077 main = new LeetCode0077();
        System.out.println(main.combine(4, 2));
    }
}