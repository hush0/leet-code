package com.hush.algotithm;

/**
 * @Author: huangshuai
 * @Date: 2020-10-26
 * @Version 1.0
 */
public class Question75 {



    public static  void sortColors(int[] nums) {

       /* int length = nums.length;
        int left = 0;
        int right = length - 1;
        int i = 0;

        while(i<right){
            if(nums[left]== 0){
                left ++;
                continue;
            }
            if(nums[right]==2){
                right --;
                continue;
            }

            if(nums[i] == 0 && nums[left]!= 0){
                nums[left++] = 0;
            } else if (nums[i] == 2 && nums[right]!= 2){
                nums[right--] = 2;
            }

            i++;
        }

        for(int j = left ;j<=right;j++){
            nums[j] =1;
        }*/

        if (nums == null || nums.length <= 1) {
            return;
        }
        int p0 = 0;
        int p2 = nums.length - 1;
        for (int i = p0; i <= p2; i++) {
            if (nums[i] == 0) {
                nums[i] = nums[p0];
                nums[p0++] = 0;
            } else if (nums[i] == 2) {
                nums[i--] = nums[p2];
                nums[p2--] = 2;
            }
        }


    }


    public static void main(String[] args) {

        int[] array = new int[]{2,0,1};
        sortColors(array);
        for(int i=0;i<array.length;i++){
            System.out.println(array[i]);
        }

    }
}
