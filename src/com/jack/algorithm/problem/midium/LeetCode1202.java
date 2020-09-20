package com.jack.algorithm.problem.midium;

import java.util.*;

/**
 * @author jack
 */
public class LeetCode1202 {

    private static class DSU {
        int[] parent;
        DSU(int n) {
            this.parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }
        int find(int z) {
            if (parent[z] != z) {
                parent[z] = find(parent[z]);
                return parent[z];
            } else {
                return z;
            }
        }
        void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px != py) {
                parent[px] = py;
            }
        }
    }

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int MAX = 10_0000;
        DSU dsu = new DSU(MAX);
        for (List<Integer> pair : pairs) {
            dsu.union(pair.get(0), pair.get(1));
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int p = dsu.find(i);
            map.computeIfAbsent(p, k -> new ArrayList<>()).add(i);
        }
        StringBuilder sb = new StringBuilder(s);
        char[] arr;
        for (List<Integer> list : map.values()) {
            int len = list.size();
            if (len > 1) {
                arr = new char[len];
                for (int i = 0; i < len; i++) {
                    arr[i] = sb.charAt(list.get(i));
                }
                Arrays.sort(arr);
                for (int i = 0; i < len; i++) {
                    sb.setCharAt(list.get(i), arr[i]);
                }
            }
        }
        return sb.toString();
    }

    private void test1() {
        List<List<Integer>> pairs = new ArrayList<>();
        List<Integer> pair1 = new ArrayList<>();
        pair1.add(0);
        pair1.add(3);
        pairs.add(pair1);
        List<Integer> pair2 = new ArrayList<>();
        pair2.add(1);
        pair2.add(2);
        pairs.add(pair2);
        System.out.println(smallestStringWithSwaps(
                "dcab", pairs
        ));
    }

    private void test2() {
        List<List<Integer>> pairs = new ArrayList<>();
        List<Integer> pair1 = new ArrayList<>();
        pair1.add(0);
        pair1.add(3);
        pairs.add(pair1);
        List<Integer> pair2 = new ArrayList<>();
        pair2.add(1);
        pair2.add(2);
        pairs.add(pair2);
        List<Integer> pair3 = new ArrayList<>();
        pair3.add(0);
        pair3.add(2);
        pairs.add(pair3);
        System.out.println(smallestStringWithSwaps(
                "dcab", pairs
        ));
    }

    private void test3() {
        List<List<Integer>> pairs = new ArrayList<>();
        List<Integer> pair1 = new ArrayList<>();
        pair1.add(0);
        pair1.add(1);
        pairs.add(pair1);
        List<Integer> pair2 = new ArrayList<>();
        pair2.add(1);
        pair2.add(2);
        pairs.add(pair2);
        System.out.println(smallestStringWithSwaps(
                "cba", pairs
        ));
    }

    public static void main(String[] args) {
        LeetCode1202 main = new LeetCode1202();
        main.test1();
        main.test2();
        main.test3();
    }
}