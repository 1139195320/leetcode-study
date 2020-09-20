package com.jack.algorithm.problem.still;

/**
 * @author fy
 * 官方题解
 * hard
 */
public class LeetCode10051 {

    public static void main(String[] args) {
        LeetCode10051 main = new LeetCode10051();
        System.out.println(main.reversePairs(new int[]{7, 5, 6, 4}));
        System.out.println(main.reversePairs(new int[]{3, 2, 2, 1}));
    }

    public int reversePairs(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        return recursion(nums, 0, len - 1);
    }

    public int recursion(int[] nums, int left, int right) {
        if (left >= right) {
            return 0;
        }
        int mid = (right + left) >> 1;
        // 记录左边的结果
        int l = recursion(nums, left, mid);
        // 记录右边的结果
        int r = recursion(nums, mid + 1, right);
        return (l + r + mergeSort(nums, left, mid, right));

    }

    public int mergeSort(int[] nums, int left, int mid, int right) {
        // left 和 right 都可以取到，所以需要加1
        int[] temp = new int[right - left + 1];
        int ans = 0;
        int cur1 = mid;
        int cur2 = right;
        int cur3 = right - left;
        while (cur1 >= left && cur2 >= mid + 1) {
            if (nums[cur1] <= nums[cur2]) {
                temp[cur3--] = nums[cur2--];
            } else {
                temp[cur3--] = nums[cur1--];
                //比当前 cur2 里面的元素都大
                ans += (cur2 - mid);
            }
        }
        while (cur1 >= left) {
            temp[cur3--] = nums[cur1--];
        }
        while (cur2 >= mid + 1) {
            temp[cur3--] = nums[cur2--];
        }
        int x = 0;
        while (left <= right) {
            nums[left++] = temp[x++];
        }
        return ans;
    }

}
