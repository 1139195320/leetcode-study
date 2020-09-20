package com.jack.algorithm.problem.pre;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jack
 */
public class Medium1520 {

    public List<String> maxNumOfSubstrings(String s) {
        List<String> res = new ArrayList<>();
        int n = s.length();
        Map<Character, String> map = new HashMap<>(n);
        char[] arr = s.toCharArray();
        int i = 0;
        while (i < n) {
            char cur = arr[i];
            StringBuilder sb = new StringBuilder();
            sb.append(cur);
            while (i + 1 < n && arr[i + 1] == cur) {
                i ++;
                sb.append(cur);
            }
            if (map.containsKey(cur)) {
                res.remove(map.get(cur));
            } else {
                String str = sb.toString();
                res.add(str);
                map.put(cur, str);
            }
            i ++;
        }
        return res;
    }

    public static void main(String[] args) {
        Medium1520 main = new Medium1520();
        System.out.println(main.maxNumOfSubstrings("adefaddaccc"));
        System.out.println(main.maxNumOfSubstrings("abbaccd"));
    }
}