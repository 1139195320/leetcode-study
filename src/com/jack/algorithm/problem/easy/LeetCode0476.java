package com.jack.algorithm.problem.easy;

/**
 * @author jack
 */
public class LeetCode0476 {

    public int findComplement(int num) {
        if (num == 0) {
            return 1;
        }
        char[] arr = Integer.toBinaryString(num).toCharArray();
        int res = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            res += (1 << (n - i - 1)) * (arr[i] == '0' ? 1 : 0);
        }
        return res;
    }

    public int findComplement2(int num) {
        // 找到大于等于 num 的 111...1 与 num 相异或
        if (num >= (Integer.MAX_VALUE >> 1)) {
            return Integer.MAX_VALUE ^ num;
        }
        int tmp = 1;
        while (tmp <= num) {
            tmp <<= 1;
        }
        return (tmp - 1) ^ num;
    }
}
