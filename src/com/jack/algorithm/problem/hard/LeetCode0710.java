package com.jack.algorithm.problem.hard;

import java.util.*;

/**
 * @author jack
 */
public class LeetCode0710 {

    public static void main(String[] args) {
        Solution main = new Solution(1000000000,
                new int[] {640145908});
        System.out.println(main.pick());
    }
}

class Solution {

    private Random random;
    private Map<Integer, Integer> map;
    private int wLen;
    public Solution(int n, int[] blacklist) {
        random = new Random();
        wLen = n - blacklist.length;
        map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int i = wLen; i < n; i++) {
            set.add(i);
        }
        for (int black : blacklist) {
            set.remove(black);
        }
        Iterator<Integer> iterator = set.iterator();
        for (int black : blacklist) {
            if (black < wLen) {
                map.put(black, iterator.next());
            }
        }
    }

    public int pick() {
        int k = random.nextInt(wLen);
        return map.getOrDefault(k, k);
    }
}