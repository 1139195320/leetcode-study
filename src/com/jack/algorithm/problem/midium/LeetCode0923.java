package com.jack.algorithm.problem.midium;

import java.util.*;

/**
 * @author jack
 */
public class LeetCode0923 {

    /**
     * 映射：数 -> 个数
     **/
    private Map<Integer, Integer> map;
    /**
     * 不重复的符合的组合数
     **/
    private List<List<Integer>> lists;
    private int MOD = 1_000_000_007;
    private void dfs(List<Integer> data,
                     int target,
                     int start,
                     int preSum,
                     List<Integer> curList) {
        if (curList.size() == 3) {
            if (preSum == target) {
                // 按要求需要是三个数相加
                lists.add(new ArrayList<>(curList));
            }
            return;
        }
        for (int i = start; i < data.size(); i++) {
            int cur = data.get(i);
            if (preSum + cur > target) {
                continue;
            }
            curList.add(cur);
            dfs(data, target, i, preSum + cur, curList);
            curList.remove(curList.size() - 1);
        }
    }
    /**
     * 计算阶乘
     **/
    private int calcFactorial(int m) {
        int product = 1;
        while (m > 1) {
            product *= m;
            m --;
        }
        return product;
    }
    private int calc(int n, int k) {
        if (k == 0 || k > n) {
            return 0;
        }
        long product = 1;
        k = Math.min(k, n - k);
        int divisor = calcFactorial(k);
        boolean flag = false;
        while (k > 0) {
            if (!flag && product % divisor == 0) {
                product /= divisor;
                flag = true;
            }
            product *= n;
            product %= MOD;
            n --;
            k --;
        }
        if (!flag) {
            product /= divisor;
        }
        return (int) product;
    }
    private int res = 0;
    private void checkWay(List<Integer> list) {
        Map<Integer, Integer> curMap = new HashMap<>(list.size());
        for (int a : list) {
            curMap.put(a, curMap.getOrDefault(a, 0) + 1);
        }
        int count = 1;
        for (Map.Entry<Integer, Integer> entry : curMap.entrySet()) {
            int num = entry.getKey();
            count *= calc(map.get(num), entry.getValue());
            count %= MOD;
        }
        res += count;
        res %= MOD;
    }
    public int threeSumMulti(int[] A, int target) {
        if (A == null || A.length < 3) {
            return 0;
        }
        Arrays.sort(A);
        map = new HashMap<>(A.length);
        lists = new ArrayList<>();
        for (int a : A) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        // 适用于已排序
        dfs(new ArrayList<>(map.keySet()), target,
                0, 0, new ArrayList<>());
        for (List<Integer> list : lists) {
            checkWay(list);
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode0923 main = new LeetCode0923();
//        System.out.println(main.calc(3000, 3));
//        System.out.println(main.threeSumMulti(
//                new int[]{1, 1, 2, 2, 3, 3, 4, 4, 5, 5}, 8
//        ));
//        System.out.println(main.threeSumMulti(
//                new int[]{0, 0, 0}, 0
//        ));
//        System.out.println(main.threeSumMulti(
//                new int[]{1, 1, 2, 2, 2, 2}, 5
//        ));
        System.out.println(main.threeSumMulti(
                new int[]{18, 73, 19, 19, 55, 88, 6, 34, 21, 75},
                58
        ));
    }
}