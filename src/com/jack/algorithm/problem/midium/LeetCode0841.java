package com.jack.algorithm.problem.midium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author jack
 */
public class LeetCode0841 {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int allCount = rooms.size();
        visited = new boolean[allCount];
        dfs(rooms, 0);
        return count == allCount;
    }
    private int count;
    private boolean[] visited;
    private void dfs(List<List<Integer>> rooms, int curRoom) {
        visited[curRoom] = true;
        count ++;
        for (int nextRoom : rooms.get(curRoom)) {
            if (!visited[nextRoom]) {
                dfs(rooms, nextRoom);
            }
        }
    }

    public static void main(String[] args) {
        LeetCode0841 main = new LeetCode0841();
        System.out.println(main.canVisitAllRooms(
                Arrays.asList(
                        Collections.singletonList(1),
                        Collections.singletonList(2),
                        Collections.singletonList(3),
                        new ArrayList<>()
                )
        ));
        System.out.println(main.canVisitAllRooms(
                Arrays.asList(
                        Arrays.asList(1, 3),
                        Arrays.asList(3, 0, 1),
                        Collections.singletonList(2),
                        Collections.singletonList(0)
                )
        ));
    }

}