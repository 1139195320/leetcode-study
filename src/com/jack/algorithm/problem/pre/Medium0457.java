package com.jack.algorithm.problem.pre;

/**
 * @author jack
 */
public class Medium0457 {

    public boolean circularArrayLoop(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return true;
        }
        int i = 0;
        int n = nums.length;
        boolean[] visited = new boolean[nums.length];
        while (i < n) {
            int j = i;
            int count = 0;
            int first = nums[i];
            while (count < 2) {
                visited[j] = true;
                if (first * nums[j] < 0) {
                    // 异号，存在不同方向
                    break;
                }
                j += nums[j];
                if (first > 0) {
                    // 开始就是向右
                    if (j > i) {
                        // j 在 起点右边出现的次数
                        count ++;
                    }
                } else {
                    // 开始就是向左
                    if (j < i) {
                        // j 在 起点左边出现的次数
                        count ++;
                    }
                }
                j = (j + n) % n;
                if (j == i) {
                    // 回到了起点
                    return true;
                }
            }
            while (i < n && visited[i]) {
                // 剪枝
                i ++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Medium0457 main = new Medium0457();
        System.out.println(main.circularArrayLoop(
                new int[]{2, -1, 1, 2, 2}
        ));
        System.out.println(main.circularArrayLoop(
                new int[]{-2, 1, -2, -1, -2}
        ));
        System.out.println(main.circularArrayLoop(
                new int[]{-2, 1, -1, -2, -2}
        ));
    }
}