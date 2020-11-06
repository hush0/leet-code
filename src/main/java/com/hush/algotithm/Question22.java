package com.hush.algotithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: huangshuai
 * @Date: 2020-11-02
 * @Version 1.0
 */
public class Question22 {

    public static List<String> generateParenthesis(int n) {

        List<String> list = new ArrayList<>();
        dfs(list,new StringBuilder(),0,0,n);
        return list;



    }

    public static void dfs(List<String> list,StringBuilder sb, int begin,int end,int max){
        if(sb.length() == max*2){
            list.add(sb.toString());
        }

        if (begin < max) {
            sb.append("(");
            dfs(list,sb,begin+1,end,max);
            sb.deleteCharAt(sb.length()-1);
        }

        if (end < begin) {
            sb.append(")");
            dfs(list,sb,begin,end+1,max);
            sb.deleteCharAt(sb.length()-1);
        }
    }


    public static void main(String[] args) {

        System.out.println(generateParenthesis(3).toString());

    }
}
