package com.jack.algorithm.problem.pre;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author jack
 */
public class Medium10808 {

    private Set<String> res;
    private boolean[] visited;
    public String[] permutation(String S) {
        char[] arr = S.toCharArray();
        visited = new boolean[arr.length];
        res = new HashSet<>();
        dfs(arr, "");
        String[] resArr = new String[res.size()];
        int i = 0;
        for (String data : res) {
            resArr[i ++] = data;
        }
        return resArr;
    }

    private void dfs(char[] arr, String curStr) {
        if (curStr.length() == arr.length) {
            res.add(curStr);
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            dfs(arr, curStr + arr[i]);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        Medium10808 main = new Medium10808();
        System.out.println(Arrays.toString(
                main.permutation("aab")
        ));
        System.out.println(Arrays.toString(
                main.permutation("aba")
        ));
        System.out.println(Arrays.toString(
                main.permutation("abc")
        ));
    }
}