package com.jack.algorithm.problem.midium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jack
 */
public class LeetCode0216 {

    private int k;
    private int target;
    private List<List<Integer>> res;
    public List<List<Integer>> combinationSum3(int k, int n) {
        res = new ArrayList<>();
        this.k = k;
        this.target = n;
        backtrace(0, new ArrayList<>(), 1);
        return res;
    }
    private void backtrace(int curSum, List<Integer> curList, int start) {
        if (start > 9 || curList.size() == k) {
            if (curList.size() == k && curSum == target) {
                res.add(new ArrayList<>(curList));
            }
            return;
        }
        for (int i = start; i <= 9; i++) {
            if (curSum + i > target) {
                break;
            }
            curList.add(i);
            backtrace(curSum + i, curList, i + 1);
            curList.remove(curList.size() - 1);
        }
    }

    public static void main(String[] args) {
        LeetCode0216 main = new LeetCode0216();
        System.out.println(main.combinationSum3(3, 7));
        System.out.println(main.combinationSum3(3, 9));
    }
}