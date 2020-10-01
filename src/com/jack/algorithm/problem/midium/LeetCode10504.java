package com.jack.algorithm.problem.midium;

/**
 * @author jack
 */
public class LeetCode10504 {

    public int[] findClosedNumbers(int num) {
        // 最接近的较小值:二进制表示中从右向左找前面有0的第一个1,
        //      "10"中的1,0换位,剩下右边的二进制位前后翻转
        // 最接近的较大值:二进制表示中从右向左找前面有1的第一个0,
        //      "01"中的1,0换位,剩下右边的二进制位前后翻转
        if (num == 1) {
            return new int[]{2, -1};
        }
        int[] res = new int[2];
        // 总位数
        int allCount = 0;
        // 1 的个数
        int oneCount = 0;
        // 记录第一个右边有 1 的 0 的位置
        int index1 = 0;
        // 记录第一个右边有 0 的 1 的位置
        int index2 = 0;
        int len = 31;
        int[] maxArr = new int[len];
        int[] minArr = new int[len];
        int i = len - 1;
        char[] arr = Integer.toBinaryString(num).toCharArray();
        boolean hasZero = false, hasOne = false;
        for (int j = arr.length - 1; j >= 0; j --) {
            char c = arr[j];
            maxArr[i] += (c - '0');
            minArr[i] += (c - '0');
            i --;
            if (c == '0') {
                if (hasOne && index1 == 0) {
                    index1 = allCount;
                }
                hasZero = true;
            } else {
                if (hasZero && index2 == 0) {
                    index2 = allCount;
                }
                oneCount ++;
                hasOne = true;
            }
            allCount ++;
        }
        System.out.println(index1 + " => " + index2);
        System.out.println(Integer.toBinaryString(num));
        if (oneCount == allCount) {
            res[1] = -1;
            if (oneCount == len) {
                res[0] = -1;
            } else {
                res[0] = (1 << oneCount) + (num >> 1);
            }
        } else {
            if (oneCount + index1 + 1 == allCount) {
                // 1101 1110 10011
                res[0] = (1 << allCount) + (1 << (oneCount - 1)) - 1;
                res[1] = num - 1;
            } else {
                // 011 101 110
                // 1001 1010 1100
                maxArr[len - 1 - index1] = 1;
                maxArr[len - 1 - index1 + 1] = 0;
                for (int l = index1 - 1, r = 1; r < l; r++,l--) {
                    swap(maxArr, len - r, len - l);
                }
                minArr[len - 1 - index2] = 0;
                minArr[len - 1 - index2 + 1] = 1;
                for (int l = index2 - 1, r = 1; r < l; r++,l--) {
                    swap(minArr, len - r, len - l);
                }
                // 从数组还原数
                for (int k = 0; k < len; k++) {
                    res[0] += maxArr[len - 1 - k] == 1 ? (1 << k) : 0;
                    res[1] += minArr[len - 1 - k] == 1 ? (1 << k) : 0;
                }
            }
        }
        return res;
    }
    private void swap(int[]arr, int x, int y) {
        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }

    public static void main(String[] args) {
        LeetCode10504 main = new LeetCode10504();
        for (int tmp : main.findClosedNumbers(0b101)) {
            System.out.print(tmp == -1 ? -1 : Integer.toBinaryString(tmp));
            System.out.print("   ");
        }
        System.out.println();
        for (int tmp : main.findClosedNumbers(0b1010)) {
            System.out.print(tmp == -1 ? -1 : Integer.toBinaryString(tmp));
            System.out.print("   ");
        }
        System.out.println();
        for (int tmp : main.findClosedNumbers(0b1110)) {
            System.out.print(tmp == -1 ? -1 : Integer.toBinaryString(tmp));
            System.out.print("   ");
        }
        System.out.println();
        System.out.println(Integer.toBinaryString(1837591841));
        System.out.println(0b100010000100011111101011110000);
    }
}
