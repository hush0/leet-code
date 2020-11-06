package com.hush.algotithm;

/**
 * @Author: huangshuai
 * @Date: 2020-11-04
 * @Version 1.0
 */
public class Question461 {


    public int hammingDistance(int x, int y) {

        int result = x ^ y;
        int count =0;
        while(result!=0){
            result = result & (result-1);
            count++;
        }
        return count;
    }
}
