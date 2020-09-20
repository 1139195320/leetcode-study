package com.jack.algorithm.problem.pre;

/**
 * @author jack
 */
public class MediumL10012 {

    public int minTime(int[] time, int m) {
        int n = time.length;
        if (m >= n) {
            return 0;
        }
        // 分成 m 份，每份里面的第二大值的最大值最小
        int lt = Integer.MAX_VALUE, rt = 0, mid, res = 0;
        for (int aTime : time) {
            lt = Math.min(lt, aTime);
            rt += aTime;
        }
        while (lt <= rt) {
            mid = (lt + rt) >> 1;
            // 切割得多了，调大下界
            if (check(time, n, mid, m)) {
                lt = mid + 1;
            } else {
                // 切割得可能少了，调小上界
                rt = mid - 1;
                // 同时记录夹逼值
                res = mid;
            }
        }
        return res;
    }
    private boolean check(int[] time, int len, int limit, int m) {
        // 初始化为1，且当前子数组最大值初始化为第一个元素
        int cnt = 1, sum = time[0], maxVal = time[0];
        // 从第二个元素开始遍历
        for (int i = 1; i < len; i++) {
            sum += time[i];
            maxVal = Math.max(maxVal, time[i]);
            // 划分 第 cnt + 1 个子数组（新的子数组的第一个元素）
            if (sum - maxVal > limit) {
                cnt++;
                maxVal = sum = time[i];
            }
            if (cnt > m) {
                // 当划分的子数组个数超过m时，直接返回true
                return true;
            }
        }
        // 找到一种可能的分割方案
        return false;
    }

    public static void main(String[] args) {
        MediumL10012 main = new MediumL10012();
        System.out.println(main.minTime(
                new int[]{1, 2, 3, 3}, 2
        ));
    }
}