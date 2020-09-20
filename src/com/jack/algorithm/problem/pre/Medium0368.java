package com.jack.algorithm.problem.pre;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jack
 */
public class Medium0368 {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            for (int j = 0; j < i; j++) {
                List<Integer> curList = lists.get(j);
                int tail = curList.get(curList.size() - 1);
                if (num % tail == 0) {
                    curList.add(num);
                }
            }
            List<Integer> tmp = new ArrayList<>();
            tmp.add(num);
            lists.add(tmp);
        }
        List<Integer> res = null;
        int max = 0;
        for (List<Integer> list : lists) {
            if (list.size() > max) {
                res = list;
                max = list.size();
            }
        }
        return res;
    }

    public List<Integer> largestDivisibleSubset2(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            lists.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            List<Integer> tmp = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                if (num % nums[j] == 0
                        && tmp.size() < lists.get(j).size()) {
                    tmp = lists.get(j);
                }
            }
            lists.get(i).addAll(tmp);
            lists.get(i).add(num);
        }
        List<Integer> res = null;
        int max = 0;
        for (List<Integer> list : lists) {
            if (list.size() > max) {
                res = list;
                max = list.size();
            }
        }
        return res;
    }

    public List<Integer> largestDivisibleSubset3(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n];
        int max = 1;
        int maxIndex = 0;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int cur = 1;
            for (int j = 0; j < i; j++) {
                if (num % nums[j] == 0
                        && cur < dp[j]) {
                    cur = dp[j];
                }
            }
            dp[i] = cur + 1;
            if (dp[i] > max) {
                max = dp[i];
                maxIndex = i;
            }
        }
        LinkedList<Integer> res = new LinkedList<>();
        int curTail = nums[maxIndex];
        res.add(curTail);
        int count = dp[maxIndex] - 1;
        for (int i = maxIndex - 1; i >= 0; i--) {
            if (count == 0) {
                break;
            }
            if (curTail % nums[i] == 0) {
                res.addFirst(nums[i]);
                curTail = nums[i];
                count --;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Medium0368 main = new Medium0368();
        System.out.println(main.largestDivisibleSubset(
                new int[] {1, 2, 3}
        ));
        System.out.println(main.largestDivisibleSubset(
                new int[] {1, 2, 4, 8}
        ));
        System.out.println(main.largestDivisibleSubset2(
                new int[] {1, 2, 3}
        ));
        System.out.println(main.largestDivisibleSubset2(
                new int[] {1, 2, 4, 8}
        ));
        System.out.println(main.largestDivisibleSubset3(
                new int[] {1, 2, 3}
        ));
        System.out.println(main.largestDivisibleSubset3(
                new int[] {1, 2, 4, 8}
        ));
    }
}
