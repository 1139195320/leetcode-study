package com.jack.algorithm.problem.midium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jack
 */
public class LeetCode0210 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] input = new int[numCourses];
        int[] res = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        // 统计节点的入度
        for(int[] edge : prerequisites) {
            input[edge[0]]++;
        }
        // 将入度为0的点入队
        for(int i = 0; i < numCourses; i++) {
            if (input[i] == 0) {
                queue.offer(i);
            }
        }
        int idx = 0;
        while(!queue.isEmpty()) {
            int temp = queue.poll();
            res[idx++] = temp;
            // 修改节点入度
            for(int[] edge : prerequisites) {
                if (edge[1] == temp) {
                    input[edge[0]]--;
                    if (input[edge[0]] == 0) {
                        queue.offer(edge[0]);
                    }
                }
            }
        }
        // 出现环了(res中没包括所有点, idx没走完)
        if(idx != numCourses) {
            return new int[] {};
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode0210 main = new LeetCode0210();
        System.out.println(Arrays.toString(
                main.findOrder(3, new int[][]{
                        {2, 0},
                        {2, 1},
                })
        ));
        System.out.println(Arrays.toString(
                main.findOrder(2, new int[][]{
                        {1, 0},
                        {0, 1},
                })
        ));
        System.out.println(Arrays.toString(
                main.findOrder(3, new int[][]{
                        {1, 0},
                })
        ));
        System.out.println(Arrays.toString(
                main.findOrder(4, new int[][]{
                        {1, 0},
                        {2, 0},
                        {3, 1},
                        {3, 2},
                })
        ));
        System.out.println(Arrays.toString(
                main.findOrder(4, new int[][]{
                        {1, 0},
                        {3, 0},
                        {3, 1},
                        {3, 2},
                })
        ));
    }
}
