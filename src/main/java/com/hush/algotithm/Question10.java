package com.hush.algotithm;

/**
 * @Author: huangshuai
 * @Date: 2020-06-22
 * @Version 1.0
 */
public class Question10 {

    public boolean isMatch(String s, String p) {

        if (p.isEmpty()) return s.isEmpty();
        boolean first_match = (!s.isEmpty() &&
                (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.'));

        if (p.length() >= 2 && p.charAt(1) == '*'){
            return (isMatch(s, p.substring(2)) ||
                    (first_match && isMatch(s.substring(1), p)));
        } else {
            return first_match && isMatch(s.substring(1), p.substring(1));
        }
    }
    //参考地址:https://www.cnblogs.com/enjoy233/p/10408677.html
}
