package com.hush.algotithm;

/**
 * @Author: huangshuai
 * @Date: 2020-11-05
 * @Version 1.0
 */
public class Question543 {



    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int max =0;

    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        deepth(root);
        return max;
    }


    public int deepth(TreeNode head){
        if (head == null) {
            return 0;
        } else {
            int leftdeep = deepth(head.left);
            int rightdeep = deepth(head.right);
            max =  Math.max(leftdeep+rightdeep, max);
            return Math.max(leftdeep, rightdeep) + 1;
        }
    }

}
