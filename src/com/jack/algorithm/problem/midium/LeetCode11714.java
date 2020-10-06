package com.jack.algorithm.problem.midium;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author jack
 */
public class LeetCode11714 {

    public int[] smallestK2(int[] arr, int k) {
        int[] heap = new int[k];
        Arrays.sort(arr);
        System.arraycopy(arr, 0, heap, 0, k);
        return heap;
    }

    public int[] smallestK(int[] arr, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(k + 1);
        Arrays.stream(arr).forEach(num -> heap.offer(num));
        int[] res = new int[k];
        int i = 0;
        while (i < k) {
            res[i ++] = heap.poll();
        }
        return res;
    }
    public int[] smallestK3(int[] arr, int k) {
        return Arrays.stream(arr).sorted().limit(k).toArray();
    }

    public static void main(String[] args) {
        LeetCode11714 main = new LeetCode11714();
        System.out.println(Arrays.toString(main.smallestK2(
                new int[]{1, 3, 5, 7, 2, 4, 6, 8}, 4
        )));
        System.out.println(Arrays.toString(main.smallestK(
                new int[]{1, 3, 5, 7, 2, 4, 6, 8}, 4
        )));
    }
}