package com.jack.algorithm.problem.pre;

import java.util.Arrays;
import java.util.List;

/**
 * @author jack
 */
public class Medium1239 {

    private int res;
    public int maxLength(List<String> arr) {
        res = 0;
        dfs(arr, 0, "");
        return res;
    }
    private void dfs(List<String> arr, int start, String curStr) {
        for (int i = start; i < arr.size(); i++) {
            String next = arr.get(i);
            boolean flag = true;
            if (curStr.length() > 0){
                for (char c : next.toCharArray()) {
                    if (curStr.indexOf(c) != -1) {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) {
                dfs(arr, i + 1, curStr + next);
            }
        }
        res = Math.max(res, curStr.length());
    }

    public static void main(String[] args) {
        Medium1239 main = new Medium1239();
        System.out.println(main.maxLength(Arrays.asList(
                "cha","r","act","ers")));
    }
}