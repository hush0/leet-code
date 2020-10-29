package com.hush.algotithm;

import java.util.*;

/**
 * @Author: huangshuai
 * @Date: 2020-10-16
 * @Version 1.0
 */
public class Question39 {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        int length = candidates.length;
        List<List<Integer>> result = new ArrayList<>();
        if(length ==0){
            return result;
        }
        Arrays.sort(candidates);
        Deque<Integer> path = new ArrayDeque<>();
        dfs(candidates,0,length,target,path,result);
        return result;
    }

    private static void dfs(int[] candidates, int begin, int len, int target, Deque<Integer> path, List<List<Integer>> res) {


        if(target==0){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i=begin;i<len;i++){

            if (target - candidates[i] < 0) {
                break;
            }

            if (i > begin && candidates[i] == candidates[i - 1]) {
                continue;
            }


            path.add(candidates[i]);
            dfs(candidates,i+1,len,target-candidates[i],path,res);
            path.removeLast();
        }
    }










    public static void main(String[] args) {
        int[] array = {10,1,2,7,6,1,5};
        System.out.println(combinationSum(array,8));

    }
}
