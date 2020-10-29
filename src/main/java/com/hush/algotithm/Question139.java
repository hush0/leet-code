package com.hush.algotithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: huangshuai
 * @Date: 2020-10-26
 * @Version 1.0
 */
public class Question139 {

    public static  boolean wordBreak(String s, List<String> wordDict) {

        Set<String> set = new HashSet<>();
        set.addAll(wordDict);

        int begin = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            if(set.contains(s.substring(begin,i))){
                begin = i;
            }
        }
         return begin == length;

    }


    public static void main(String[] args) {
        String s = "catsanddog";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cats");
        wordDict.add("dog");
        wordDict.add("sand");
        wordDict.add("and");
        wordDict.add("cat");
        System.out.println(s.substring(0,3));
        System.out.println(s.substring(3,6));

        System.out.println(wordBreak(s, wordDict));
    }
}
