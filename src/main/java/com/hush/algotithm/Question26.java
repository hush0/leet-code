package com.hush.algotithm;

/**
 * @Author: huangshuai
 * @Date: 2020-07-09
 * @Version 1.0
 */
public class Question26 {


    /**
     * leetcode-26
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        int length = nums.length;
        int i = 0;
        for (int j = i + 1; j < length;) {
            if(nums[i]==nums[j]){
                j++;
            }else{
                i++;
                int temp = nums[j];
                nums[i] = nums[j];
                j++;
            }
        }
        return i+1;
    }


    public static void main(String[] args) {

    }
}
