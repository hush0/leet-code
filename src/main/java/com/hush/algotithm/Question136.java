package com.hush.algotithm;

/**
 * @Author: huangshuai
 * @Date: 2020-10-29
 * @Version 1.0
 */
public class Question136 {

    public int singleNumber(int[] nums) {

        int length = nums.length;
        int result = nums[0];
        for(int i = 1;i<length;i++){
            result = result ^ nums[i];
        }
        return result;

    }


    public static void main(String[] args) {

    }
}
