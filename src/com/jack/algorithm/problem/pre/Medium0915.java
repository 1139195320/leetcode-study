package com.jack.algorithm.problem.pre;

/**
 * @author jack
 */
public class Medium0915 {

    public int partitionDisjoint(int[] A) {
        int n = A.length;
        int preMax = A[0];
        int t = 0;
        int curMax = preMax;
        for (int i = 1; i < n; i++) {
            int cur = A[i];
            if (cur <= preMax) {
                // 当前数小，更新前面的最大数
                t = i;
                preMax = curMax;
            } else {
                // 当前数比前面最大还要大，记录下来
                curMax = cur;
            }
        }
        return t + 1;
    }

    public static void main(String[] args) {
        Medium0915 main = new Medium0915();
        System.out.println(main.partitionDisjoint(
                new int[]{5, 0, 3, 8, 6}
        ));
        System.out.println(main.partitionDisjoint(
                new int[]{1, 1, 1, 0, 6, 12}
        ));
    }
}