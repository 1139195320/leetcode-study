package com.jack.algorithm.problem.midium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jack
 */
public class LeetCode0060 {

    private int indexK;
    private String res;
    private boolean[] visited;
    private int k;
    private boolean find;
    public String getPermutation(int n, int k) {
        this.indexK = 0;
        this.k = k;
        this.find = false;
        this.visited = new boolean[n];
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        res = "";
        // 此时已是排序数组
        dfs(arr, new ArrayList<>());
        return res;
    }
    private void dfs(int[] arr, List<Integer> curList) {
        if (curList.size() == arr.length) {
            indexK ++;
            if (indexK == k) {
                find = true;
                int num = 0;
                for (int i : curList) {
                    num = num * 10 + i;
                }
                res = num + "";
            }
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (find) {
                break;
            }
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            curList.add(arr[i]);
            dfs(arr, curList);
            curList.remove(curList.size() - 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        LeetCode0060 main = new LeetCode0060();
        System.out.println(main.getPermutation(4, 9));
    }
}