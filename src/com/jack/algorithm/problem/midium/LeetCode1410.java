package com.jack.algorithm.problem.midium;

/**
 * @author jack
 */
public class LeetCode1410 {

    public String entityParser(String text) {
        return text.replace("&quot;", "\"")
                .replace("&apos;", "'")
                .replace("&gt;", ">")
                .replace("&lt;", "<")
                .replace("&frasl;", "/")
                .replace("&amp;", "&");
    }

    public static void main(String[] args) {
        LeetCode1410 main = new LeetCode1410();
        System.out.println(main.entityParser(
                "&amp; is an HTML entity but &ambassador; is not."));
        System.out.println(main.entityParser(
                "and I quote: &quot;...&quot;"));
        System.out.println(main.entityParser(
                "Stay home! Practice on Leetcode :)"));
        System.out.println(main.entityParser(
                "x &gt; y &amp;&amp; x &lt; y is always false"));
        System.out.println(main.entityParser(
                "leetcode.com&frasl;problemset&frasl;all"));
    }
}