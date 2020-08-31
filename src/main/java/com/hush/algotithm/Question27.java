package com.hush.algotithm;

/**
 * @Author: huangshuai
 * @Date: 2020-07-09
 * @Version 1.0
 */
public class Question27 {

    public static int removeElement(int[] nums, int val) {

        int length = nums.length;
        int i ;
        for ( i = 0; i < length; ) {
            if (nums[i] != val) {
                i++;
                continue;
            }
            int j = i + 1;
            while (j < length) {
                if (nums[j] == val) {
                    j++;
                } else {
                    break;
                }
            }
            if (j < length) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }else {
                break;
            }
        }
        return i;
    }

    public static void main(String[] args) {

        int[] array = {3, 2, 2, 3};
        int length = removeElement(array, 2);
        System.out.println(length);
    }
}
