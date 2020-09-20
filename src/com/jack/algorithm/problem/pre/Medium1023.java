package com.jack.algorithm.problem.pre;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jack
 */
public class Medium1023 {

    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> res = new ArrayList<>();
        for (String query : queries) {
            char[] arr = query.toCharArray();
            int pre = 0;
            boolean curRes = true;
            char[] pArr = pattern.toCharArray();
            for (int j = 0; j < pArr.length; j++) {
                // 剩下的字符不够匹配
                if (pArr.length - j > arr.length - pre) {
                    curRes = false;
                    break;
                }
                char c = pArr[j];
                int pos = query.indexOf(c);
                if (pos == -1) {
                    curRes = false;
                    break;
                }
                if (c < 'a') {
                    // 大写
                    if (pos < pre) {
                        curRes = false;
                        break;
                    }
                } else {
                    // 小写
                    while (pos < pre) {
                        arr[pos] = ' ';
                        pos = query.indexOf(c);
                        if (pos == -1) {
                            break;
                        }
                    }
                    if (pos < pre) {
                        curRes = false;
                        break;
                    }
                }
                arr[pos] = ' ';
                pre = pos + 1;
                query = new String(arr);
            }
            if (curRes) {
                // 进一步判断
                // 过滤掉 pattern 后剩余的全是小写
                curRes = (query.equals(query.toLowerCase()));
            }
            res.add(curRes);
        }
        return res;
    }

    public static void main(String[] args) {
        Medium1023 main = new Medium1023();
        System.out.println(main.camelMatch(
                new String[]{"FooBar", "FooBarTest", "FootBall", "FrameBuffer",
                        "ForceFeedBack"}, "FB"
        ));
        System.out.println(main.camelMatch(
                new String[]{"FooBar", "FooBarTest", "FootBall", "FrameBuffer",
                        "ForceFeedBack"}, "FoBa"
        ));
        System.out.println(main.camelMatch(
                new String[]{"FooBar", "FooBarTest", "FootBall", "FrameBuffer",
                        "ForceFeedBack"}, "FoBaT"
        ));
    }
}