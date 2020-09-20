package com.jack.algorithm.problem.pre;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jack
 */
public class Medium0767 {

    public String reorganizeString(String S) {
        int n = S.length();
        map = new HashMap<>(n);
        // 存放数和其对应的数量
        for (char c : S.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        // 存放根据数量排的序，从大到小
        List<Character> list = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            addData(list, entry.getKey());
        }
        int maxSize = map.get(list.get(0));
        if (n % 2 == 0) {
            if (maxSize > n / 2) {
                return "";
            }
        } else {
            if (maxSize > n / 2 + 1) {
                return "";
            }
        }
        char[] res = new char[n];
        // 先填充奇数位
        int i = 0;
        int j = 0;
        while (i < n) {
            char cur = list.get(j);
            res[i] = cur;
            int count = map.get(cur) - 1;
            if (count == 0) {
                j ++;
            } else {
                map.put(cur, count);
            }
            i += 2;
        }
        // 再填充偶数位
        i = 1;
        while (i < n) {
            char cur = list.get(j);
            res[i] = cur;
            int count = map.get(cur) - 1;
            if (count == 0) {
                j ++;
            } else {
                map.put(cur, count);
            }
            i += 2;
        }
        return new String(res);
    }
    private Map<Character, Integer> map;
    private void addData(List<Character> list, char data) {
        if (list.size() == 0) {
            list.add(data);
            return;
        }
        int size = list.size();
        int count = map.get(data);
        if (map.get(list.get(size - 1)) >= count) {
            list.add(data);
            return;
        }
        if (map.get(list.get(0)) <= count) {
            list.add(0, data);
            return;
        }
        int l = 0, r = size - 1;
        int idx = 0;
        while (l < r) {
            int m = (l + r) >> 1;
            int c = map.get(list.get(m));
            if (l == m || c == count) {
                idx = m + 1;
                break;
            } else if (c > count) {
                l = m;
            } else {
                r = m;
            }
        }
        list.add(idx, data);
    }

    public static void main(String[] args) {
        Medium0767 main = new Medium0767();
        System.out.println(main.reorganizeString("aab"));
        System.out.println(main.reorganizeString("aaab"));
    }
}