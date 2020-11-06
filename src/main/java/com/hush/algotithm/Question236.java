package com.hush.algotithm;

/**
 * @Author: huangshuai
 * @Date: 2020-11-05
 * @Version 1.0
 */
public class Question236 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {


        if (root == null || root == p || root == q ) {
           return root;
        } else {
            TreeNode left = lowestCommonAncestor(root.left,p,q);
            TreeNode right = lowestCommonAncestor(root.right,p,q);
            if(left==null){
                return right;
            }
            if(right ==null){
                return left;
            }
            return root;
        }
    }



}
