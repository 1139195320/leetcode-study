package com.jack.algorithm.problem.easy;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author jack
 */
public class LeetCode0703 {

    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(
                3, new int[]{4, 5, 8, 2}
        );
        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(5));
        System.out.println(kthLargest.add(10));
        System.out.println(kthLargest.add(9));
        System.out.println(kthLargest.add(9));
        System.out.println(kthLargest.add(4));
    }
}

class KthLargest {

    private int[] nums;
    private int k;
    private int n;

    public KthLargest(int k, int[] nums) {
        this.n = nums.length;
        this.k = k;
        if (k == n) {
            this.nums = nums.clone();
            Arrays.sort(this.nums);
        } else if (k < n){
            this.nums = new int[k];
            Arrays.sort(nums);
            System.arraycopy(nums, n - k, this.nums, 0, k);
            n = k;
        } else {
            this.nums = new int[k];
            Arrays.fill(this.nums, Integer.MIN_VALUE);
            if (n == 0) {
                return;
            }
            Arrays.sort(nums);
            System.arraycopy(nums, 0, this.nums, k - n, n);
        }
    }

    public int add(int val) {
        if (val <= nums[0]) {
            return nums[0];
        }
        if (n < k) {
            n ++;
        }
        if (val >= nums[k - 1]) {
            System.arraycopy(nums, 1, nums, 0,k - 1);
            nums[k - 1] = val;
            return nums[k - n];
        }
        int l = 0, r = k - 1;
        int idx = l;
        while (l < r) {
            int m = (l + r) >> 1;
            if (val == nums[m] || m == l) {
                idx = m;
                break;
            }
            if (val > nums[m]) {
                l = m;
            } else {
                r = m;
            }
        }
        for (int i = 0; i < k; i++) {
            if (i == idx) {
                nums[i] = val;
                break;
            }
            nums[i] = nums[i + 1];
        }
        return nums[k - n];
    }
}

class KthLargest2 {

    private Queue<Integer> queue;
    private int k;

    public KthLargest2(int k, int[] nums) {
        this.queue = new PriorityQueue<>(k);
        this.k = k;
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (queue.size() < k) {
            queue.add(val);
        } else if (val > queue.peek()) {
            queue.remove();
            queue.add(val);
        }
        return queue.peek();
    }
}