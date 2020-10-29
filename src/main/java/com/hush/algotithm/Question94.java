package com.hush.algotithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: huangshuai
 * @Date: 2020-10-28
 * @Version 1.0
 */
public class Question94 {


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

    public static  List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        if(root==null){
            return result;
        }

        if(root.left!=null){
            result.addAll(inorderTraversal(root.left));
        }

        result.add(root.val);

        if(root.right!=null){
            result.addAll(inorderTraversal(root.right));
        }
        return result;
    }


    public static void main(String[] args) {

    }
}
