package com.jack.algorithm.problem.midium;

/**
 * @author jack
 */
public class LeetCode0990 {

    public boolean equationsPossible2(String[] strArr) {
        int[] parent = new int[26];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        // 先看 ==
        for (String str : strArr) {
            if (str.charAt(1) == '=') {
                int a = str.charAt(0) - 'a';
                int b = str.charAt(3) - 'a';
                union(parent, a, b);
            }
        }
        // 再看 !=
        for (String str : strArr) {
            if (str.charAt(1) == '!') {
                int a = str.charAt(0) - 'a';
                int b = str.charAt(3) - 'a';
                if (find(parent, a) == find(parent, b)) {
                    return false;
                }
            }
        }
        return true;
    }
    private void union(int[] parent, int a, int b) {
        parent[find(parent, a)] = find(parent, b);
    }
    private int find(int[] parent, int x) {
        while (x != parent[x]) {
            x = parent[x];
        }
        return x;
    }

    public static void main(String[] args) {
        LeetCode0990 main = new LeetCode0990();
        System.out.println(main.equationsPossible2(new String[]{
                "a==b", "e==c", "b==c", "a!=e"
        }));
        System.out.println(main.equationsPossible2(new String[]{
                "a==b", "b!=a"
        }));
        System.out.println(main.equationsPossible2(new String[]{
                "b==a", "a==b"
        }));
        System.out.println(main.equationsPossible2(new String[]{
                "a==b", "b==c", "a==c"
        }));
        System.out.println(main.equationsPossible2(new String[]{
                "a==b", "b!=c", "c==a"
        }));
        System.out.println(main.equationsPossible2(new String[]{
                "c==c", "b==d", "x!=z"
        }));
    }
}