package com.hush.algotithm;

import java.util.Arrays;

/**
 * @Author: huangshuai
 * @Date: 2020-10-29
 * @Version 1.0
 */
public class Question128 {

    public  static int longestConsecutive(int[] nums) {

        if (nums == null || nums.length==0) {
            return 0;
        }

        Arrays.sort(nums);
        int result = 1, count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] + 1 == nums[i]) {
                count++;
                if (count > result) {
                    result = count;
                }
            } else if( nums[i - 1] == nums[i]){
                continue;
            } else {
                count = 1;
            }
        }

        return result;

    }


    public static void main(String[] args) {
        int[] nums =  new int[]{1,2,0,1};
        System.out.println(longestConsecutive(nums));

    }
}
