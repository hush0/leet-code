package com.hush.algotithm;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: huangshuai
 * @Date: 2020-10-28
 * @Version 1.0
 */
public class Question102 {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
        Queue<TreeNode> queue2 = new LinkedList<TreeNode>();
        TreeNode current  = root;
        if (current != null) {
            queue1.add(current);
        }
        while(!queue1.isEmpty() || !queue1.isEmpty()){

            List<Integer> list = new ArrayList<>();
            while(!queue1.isEmpty()){
                current = queue1.poll();
                list.add(current.val);
                
                if(current.left!=null){
                    queue2.add(current.left);
                }
                if(current.right!=null){      
                    queue2.add(current.right);
                }
            }
            if(list.size()>0){
                result.add(list);
            }
            
                                                                           
            List<Integer> list1 = new ArrayList<>();
            while(!queue2.isEmpty()){
                current = queue2.poll();
                list1.add(current.val);

                if(current.left!=null){
                    queue1.add(current.left);
                }
                if(current.right!=null){
                    queue1.add(current.right);
                }
            }
            if(list1.size()>0){
               result.add(list1);
            }
            
        }


        return result;
    }


    public static void main(String[] args) {

    }
}
