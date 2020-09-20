package com.jack.algorithm.problem.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author jack
 */
public class LeetCode0401 {

    private Set<String> res;
    private boolean[] visited;
    private int[] arr;
    private int k;
    public List<String> readBinaryWatch(int num) {
        arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        visited = new boolean[arr.length];
        k = num;
        res = new HashSet<>();
        dfs(new ArrayList<>(), new int[2]);
        return new ArrayList<>(res);
    }

    private void dfs(List<Integer> curList, int[] pre) {
        if (curList.size() == k) {
            res.add(pre[0] + ":" + (pre[1] > 9 ? pre[1] : "0" + pre[1]));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (i < 4) {
                // hour
                int cur = 1 << i;
                if (pre[0] + cur > 11) {
                    continue;
                }
                pre[0] += cur;
                visited[i] = true;
                curList.add(i);
                dfs(curList, pre);
                curList.remove(curList.size() - 1);
                visited[i] = false;
                pre[0] -= cur;
            } else {
                // minute
                int cur = 1 << (i - 4);
                if (pre[1] + cur > 59) {
                    continue;
                }
                pre[1] += cur;
                visited[i] = true;
                curList.add(i);
                dfs(curList, pre);
                curList.remove(curList.size() - 1);
                visited[i] = false;
                pre[1] -= cur;
            }
        }
    }

    public static void main(String[] args) {
        LeetCode0401 main = new LeetCode0401();
        System.out.println(main.readBinaryWatch(1));
    }
}