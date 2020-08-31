package com.hush.algotithm;

/**
 * @Author: huangshuai
 * @Date: 2020-08-27
 * @Version 1.0
 */
public class Question38 {

    /**
     * 外观数列 leetcode-38
     * @param n
     * @return
     */
    public static  String countAndSay(int n) {

        if(n==1){
            return "1";
        }
        String tempStr = countAndSay(n-1);
        int length = tempStr.length();
        StringBuilder builder = new StringBuilder();
        int count =0;
        char ch = tempStr.charAt(0);
        for(int i=0;i<length;i++){
            if(tempStr.charAt(i) == ch){
                count++;
            }else {
                builder.append(count);
                builder.append(ch);
                count=1;
                ch = tempStr.charAt(i);
            }
        }
        builder.append(count);
        builder.append(ch);
        return builder.toString();
    }


    public static void main(String[] args) {
        System.out.println(countAndSay(4));
    }

}
