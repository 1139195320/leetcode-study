package com.jack.algorithm.problem.midium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jack
 */
public class LeetCode11713 {

    public int respace(String[] dictionary, String sentence) {
        Tire tire = new Tire();
        for (String s : dictionary) {
            tire.add(s);
        }
        int n = sentence.length();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            Tire cur = tire;
            for (int j = i; j >= 1; j--) {
                char c = sentence.charAt(j - 1);
                cur = cur.child.get(c);
                if (cur == null) {
                    break;
                } else if (cur.isWord) {
                    dp[i] = Math.min(dp[i], dp[j - 1]);
                }
                if (dp[i] == 0) {
                    break;
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        LeetCode11713 main = new LeetCode11713();
        System.out.println(main.respace(
                new String[] {"looked","just","like","her","brother"},
                "jesslookedjustliketimherbrother"
        ));
    }
}

class Tire {
    boolean isWord;
    Map<Character, Tire> child;
    Tire() {
        child = new HashMap<>();
    }
    void add(String s) {
        // 倒序插入
        Tire cur = this;
        Map<Character, Tire> map = cur.child;
        int i = s.length() - 1;
        while (i >= 0) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, new Tire());
            }
            cur = map.get(c);
            map = cur.child;
            i --;
        }
        cur.isWord = true;
    }
    boolean search(String s) {
        // 倒序搜索
        return doSearch(s, s.length() - 1, this);
    }
    private boolean doSearch(String s, int i, Tire tire) {
        if (i == -1) {
            return tire.isWord;
        }
        char c = s.charAt(i);
        Map<Character, Tire> map = tire.child;
        Tire nextTire = map.get(c);
        if (nextTire == null) {
            return false;
        }
        return doSearch(s, i - 1, nextTire);
    }
}