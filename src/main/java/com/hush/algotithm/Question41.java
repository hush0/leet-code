package com.hush.algotithm;

import java.util.Stack;

/**
 * @Author: huangshuai
 * @Date: 2020-06-22
 * @Version 1.0
 */
public class Question41 {

    public static int firstMissingPositive(int[] nums) {
        int length = nums.length;
        for(int i=0;i<length;i++){
            if( nums[i]>0 && nums[i]<length && nums[i]!= i+1){
                int temp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = temp;
            }
        }

        for(int i=0;i<length;i++){
            if(nums[i]!=i+1){
                return i+1;
            }
        }
        return length+1;
    }



    public static void main(String[] args) {
        int[] array ={-1,4,2,1,9,10};
        System.out.println(firstMissingPositive(array));

    }


}
