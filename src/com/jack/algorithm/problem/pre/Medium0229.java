package com.jack.algorithm.problem.pre;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jack
 */
public class Medium0229 {

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        // 票数 > n / 3，则只有两个候选人有可能
        // i ：表示候选人编号
        // j ：0 是候选人的值，1 是候选人当前相对的票数
        int[][] personCount = new int[2][2];
        for (int num : nums) {
            if (num == personCount[0][0]) {
                // 投票第一个候选人
                personCount[0][1] ++;
            }
            else if (num == personCount[1][0]) {
                // 投票第二个候选人
                personCount[1][1] ++;
            }
            else {
                // 投票新的候选人
                if (personCount[0][1] == 0) {
                    // 候选人1 0票，更换
                    personCount[0][0] = num;
                    personCount[0][1] ++;
                }
                else if (personCount[1][1] == 0) {
                    // 候选人2 0票，更换
                    personCount[1][0] = num;
                    personCount[1][1] ++;
                }
                else {
                    // 候选人1、2都不是 0 票
                    personCount[0][1] --;
                    personCount[1][1] --;
                }
            }
        }
        // 选出来了候选人，开始计票
        personCount[0][1] = 0;
        personCount[1][1] = 0;
        for (int num : nums) {
            if (num == personCount[0][0]) {
                personCount[0][1] ++;
            }
            else if (num == personCount[1][0]) {
                personCount[1][1] ++;
            }
        }
        if (personCount[0][1] > n / 3) {
            res.add(personCount[0][0]);
        }
        if (personCount[1][1] > n / 3) {
            res.add(personCount[1][0]);
        }
        return res;
    }

    public static void main(String[] args) {
        Medium0229 main = new Medium0229();
        System.out.println(main.majorityElement(
                new int[]{3, 2, 3}
        ));
        System.out.println(main.majorityElement(
                new int[]{1, 1, 1, 3, 3, 2, 2, 2}
        ));
    }
}