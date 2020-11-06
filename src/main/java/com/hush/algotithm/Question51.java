package com.hush.algotithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: huangshuai
 * @Date: 2020-10-30
 * @Version 1.0
 */
public class Question51 {


    /**
     * N 皇后问题(回溯)
     * @param n
     * @return
     */
    public static List<List<String>> solveNQueens(int n) {


        //初始化棋盘
        char[][] array = new char[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(array[i],'.');
        }


        List<List<String>> res = new ArrayList<List<String>>();
        dfs(array,0,n,res);
        return res;
    }



    public static void dfs(char[][] array, int begin, int n, List<List<String>> res){

        if (begin == n) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    sb.append(array[i][j]);
                }
                list.add(sb.toString());
            }
            res.add(list);
            return;
        }


        for (int i = 0; i < n; i++) {
            if(check(array,begin,i,n)){
                array[begin][i] = 'Q';
                dfs(array, begin+1, n, res);
                array[begin][i] = '.';
            }

        }
    }



    public static boolean check(char[][] array, int x ,int y, int n){

        //列检查
        for(int i=0;i<n;i++){
            if(array[i][y] == 'Q'){
                return false;
            }
        }


        //正对角线检查
        int i= x-1,j=y+1;
        while (i >= 0 && j < n) {
            if (array[i][j] == 'Q') {
                return false;
            }
            i--;;
            j++;
        }


        //反对角线检查
        i = x - 1;
        j = y - 1;
        while (i >= 0 && j >= 0) {
            if (array[i][j] == 'Q') {
                return false;
            }
            i--;
            j--;
        }

        return true;
    }


    public static void main(String[] args) {
        System.out.println(solveNQueens(4).size());

    }

}
