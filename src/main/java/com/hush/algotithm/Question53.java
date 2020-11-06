package com.hush.algotithm;

/**
 * @Author: huangshuai
 * @Date: 2020-10-29
 * @Version 1.0
 */
public class Question53 {


    public static int maxSubArray(int[] nums) {
        int count = 0;
        int result = 0;
        if (nums == null || nums.length == 0) {
            return count;
        }
        count = nums[0];
        result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(count < 0 ){
                count = nums[i];
            } else {
                count += nums[i];
            }
            if(count> result){
                result = count;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));

    }
}
