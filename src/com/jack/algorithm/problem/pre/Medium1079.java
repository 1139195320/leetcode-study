package com.jack.algorithm.problem.pre;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jack
 */
public class Medium1079 {

    private boolean[] visited;
    private Set<String> set;
    public int numTilePossibilities(String tiles) {
        visited = new boolean[tiles.length()];
        set = new HashSet<>();
        dfs(tiles, "");
        return set.size() - 1;
    }
    private void dfs(String tiles, String preStr) {
        set.add(preStr);
        for (int i = 0; i < tiles.length(); i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            dfs(tiles, preStr + tiles.charAt(i));
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        Medium1079 main = new Medium1079();
        System.out.println(main.numTilePossibilities("AAABBC"));
        System.out.println(main.numTilePossibilities("ABCDEFG"));
    }
}