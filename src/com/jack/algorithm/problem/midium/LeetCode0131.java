package com.jack.algorithm.problem.midium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jack
 */
public class LeetCode0131 {

    private boolean isPalindrome(String target) {
        int l = 0;
        int r = target.length() - 1;
        while (l < r) {
            if (target.charAt(l) != target.charAt(r)) {
                return false;
            }
            l ++;
            r --;
        }
        return true;
    }
    private void dfs(String s,int start, List<String> curList){
        if (start == s.length()) {
            res.add(new ArrayList<>(curList));
            return;
        }
        for (int i = start + 1; i <= s.length(); i++) {
            String cur = s.substring(start, i);
            if (isPalindrome(cur)) {
                curList.add(cur);
                dfs(s, i, curList);
                curList.remove(curList.size() - 1);
            }
        }
    }
    private List<List<String>> res;
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        dfs(s, 0, new ArrayList<>());
        return res;
    }

    public static void main(String[] args) {
        LeetCode0131 main = new LeetCode0131();
        System.out.println(main.partition("aab"));
    }
}