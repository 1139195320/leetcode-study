package com.jack.algorithm.problem.midium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jack
 */
public class LeetCode1093 {

    public double[] sampleStats(int[] count) {
        // 最小值、最大值、平均值、中位数和众数
        double minNum = -1;
        double maxNum = 0;
        double moreNum = -1;
        int moreSize = 0;
        int size = 0;
        double sum = 0;
        double median = 0;
        Map<Integer, Integer> map = new HashMap<>(255);
        for (int i = 0; i < count.length; i++) {
            int curSize = count[i];
            if (curSize > 0) {
                map.put(i, curSize);
                if (minNum == -1) {
                    minNum = i;
                }
                maxNum = i;
                if (curSize > moreSize) {
                    moreNum = i;
                    moreSize = curSize;
                }
                sum += curSize * i;
            }
            size += curSize;
        }
        int pre = 0;
        int curSizeAll = 0;
        int i = size / 2;
        boolean flag = false;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int data = entry.getKey();
            int curSize = entry.getValue();
            curSizeAll += curSize;
            if (curSizeAll > i) {
                median = data;
                if (flag) {
                    median += pre;
                    median /= 2.0;
                }
                break;
            } else if (curSizeAll == i && size % 2 == 0) {
                // 总共偶数个
                flag = true;
                pre = data;
            }
        }
        double avg = sum / size;
        return new double[] {minNum, maxNum, avg, median, moreNum};
    }

    public static void main(String[] args) {
        LeetCode1093 main = new LeetCode1093();
        System.out.println(Arrays.toString(
                main.sampleStats(
                        new int[] {
                                0,1,3,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0
                        }
                )
        ));
        System.out.println(Arrays.toString(
                main.sampleStats(
                        new int[] {
                                0,4,3,2,2,0,0,0,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0
                        }
                )
        ));
    }
}