package com.jack.algorithm.problem.midium;

import java.util.Stack;

/**
 * @author jack
 */
public class LeetCode0880 {

    public static void main(String[] args) {
        LeetCode0880 main = new LeetCode0880();
        System.out.println(
                main.decodeAtIndex2("a23", 6)
        );
        System.out.println(
                main.decodeAtIndex2("mpq2qduwvu8tu2myo2xs", 169)
        );
        System.out.println(
                main.decodeAtIndex2("vzpp636m8y" , 2920)
        );
        System.out.println(
                main.decodeAtIndex2("a2b3c4d5e6f7g8h9", 9)
        );
        System.out.println(
                main.decodeAtIndex2("abc2de23", 4)
        );
        System.out.println(
                main.decodeAtIndex2("leet2code3", 10)
        );
        System.out.println(
                main.decodeAtIndex2("a2345678999999999999999", 1)
        );

//        int MOD = 1_000_000_007;
//        long i = 234567899;
//        System.out.println(i * MOD);
//        System.out.println(234567899 % MOD * 10 + 9);
    }

    public String decodeAtIndex2(String S, int K) {
        String res = "";
        // 当前读取了的字符串
        Stack<String> strStack = new Stack<>();
        // 当前读取了的每个字符串后面跟的倍数
        Stack<Integer> countStack = new Stack<>();
        // 当前读取的字符串总长
        long curCount = 0;
        for (int i = 0; i < S.length(); i ++) {
            char c = S.charAt(i);
            int j = i;
            if (!Character.isDigit(c)) {
                // 读取完整的一个字符串，直到下一个字符是数字
                while (!Character.isDigit(c = S.charAt(j))) {
                    if (curCount + (j - i) == K - 1) {
                        // 说明现在已经找到目标，不需要继续读取
                        return c + "";
                    }
                    j ++;
                    if (j == S.length()) {
                        break;
                    }
                }
                strStack.push(S.substring(i, j));
                curCount = curCount + (j - i);
                // 上面 j 多加了 1，需减掉
                i = j - 1;
            } else {
                int tmp = c - '0';
                if (countStack.size() < strStack.size()) {
                    countStack.push(tmp);
                } else {
                    // 两个 stack 数量相等
                    // 说明 stack 里面最后一个值也是当前字符串后面的倍数
                    // 将其累乘
                    countStack.push(countStack.pop() * tmp);
                }
                curCount *= tmp;
            }
            // 此时已读取字符串总长度达到了 K
            // 说明目标已在读取之内
            if (K <= curCount) {
                String str = "";
                while (K <= curCount && K != 0 && !countStack.empty()) {
                    // pop count 来将 K 化小
                    int count = countStack.pop();
                    curCount /= count;
                    // 求模可以剔除重复部分
                    K %= curCount;
                    str = strStack.pop();
                    if (K <= curCount - str.length()) {
                        curCount -= str.length();
                    } else {
                        // 说明目标就在此 str 中
                        return str.charAt((int) (str.length() - (curCount - K) - 1)) + "";
                    }
                }
                if (K == 0 || K == curCount) {
                    // K 现在被整除了，说明目标是此 str 的最后一个字符
                    K = str.length() - 1;
                } else {
                    // 因为第一个是 index 为 0 开始
                    K --;
                }
                res = str.charAt(K) + "";
                break;
            }
        }
        return res;
    }

    public String decodeAtIndex(String S, int K) {
        // 严重超时或超内存
        // 应该避免将实际字符串给组出来
        // 因为字符串里面可能会有很大数字
        int i = 0;
        String cur = "";
        while (i < S.length()) {
            char c = S.charAt(i);
            if (Character.isDigit(c)) {
                cur = getStr(cur, c - '0');
            } else {
                cur += c;
            }
            if (i == K - 1) {
                return cur.charAt(K - 1) + "";
            }
            i ++;
        }
        return cur.charAt(K - 1) + "";
    }
    private String getStr(String src, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(src);
        }
        return sb.toString();
    }
}