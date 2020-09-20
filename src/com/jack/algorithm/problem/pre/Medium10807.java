package com.jack.algorithm.problem.pre;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jack
 */
public class Medium10807 {

    private List<String> res;
    private boolean[] visited;
    public String[] permutation(String S) {
        char[] arr = S.toCharArray();
        visited = new boolean[arr.length];
        res = new ArrayList<>();
        // 此时已是排序数组
        dfs(arr, "");
        String[] resArr = new String[res.size()];
        for (int i = 0; i < res.size(); i++) {
            resArr[i] = res.get(i);
        }
        return resArr;
    }

    private void dfs(char[] arr, String pre) {
        if (pre.length() == arr.length) {
            res.add(pre);
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            dfs(arr, pre + arr[i]);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        Medium10807 main = new Medium10807();
        System.out.println(Arrays.toString(
                main.permutation("abc")
        ));
    }
}