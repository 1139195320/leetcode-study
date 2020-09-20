package com.jack.algorithm.problem.pre;

import java.util.Arrays;

/**
 * @author jack
 */
public class Medium11714 {

    public int[] smallestK2(int[] arr, int k) {
        int[] heap = new int[k];
        Arrays.sort(arr);
        System.arraycopy(arr, 0, heap, 0, k);
        return heap;
    }
    public int[] smallestK(int[] arr, int k) {
        int[] heap = new int[k];
        Arrays.fill(heap, 1_00_00_1);
        for (int num : arr) {
            addToHeap(heap, num);
        }
        return heap;
    }
    private static void addToHeap(int[] heap, int num) {
        if (num < heap[0]) {
            heap[0] = num;
            for (int i = (heap.length / 2 - 1); i >= 0; i--) {
                buildHeap(heap, i);
            }
        }
    }
    private static void buildHeap(int[] heap, int i) {
        int l = (i << 1) + 1;
        int r = (i + 1) << 1;
        int tmp = i;
        if (l < heap.length && heap[i] < heap[l]) {
            // 左子节点大于根节点
            tmp = l;
        }
        if (r < heap.length && heap[tmp] < heap[r]) {
            // 右子节点大于根节点
            tmp = r;
        }
        if (tmp == i) {
            // 左右子节点均小于根节点，正常
            return;
        }
        swap(heap, i, tmp);
        buildHeap(heap, tmp);
    }
    private static void swap (int[] nums, int m, int n) {
        int temp = nums[m];
        nums[m] = nums[n];
        nums[n] = temp;
    }

    public static void main(String[] args) {
        Medium11714 main = new Medium11714();
        System.out.println(Arrays.toString(main.smallestK2(
                new int[]{1, 3, 5, 7, 2, 4, 6, 8}, 4
        )));
        System.out.println(Arrays.toString(main.smallestK(
                new int[]{1, 3, 5, 7, 2, 4, 6, 8}, 4
        )));
    }
}