package com.jack.algorithm.problem.pre;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jack
 */
public class Medium0526 {

    private int[] arr;
    private List<List<Integer>> res;
    private boolean[] visited;
    public int countArrangement(int N) {
        visited = new boolean[N + 1];
        arr = new int[N + 1];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = i;
        }
        res = new ArrayList<>();
        dfs(new ArrayList<>());
        System.out.println(res);
        return res.size();
    }
    private void dfs(List<Integer> curList) {
        if (curList.size() == arr.length - 1) {
            res.add(new ArrayList<>(curList));
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            if (visited[i]) {
                continue;
            }
            int cur = arr[i];
            int index = curList.size() + 1;
            if (cur % index != 0 && index % cur != 0) {
                continue;
            }
            visited[i] = true;
            curList.add(cur);
            dfs(curList);
            curList.remove(curList.size() - 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        Medium0526 main = new Medium0526();
        System.out.println(main.countArrangement(8));
    }
}