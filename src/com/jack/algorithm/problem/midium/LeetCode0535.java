package com.jack.algorithm.problem.midium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jack
 */
public class LeetCode0535 {

    public static void main(String[] args) {
        Codec main = new Codec();
        System.out.println(main.decode(main.encode("http://www.baidu.com")));
    }
}

class Codec {

    private int count = 0;
    private Map<Integer, String> map = new HashMap<>();
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        map.put(count, longUrl);
        return "http://tinyurl.com/" + count ++;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(Integer.parseInt(
                shortUrl.replace("http://tinyurl.com/", "")));
    }
}