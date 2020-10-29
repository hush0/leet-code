package com.hush.algotithm;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Author: huangshuai
 * @Date: 2020-08-27
 * @Version 1.0
 */
public class Question77 {


    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (n < k || k <= 0) {
            return result;
        }
        Deque<Integer> path = new ArrayDeque<>();
        dfs(n, k, 1, path, result);
        return result;
    }

    private static void dfs(int n, int k, int begin, Deque<Integer> path, List<List<Integer>> res) {
        // 递归终止条件是：path 的长度等于 k
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }



        // 遍历可能的搜索起点 n-(k-path.size())+1  后面的节点没必要再搜索了，凑不齐组合需要的数
        for (int i = begin; i <= n-(k-path.size())+1; i++) {
            // 向路径变量里添加一个数
            path.addLast(i);
            // 下一轮搜索，设置的搜索起点要加 1，因为组合数理不允许出现重复的元素
            dfs(n, k, i + 1, path, res);
            // 重点理解这里：深度优先遍历有回头的过程，因此递归之前做了什么，递归之后需要做相同操作的逆向操作
            path.removeLast();
        }
    }



    public static void main(String[] args) {
        System.out.println(combine(4,2));
    }
}
