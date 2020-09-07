package com.hush.algotithm;

/**
 * @Author: huangshuai
 * @Date: 2020-07-09
 * @Version 1.0
 */
public class Question48 {

    /**
     * nxn 矩阵旋转 leetcode-48
     * @param matrix
     */
    public static void rotate(int[][] matrix) {
        int length = matrix[0].length;

        //矩阵转秩
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        //水平翻转
        for(int i=0;i<length;i++){
            int j = 0, k = length - 1;
            while(j<k){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][k];
                matrix[i][k] = temp;
                j++;
                k--;
            }
        }
    }


    public static void main(String[] args) {

        int[][] array = {{1,2,3},{4,5,6},{7,8,9}};
        rotate(array);
        System.out.println("haha!");
    }

}
