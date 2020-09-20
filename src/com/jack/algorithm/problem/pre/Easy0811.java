package com.jack.algorithm.problem.pre;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jack
 */
public class Easy0811 {

    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for (String cpdomain : cpdomains) {
            String[] arr = cpdomain.split(" ");
            int size = Integer.parseInt(arr[0]);
            String domain = arr[1];
            map.put(domain, map.getOrDefault(domain, 0) + size);
            int i = domain.indexOf('.');
            while (i != -1) {
                domain = domain.substring(i + 1);
                map.put(domain, map.getOrDefault(domain, 0) + size);
                i = domain.indexOf('.');
            }
        }
        List<String> res = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            res.add(entry.getValue() + " " + entry.getKey());
        }
        return res;
    }

    public static void main(String[] args) {
        Easy0811 main = new Easy0811();
        System.out.println(main.subdomainVisits(
                new String[] {
                        "900 google.mail.com",
                        "50 yahoo.com",
                        "1 intel.mail.com",
                        "5 wiki.org"
                }
        ));
        System.out.println(main.subdomainVisits(
                new String[] {
                        "9001 discuss.leetcode.com"
                }
        ));
    }
}